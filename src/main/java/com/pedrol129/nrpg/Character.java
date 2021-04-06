package com.pedrol129.nrpg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pedrol129.nrpg.item.entity.Item;
import com.pedrol129.nrpg.item.entity.Shield;
import com.pedrol129.nrpg.item.entity.Weapon;
import com.pedrol129.nrpg.race.entity.Race;
import com.pedrol129.nrpg.race.repository.RaceRepository;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Getter
@Log4j2
public class Character {
	protected String name;
	protected int raceId;
	protected Race race;
	protected int life;
	protected int level;
	protected int attack;
	protected int defense;
	protected List<Item> inventory;
	protected Map<String, Item> equipped;
	
	public Character() {
		this.inventory = new ArrayList<Item>();
		this.equipped = new HashMap<String, Item>();
	}

	public void damage(int damage) {
		log.info(this.life);
		this.life -= damage;
		log.info(this.life);
	}

	public Race getRace() {
		if (race == null) {
			this.race = RaceRepository.getRace(raceId);
		}

		return race;
	}

	public int getCombinedDefense() {
		int combinedDefense = this.defense;

		for (Item item : this.equipped.values()) {
			if (item.getIdType() == 2) {
				combinedDefense += ((Shield) item).getDefense();
			}
		}

		return combinedDefense;
	}

	public int getCombinedAttack() {
		int combinedAttack = this.attack;

		for (Item item : this.equipped.values()) {
			if (item.getIdType() == 1) {
				combinedAttack += ((Weapon) item).getAttack();
			}
		}

		return combinedAttack;
	}
}

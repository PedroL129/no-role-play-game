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
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Getter
@Log4j2
@ToString
public class Character {
	protected String name;
	protected int raceId;
	protected Race race;
	protected int life;
	protected int level;

	// Deprecated
	protected int attack;
	protected int defense;
	protected int magicAttack;
	protected int magicDefense;
	
	// Physical attributes
	protected int strength;
	protected int vitality;
	protected int resistance;

	// Mental attributes 
	protected int dextery;
	protected int intelligence;
	protected int charisma;
	protected int wisdom;
	protected int willpower;
	protected int perception;
	
	protected List<Item> inventory;
	protected List<Item> equippedItems;
	protected Map<String, String> equipped;

	public Character() {
		this.inventory = new ArrayList<>();
		this.equipped = new HashMap<>();
		this.equippedItems = new ArrayList<Item>();
	}

	public void damage(int damage) {
		this.life -= damage;
	}

	public Race getRace() {
		if (race == null) {
			this.race = RaceRepository.getRace(raceId);
		}

		return race;
	}

	public int getCombinedDefense() {
		int combinedDefense = this.defense;

		for (Item item : this.equippedItems) {
			if (item.getIdType() == 2) {
				combinedDefense += ((Shield) item).getDefense();
			}
		}

		return combinedDefense;
	}

	public int getCombinedAttack() {
		int combinedAttack = this.attack;

		for (Item item : this.equippedItems) {
			if (item.getIdType() == 1) {
				combinedAttack += ((Weapon) item).getAttack();
			}
		}

		return combinedAttack;
	}

	public void equipItem(Item item, String[] positions) {
		this.equippedItems.add(item);
		for (String position : positions) {
			this.equipped.put(position, item.getUniqueID());
		}
	}

	public Item getEquippedItemByUID(String uid) {
		return this.equippedItems.stream().filter(item -> item.getUniqueID().equals(uid)).findFirst().orElseGet(null);
	}
}

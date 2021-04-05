package com.pedrol129.nrpg;

import java.util.List;
import java.util.Map;

import com.pedrol129.nrpg.item.entity.ItemEntity;
import com.pedrol129.nrpg.item.entity.WeaponEntity;
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
	protected List<ItemEntity> inventory;
	protected Map<String, ItemEntity> equipped;
	protected WeaponEntity weapon;

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
}

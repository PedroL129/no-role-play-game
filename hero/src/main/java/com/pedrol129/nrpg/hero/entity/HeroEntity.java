package com.pedrol129.nrpg.hero.entity;

import com.pedrol129.nrpg.race.entity.RaceEntity;

public class HeroEntity {
	public String name;
	public RaceEntity race;

	public HeroEntity(String name, RaceEntity race) {
		this.name = name;
		this.race = race;
	}

	@Override
	public String toString() {
		return String.format("I am %s the %s", this.name, this.race);
	}

}
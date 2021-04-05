package com.pedrol129.nrpg.hero.repository;

import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.race.entity.Race;

public class HeroRepository {

	public Hero createHeroEntity(String name, Race race) {
		return new Hero(name, race);
	}
}

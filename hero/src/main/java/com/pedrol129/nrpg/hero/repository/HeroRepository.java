package com.pedrol129.nrpg.hero.repository;

import org.springframework.stereotype.Component;

import com.pedrol129.nrpg.hero.entity.HeroEntity;
import com.pedrol129.nrpg.raceclient.model.RaceEntity;

@Component
public class HeroRepository {

	public HeroEntity createHeroEntity(String name, RaceEntity race) {
		return new HeroEntity(name, race);
	}
}

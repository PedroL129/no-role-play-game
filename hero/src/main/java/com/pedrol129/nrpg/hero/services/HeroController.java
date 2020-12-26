package com.pedrol129.nrpg.hero.services;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pedrol129.nrpg.hero.entity.HeroEntity;
import com.pedrol129.nrpg.hero.repository.HeroRepository;
import com.pedrol129.nrpg.raceclient.model.RaceEntity;

@RestController
public class HeroController {
	
	@Autowired
	private HeroRepository heroRepository;

	@PostMapping("/hero")
	public HeroEntity createHero(@RequestBody RaceEntity race, @PathParam(value = "name") String name ) {
		return this.heroRepository.createHeroEntity(name, race);
	}
}

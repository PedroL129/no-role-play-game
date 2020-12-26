package com.pedrol129.nrpg.game.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pedrol129.nrpg.game.batch.GameProcessor;
import com.pedrol129.nrpg.heroclient.model.HeroEntity;

@RestController
public class GameController {
	private static final Logger log = LoggerFactory.getLogger(GameController.class);

	private final GameProcessor batch;
	
	public GameController(GameProcessor batch) {
		this.batch = batch;
	}
	
	@PostMapping("/start")
	public HeroEntity start(@RequestBody HeroEntity hero) {
		log.debug("Enter start");
		batch.run(hero);
		log.debug("End start");
		return hero;
	}
}

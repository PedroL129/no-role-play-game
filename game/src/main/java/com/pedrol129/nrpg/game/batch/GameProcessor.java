package com.pedrol129.nrpg.game.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.pedrol129.nrpg.hero.entity.HeroEntity;

@Service
public class GameProcessor {
	private static final Logger log = LoggerFactory.getLogger(GameProcessor.class);

	@Async
	public void run(HeroEntity hero) {

		int count = 0;

		while (count < 100) { 
			log.debug("Count: {} Hero: {}",count, hero.toString());
			count++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

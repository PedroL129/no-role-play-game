package com.pedrol129.nrpg.game.batch;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.pedrol129.nrpg.heroclient.model.HeroEntity;
import com.pedrol129.nrpg.mapclient.api.MapControllerApi;
import com.pedrol129.nrpg.mapclient.invoker.ApiException;

@Service
public class GameProcessor {
	private static final Logger log = LoggerFactory.getLogger(GameProcessor.class);
	private boolean play = true; 

	@Autowired
	MapControllerApi mapApi;

	@Async
	public void run(HeroEntity hero) {

		int count = 0;

		while (play && count < 100) {
			log.debug("Count: {} Hero: {}", count, hero.toString());
			count++;
			try {
				getMap();
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void getMap() throws ApiException {
		log.info(this.mapApi.getMaps().toString());
	}
	
	@PreDestroy
	private void preDestroy() {
		this.play = false;
	}
}

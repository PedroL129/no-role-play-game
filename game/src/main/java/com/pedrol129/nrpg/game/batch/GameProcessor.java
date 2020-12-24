package com.pedrol129.nrpg.game.batch;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	
	
	private void getMap() {
		final String uri = "http://localhost:8083/map";
		RestTemplate restTemplate = new RestTemplate();
	     
	    Object result = restTemplate.getForObject(uri, Object.class);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	 
	    return builder
	            .setConnectTimeout(Duration.ofMillis(3000))
	            .setReadTimeout(Duration.ofMillis(3000))
	            .build();
	}
}

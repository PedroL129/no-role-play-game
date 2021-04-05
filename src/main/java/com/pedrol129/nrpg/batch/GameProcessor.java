package com.pedrol129.nrpg.batch;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.pedrol129.nrpg.cli.Intro;
import com.pedrol129.nrpg.enemy.entity.Enemy;
import com.pedrol129.nrpg.enemy.repository.EnemyRepository;
import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.map.controller.MapController;
import com.pedrol129.nrpg.map.entity.Zone;
import com.pedrol129.nrpg.map.repository.ZoneRepository;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class GameProcessor {
	private boolean play = true;

	public void run() {

		Hero hero = Intro.getHero();

		log.info(hero.toString());

		int[][] generatedMap = MapController.generateMap();

		int posY = new Random().nextInt(generatedMap.length);
		int posX = new Random().nextInt(generatedMap[posY].length);

		while (hero.getLife() > 0) {
			Zone zone = ZoneRepository.getZone(generatedMap[posY][posX]);
			log.info("I am in {} - Y:{}, X:{}", zone,posY,posX);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				log.error("Error while sleep thread", e);
			}
			
			if (MapController.meetAnEnemy(zone)) {
				Enemy enemy = EnemyRepository.getEnemies().get(0);
			
				boolean youWin = BattleProcessor.fight(hero, enemy);
				if(youWin) {
					hero.addExperience(20);
				}else {
					break;
				}
			}

			int nextY = this.moveTo(posY);
			int nextX = this.moveTo(posX);
			
			if(generatedMap.length > nextY && generatedMap[nextY].length > nextX){
				posX = nextX;
				posY = nextY;
			}
		}
	}

	private int moveTo(int i) {
		List<Integer> givenList = Arrays.asList(i, i + 1, i - 1);
		Random rand = new Random();
		int randomElement = givenList.get(rand.nextInt(givenList.size()));
		
		if(randomElement < 0) {
			randomElement = 0;
		}
	
		return randomElement;
	}
}

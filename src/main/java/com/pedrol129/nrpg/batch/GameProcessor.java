package com.pedrol129.nrpg.batch;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.pedrol129.nrpg.cli.Intro;
import com.pedrol129.nrpg.decision.DecisionService;
import com.pedrol129.nrpg.decision.DecisionType;
import com.pedrol129.nrpg.enemy.entity.Enemy;
import com.pedrol129.nrpg.enemy.repository.EnemyRepository;
import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.item.entity.Item;
import com.pedrol129.nrpg.map.controller.MapController;
import com.pedrol129.nrpg.map.entity.Zone;
import com.pedrol129.nrpg.map.repository.ZoneRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class GameProcessor {

	@Autowired
	DecisionService decisionService;

	private Random rand = new SecureRandom();

	private Hero hero = null;
	int posY;
	int posX;
	int[][] generatedMap;

	public void run() {
		
		this.decisionService.setType(DecisionType.AUTO);

		hero = Intro.getHero();

		log.info(hero.toString());

		generatedMap = MapController.generateMap();

		posY = new Random().nextInt(generatedMap.length);
		posX = new Random().nextInt(generatedMap[posY].length);

		while (hero.getLife() > 0) {
			Zone zone = ZoneRepository.getZone(generatedMap[posY][posX]);
			log.info("I am in {} - Y:{}, X:{}", zone.getName(), posY, posX);

			this.somethingHappend();

			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				log.error("Error while sleep thread", e);
				Thread.currentThread().interrupt();
			}
		}
	}

	private int moveTo(int position) {
		List<Integer> givenList = Arrays.asList(position, position + 1, position - 1);
		int randomElement = givenList.get(this.rand.nextInt(givenList.size()));

		if (randomElement < 0) {
			randomElement = 0;
		}

		return randomElement;
	}

	private void somethingHappend() {
		// 1- nothing happens, keep walking
		// 2- meet an enemy
		// 3- found object -- TODO
		// 4- trigger event -- TODO

		int whatHappends = new Random().nextInt(3);

		switch (whatHappends) {
		case 1:
			int nextY = this.moveTo(posY);
			int nextX = this.moveTo(posX);

			if (generatedMap.length > nextY && generatedMap[nextY].length > nextX) {
				posX = nextX;
				posY = nextY;
			}
			break;
		case 2:
			Zone zone = ZoneRepository.getZone(generatedMap[posY][posX]);
			if (MapController.meetAnEnemy(zone)) {
				Enemy enemy = EnemyRepository.getEnemyByBiome(zone.getBiomeId());

				BattleProcessor battle = new BattleProcessor();
				boolean youWin = battle.fight(hero, enemy);
				if (youWin) {
					log.info("You win {} exp", 20);
					hero.addExperience(20);
					log.info("You found {}",
							enemy.getInventory().stream().map(Item::getName).collect(Collectors.joining(",")));
					hero.getInventory().addAll(enemy.getInventory());
				}

				log.info(hero.toString());
			}
			break;
		case 3:
			// TODO
			break;
		case 4:
			// TODO
			break;
		default:
			break;
		}
	}
}

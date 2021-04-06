package com.pedrol129.nrpg.batch;

import com.pedrol129.nrpg.enemy.entity.Enemy;
import com.pedrol129.nrpg.hero.entity.Hero;

import lombok.extern.log4j.Log4j2;
import com.pedrol129.nrpg.Character;

@Log4j2
public class BattleProcessor {

	public static boolean fight(Hero hero, Enemy enemy) {
		boolean yourTurn = true;

		log.info("You fight agains {}", enemy.getName());

		while (hero.getLife() > 0 && enemy.getLife() > 0) {
			log.info("{} has {} points of life", hero.getName(), hero.getLife());
			log.info("{} has {} points of life", enemy.getName(), enemy.getLife());
			
			Character atk;
			Character def;

			if (yourTurn) {
				atk = hero;
				def = enemy;
			} else {
				atk = enemy;
				def = hero;
			}

			int damage = getDamage(atk, def);

			log.info("{} recive {} of damage", def.getName(), damage);
			def.damage(damage);

			yourTurn = !yourTurn;
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				log.error("Error while sleep thread", e);
				Thread.currentThread().interrupt();
			}
		}

		boolean youWin = hero.getLife() > 0;

		if (youWin) {
			log.info("You win");
			return true;
		} else {
			log.info("You lose");
			return false;
		}
	}

	public static int getDamage(Character atk, Character def) {
		int damage = atk.getCombinedAttack() - def.getCombinedDefense();

		if (damage < 0) {
			damage = 0;
		}

		return damage;
	}
}

package com.pedrol129.nrpg.cli;

import java.util.Scanner;

import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.race.entity.Race;
import com.pedrol129.nrpg.race.repository.RaceRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Intro {

	public static Hero getHero() {
		String name = getHeroName();

		log.info("Hello {}", name);

		log.info("I've never see you around before");

		log.info("...");

		Race race = getRace();
		
		return new Hero(name, race);
	}

	private static String getHeroName() {
		String name = "";

		Scanner scanner = new Scanner(System.in);
		while (name.isBlank()) {
			log.info("What's your name?");
			name = "Tupac"; //scanner.next().trim();

		}

		return name;
	}

	public static Race getRace() {
		log.info("You don't look like you are around here");
		log.info("What are you?");
		Race race = null;

		Scanner scanner = new Scanner(System.in);

		while (race == null) {
			log.info("Choose one the followed options");
			log.info(RaceRepository.getRaces().toString());
			String raceName = "Human"; //scanner.next().trim();
			race = RaceRepository.getRaceByName(raceName);
		}


		log.info("Oh! I've never see a one of your...");
		
		log.info("kind");
		return race;
	}
}

package com.pedrol129.nrpg.cli;

import com.pedrol129.nrpg.comunication.Communication;
import com.pedrol129.nrpg.comunication.CommunicationCLI;
import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.race.entity.Race;
import com.pedrol129.nrpg.race.repository.RaceRepository;

public class Intro {

	private Communication communication;
	
	public Intro() {
		this.communication = new CommunicationCLI();
	}
	
	public Hero getHero() {
		String name = getHeroName();

		this.communication.send(String.format("Hello %s", name));

		this.communication.send("I've never see you around before");

		this.communication.send("...");

		var race = getRace();

		return new Hero(name, race);
	}

	private String getHeroName() {
		return this.communication.sendAndReceive("What's your name?");
	}

	public Race getRace() {
		this.communication.send("You don't look like you are around here");
		this.communication.send("What are you?");

		Race race = null;

		while (race == null) {
			var raceName = this.communication.sendAndReceive(RaceRepository.getRaces().toString());
			race = RaceRepository.getRaceByName(raceName);
		}

		this.communication.send("Oh! I've never see a one of your...");

		this.communication.send("kind");
		return race;
	}
}

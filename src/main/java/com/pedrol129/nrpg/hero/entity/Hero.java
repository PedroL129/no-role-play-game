package com.pedrol129.nrpg.hero.entity;

import com.github.freva.asciitable.AsciiTable;
import com.pedrol129.nrpg.Character;
import com.pedrol129.nrpg.race.entity.Race;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
public class Hero extends Character {
	private int experience;
	private float evolution;
	private float nextLevel;

	public Hero(String name, Race race) {
		this.name = name;
		this.race = race;
		this.life = 100;
		this.level = 1;
		this.attack = 12;
		this.defense = 10;
		this.experience = 0;
		this.evolution = 2.25f;
		this.nextLevel = 30;
	}

	public void addExperience(int exp) {
		this.experience += exp;
		if (this.experience >= this.nextLevel) {
			this.experience -= this.nextLevel;
			this.nextLevel = this.nextLevel * this.evolution;
			this.level ++;
		}
		log.info("You need {} exp for level up", this.nextLevel - this.experience);
	}

	@Override
	public String toString() {
		String[] headers = { this.name, this.race.toString(), "", "" };
		String[][] data = { { "Level", String.valueOf(this.level), "Life", String.valueOf(this.life) } };

		return AsciiTable.getTable(headers, data);
	}
}
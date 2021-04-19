package com.pedrol129.nrpg.hero.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.freva.asciitable.AsciiTable;
import com.pedrol129.nrpg.Character;
import com.pedrol129.nrpg.decision.DecisionService;
import com.pedrol129.nrpg.item.entity.Item;
import com.pedrol129.nrpg.item.entity.Weapon;
import com.pedrol129.nrpg.race.entity.Race;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
public class Hero extends Character {
	private int experience;
	private float evolution;
	private float nextLevel;
	
	@Autowired
	private DecisionService decisionService;

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

	private void levelUp() {
		this.experience -= this.nextLevel;
		this.nextLevel = this.nextLevel * this.evolution;

		this.level++;

		this.attack += this.attack * this.evolution / 100;
		this.defense += this.defense * this.evolution / 100;
	}

	public void addExperience(int exp) {
		this.experience += exp;
		if (this.experience >= this.nextLevel) {
			this.levelUp();
		}
		log.info("You need {} exp for level up", this.nextLevel - this.experience);
	}

	@Override
	public String toString() {
		String[] headers = { this.name, this.race.toString(), "", "" };
		String[][] data = { { "Level", String.valueOf(this.level), "Life", String.valueOf(this.life) } };

		return AsciiTable.getTable(headers, data);
	}

	public void addItemToInventory(Item item) {
		if (item.canBeEquiped()) {
			this.decisionService.getDecision().chooseItem(this, item);
		} else {
			this.inventory.add(item);
		}
	}
}
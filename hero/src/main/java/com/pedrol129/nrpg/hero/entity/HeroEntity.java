package com.pedrol129.nrpg.hero.entity;

import java.util.List;

import com.pedrol129.nrpg.itemclient.model.WeaponEntity;
import com.pedrol129.nrpg.raceclient.model.RaceEntity;

public class HeroEntity {
	private String name;
	private RaceEntity race;
	private int life;
	private int level;
	private int attack;
	private int defense;
	private int experience;
	private float evolution;
	private float nextLevel;
	private List<WeaponEntity> inventory;

	public HeroEntity(String name, RaceEntity race) {
		this.name = name;
		this.race = race;
		this.life = 100;
		this.level = 1;
		this.attack = 10;
		this.defense = 8;
		this.experience = 0;
		this.evolution = 2.25f;
		this.nextLevel = 100;
	}

	public void addExperience(int exp) {
		this.experience += exp;
		if (this.experience >= this.nextLevel) {
			this.experience -= this.nextLevel;
			this.nextLevel = this.nextLevel * this.evolution;
		}
	}

	public String getName() {
		return name;
	}

	public RaceEntity getRace() {
		return race;
	}

	public int getLife() {
		return life;
	}

	public int getLevel() {
		return level;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getExperience() {
		return experience;
	}

	@Override
	public String toString() {
		return String.format("I am %s the %s", this.name, this.race);
	}

}
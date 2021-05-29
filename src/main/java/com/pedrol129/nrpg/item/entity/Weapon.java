package com.pedrol129.nrpg.item.entity;

import lombok.Getter;

@Getter
public class Weapon extends Item {
	private int attack;
	private boolean twoHanded = true;

	@Override
	public int getPoints() {
		return this.attack;
	}

	@Override
	public int getPositionsRequired() {
		return this.twoHanded ? 2 : 1;
	}
}

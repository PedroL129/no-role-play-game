package com.pedrol129.nrpg.item.entity;

import lombok.Getter;

@Getter
public class Shield extends Item {

	private int defense;

	@Override
	public int getPoints() {
		return this.defense;
	}
}

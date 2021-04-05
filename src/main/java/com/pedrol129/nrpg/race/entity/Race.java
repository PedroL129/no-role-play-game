package com.pedrol129.nrpg.race.entity;

import lombok.Getter;

@Getter
public class Race {
	
	private Integer id;
	
	private String name;

	@Override
	public String toString() {
		return this.name;
	}

}
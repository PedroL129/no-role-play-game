package com.pedrol129.nrpg.race.entity;

public class RaceEntity {
	
	private Integer id;
	
	private String name;

	public String getName() {
		return name;
	}

	public Integer getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
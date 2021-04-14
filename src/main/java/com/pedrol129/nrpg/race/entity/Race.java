package com.pedrol129.nrpg.race.entity;

import java.util.List;

import lombok.Getter;

@Getter
public class Race {
	
	private int id;
	private String name;
	private int intelligence = 0;
	private List<String> equipation;
	
	@Override
	public String toString() {
		return this.name;
	}

}
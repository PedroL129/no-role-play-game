package com.pedrol129.nrpg.map.entity;

import java.util.ArrayList;

public class MapEntity {

	private Integer id;

	private String name;

	private ArrayList<ZoneEntity> zones;

	public Integer getId() {
		return this.id;

	}

	public String getName() {
		return this.name;
	}

	public ArrayList<ZoneEntity> getZones() {
		return this.zones;
	}
}

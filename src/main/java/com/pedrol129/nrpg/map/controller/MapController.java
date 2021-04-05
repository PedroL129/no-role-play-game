package com.pedrol129.nrpg.map.controller;

import java.util.List;

import com.pedrol129.nrpg.map.entity.Zone;
import com.pedrol129.nrpg.map.repository.ZoneRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MapController {

	public static int[][] generateMap() {
		int[][] generatedMap = new int[50][50];

		List<Zone> zones = ZoneRepository.getZones();

		for (int i = 0; i < generatedMap.length; i++) {
			for (int j = 0; j < generatedMap[i].length; j++) {
				generatedMap[i][j] = zones.stream().findAny().orElseThrow().getId();
			}
		}

		return generatedMap;
	}

	public static boolean meetAnEnemy(Zone zone) {
		return (new java.util.Random().nextInt(100)) <= zone.getEnemyRate();
	}
}

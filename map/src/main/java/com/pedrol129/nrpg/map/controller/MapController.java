package com.pedrol129.nrpg.map.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedrol129.nrpg.map.entity.MapEntity;
import com.pedrol129.nrpg.map.entity.ZoneEntity;
import com.pedrol129.nrpg.map.repository.MapRepository;

@RestController
public class MapController {
	@Autowired
	private MapRepository mapRepository;

	@GetMapping("/map")
	public List<MapEntity> getMaps() {
		return this.mapRepository.getMaps();
	}

	@GetMapping("/next-zone")
	public ZoneEntity getNextZone(@RequestParam Integer idMap) {
		Optional<MapEntity> optional = this.mapRepository.getMaps().stream().filter(i -> i.getId().equals(idMap))
				.findFirst();
		if (optional.isEmpty()) {
			return null;
		}
		ArrayList<ZoneEntity> zones = optional.get().getZones();
		Random r = new Random();
		return zones.get(r.nextInt(zones.size()));
	}

}

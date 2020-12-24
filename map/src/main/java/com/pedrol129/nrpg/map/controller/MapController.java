package com.pedrol129.nrpg.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrol129.nrpg.map.entity.MapEntity;
import com.pedrol129.nrpg.map.repository.MapRepository;

@RestController
public class MapController {
	@Autowired
	private MapRepository mapRepository;

	@GetMapping("/map")
	public List<MapEntity> getMaps(){
		return this.mapRepository.getMaps();
	}
}

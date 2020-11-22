package com.pedrol129.nrpg.race.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrol129.nrpg.race.entity.RaceEntity;
import com.pedrol129.nrpg.race.repository.RaceRepository;

@RestController
public class RaceController {
	@Autowired
	private RaceRepository raceRepository;

	@GetMapping("/race")
	public List<RaceEntity> getRaces(){
		return this.raceRepository.getRaces();
	}
}

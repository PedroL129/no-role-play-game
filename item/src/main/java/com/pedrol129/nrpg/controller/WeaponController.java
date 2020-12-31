package com.pedrol129.nrpg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrol129.nrpg.entity.WeaponEntity;
import com.pedrol129.nrpg.repository.WeaponRepository;

@RestController
public class WeaponController {
	@Autowired
	private WeaponRepository weaponRepository;

	@GetMapping("/weapon")
	public List<WeaponEntity> getWeapons(){
		return this.weaponRepository.getWeapons();
	}
}

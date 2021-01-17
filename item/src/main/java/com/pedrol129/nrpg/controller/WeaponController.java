package com.pedrol129.nrpg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pedrol129.nrpg.entity.WeaponEntity;
import com.pedrol129.nrpg.repository.WeaponRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class WeaponController {
	@Autowired
	private WeaponRepository weaponRepository;

	@Operation(summary = "", description = "", tags = { "weapon-controller" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = WeaponEntity.class)))) })
	@RequestMapping(value = "/weapon", produces = { "*/*" }, method = RequestMethod.GET)
	public ResponseEntity<List<WeaponEntity>> getWeapons() {
		return new ResponseEntity<List<WeaponEntity>>(this.weaponRepository.getWeapons(), HttpStatus.OK);
	}
}

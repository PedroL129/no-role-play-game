package com.pedrol129.nrpg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedrol129.nrpg.entity.ItemEntity;
import com.pedrol129.nrpg.repository.WeaponRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ItemController {
	@Autowired
	private WeaponRepository weaponRepository;

	@Operation(summary = "", description = "", tags = { "item-controller" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ItemEntity.class)))) })
	@GetMapping(value = "/item", produces = "application/json" )
	public ResponseEntity<List<ItemEntity>> getItems() {
		List<ItemEntity> items = new ArrayList<>();
		items.addAll(this.weaponRepository.getWeapons());

		return new ResponseEntity<>(items, HttpStatus.OK);
	
	}
}

package com.pedrol129.nrpg.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(allOf  = ItemEntity.class)
public class WeaponEntity extends ItemEntity {
	private Integer attack;

	public Integer getAttack() {
		return attack;
	}
	
	
	
}

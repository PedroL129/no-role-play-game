package com.pedrol129.nrpg.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(subTypes = {WeaponEntity.class})
public class ItemEntity {
	
	protected Integer id;
    protected String name;
    
    protected Integer idType;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getIdType() {
		return idType;
	}
    
    
    
    
}

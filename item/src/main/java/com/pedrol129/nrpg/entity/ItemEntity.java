package com.pedrol129.nrpg.entity;

import lombok.Getter;

@Getter
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

package com.pedrol129.nrpg.item.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.Getter;

@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "idType", defaultImpl = Item.class)
@JsonSubTypes({ @JsonSubTypes.Type(value = Weapon.class, name = "1"),
		@JsonSubTypes.Type(value = Shield.class, name = "2") })
@Getter
public class Item {

	protected Integer id;
	protected String name;
	protected Integer idType;
}

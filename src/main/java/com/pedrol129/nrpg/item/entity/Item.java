package com.pedrol129.nrpg.item.entity;

import java.util.stream.IntStream;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.pedrol129.nrpg.item.repository.ItemRepository;
import com.pedrol129.nrpg.item.repository.ItemTypeRepository;

import lombok.Getter;
import lombok.ToString;

@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "idType", defaultImpl = Item.class)
@JsonSubTypes({ @JsonSubTypes.Type(value = Weapon.class, name = "1"),
		@JsonSubTypes.Type(value = Shield.class, name = "2") })
@Getter
@ToString
public class Item {

	public int[] equipables = { 1, 2 };

	protected int id;
	protected String name;
	protected int idType;
	protected ItemType type;

	public boolean canBeEquiped() {
		return IntStream.of(this.equipables).anyMatch(x -> x == this.idType);
	}

	public ItemType getType() {
		if (this.type == null) {
			this.type = ItemTypeRepository.getTypeById(this.idType);
		}

		return this.type;
	}
}

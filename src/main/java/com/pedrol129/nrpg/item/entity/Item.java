package com.pedrol129.nrpg.item.entity;

import java.util.UUID;
import java.util.stream.IntStream;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.pedrol129.nrpg.item.repository.ItemTypeRepository;

import lombok.Getter;
import lombok.ToString;

@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, visible = true, property = "idType", defaultImpl = Item.class)
@JsonSubTypes({ @JsonSubTypes.Type(value = Weapon.class, name = "1"),
		@JsonSubTypes.Type(value = Shield.class, name = "2") })
@Getter
@ToString
public class Item {
	protected String uniqueID;
	protected int[] equipables = { 1, 2 };

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

	public Item() {
		this.uniqueID = UUID.randomUUID().toString();
	}

	public int getPoints() {
		return 0;
	}

	public int getPositionsRequired() {
		return 1;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Item) {
			return this.uniqueID.equals(((Item) o).getUniqueID());
		} else if (o instanceof String) {
			return this.uniqueID.equals(o);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.uniqueID.hashCode();
	}
}

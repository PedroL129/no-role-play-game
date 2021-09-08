package com.pedrol129.nrpg.item.entity;

import java.util.Arrays;

public enum ItemTypeEnum {
	WEAPON(1), SHIELD(2), ARMOR(3), OTHER(0);

	public final int id;
	
	ItemTypeEnum(int id) {
		this.id = id;
	}
	
	public static ItemTypeEnum valueOf(int value) {
        return Arrays.stream(values())
            .filter(item -> item.id == value)
            .findFirst().orElse(OTHER);
    }
}

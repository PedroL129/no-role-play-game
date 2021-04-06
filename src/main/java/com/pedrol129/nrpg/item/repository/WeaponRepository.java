package com.pedrol129.nrpg.item.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.pedrol129.nrpg.item.entity.Item;
import com.pedrol129.nrpg.item.entity.Weapon;

public class WeaponRepository {
	public List<Weapon> getWeapons() {
		ArrayList<Weapon> weapons = null;

		PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder().allowIfSubType(Item.class).build();

		ObjectMapper mapper = YAMLMapper.builder().polymorphicTypeValidator(ptv).build();

		mapper.findAndRegisterModules();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Weapon.class);

		File file = new File("src/main/resources/weapons.yaml");

		try {
			weapons = mapper.readValue(file, type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return weapons;
	}
}

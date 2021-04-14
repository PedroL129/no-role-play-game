package com.pedrol129.nrpg.item.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.pedrol129.nrpg.item.entity.Item;
import com.pedrol129.nrpg.item.entity.Weapon;

@JsonTypeInfo(use = Id.NONE)
public class WeaponRepository {

	private WeaponRepository() {

	}

	public static List<Item> getWeapons() {
		ArrayList<Item> weapons = new ArrayList<>();

		ObjectMapper sourceMapper = new ObjectMapper(new YAMLFactory());

		CollectionType sourceType = sourceMapper.getTypeFactory().constructCollectionType(ArrayList.class, Map.class);

		File file = new File("src/main/resources/items.yaml");

		try {
			List<Map<String, Object>> source = sourceMapper.readValue(file, sourceType);

			final ObjectMapper weaponMapper = new ObjectMapper();

			List<Map<String, Object>> filtered = source.stream().filter(map -> map.get("idType").equals(1))
					.collect(Collectors.toList());
			CollectionType weaponType = weaponMapper.getTypeFactory().constructCollectionType(ArrayList.class,
					Weapon.class);
			weapons = weaponMapper.convertValue(filtered, weaponType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return weapons;
	}

}

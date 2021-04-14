package com.pedrol129.nrpg.item.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.pedrol129.nrpg.item.entity.ItemType;

public class ItemTypeRepository {
	public static List<ItemType> getTypes() {
		ArrayList<ItemType> types = null;

		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		mapper.findAndRegisterModules();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, ItemType.class);

		File file = new File("src/main/resources/item_types.yaml");

		try {
			types = mapper.readValue(file, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return types;
	}

	public static ItemType getTypeById(int id) {
		return getTypes().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}
}

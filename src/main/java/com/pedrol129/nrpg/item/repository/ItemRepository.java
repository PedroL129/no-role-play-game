package com.pedrol129.nrpg.item.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.pedrol129.nrpg.item.entity.Item;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemRepository {

	public static List<Item> getItems() {
		ArrayList<Item> items = new ArrayList<>();

		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		mapper.findAndRegisterModules();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Item.class);

		File file = new File("src/main/resources/items.yaml");

		try {
			items = mapper.readValue(file, type);
		} catch (IOException e) {
			log.error("Error at reading races", e);
		}

		return items;
	}
	
	public static List<Item> getItems(List<Integer> ids){
		return getItems().stream().filter(item -> ids.contains(item.getId())).collect(Collectors.toList());
	}
}

package com.pedrol129.nrpg.race.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.pedrol129.nrpg.race.entity.Race;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RaceRepository {

	private RaceRepository() {

	}

	public static List<Race> getRaces() {
		ArrayList<Race> races = new ArrayList<>();

		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		mapper.findAndRegisterModules();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Race.class);

		File file = new File("src/main/resources/races.yaml");

		try {
			races = mapper.readValue(file, type);
		} catch (IOException e) {
			log.error("Error at reading races", e);
		}

		return races;
	}

	public static Race getRaceByName(String name) {
		ArrayList<Race> races = null;

		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		mapper.findAndRegisterModules();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Race.class);

		File file = new File("src/main/resources/races.yaml");

		try {
			races = mapper.readValue(file, type);
		} catch (IOException e) {
			log.error("Error at reading races", e);
		}

		if (races == null) {
			return null;
		}

		return races.stream().filter(r -> r.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

	public static Race getRace(int id) {
		List<Race> races = getRaces();

		return races.stream().filter(b -> b.getId() == id).findFirst().orElseThrow();

	}
}

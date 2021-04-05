package com.pedrol129.nrpg.map.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.pedrol129.nrpg.map.entity.Biome;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BiomeRepository {

	public static List<Biome> getBiomes() {
		ArrayList<Biome> maps = null;

		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		mapper.findAndRegisterModules();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Biome.class);

		File file = new File("src/main/resources/biomes.yaml");

		try {
			maps = mapper.readValue(file, type);
		} catch (IOException e) {
			log.error("Error at reading biomes", e);
		}

		return maps;

	}

	public static Biome getBiome(int id) {
		List<Biome> biomes = getBiomes();

		return biomes.stream().filter(b -> b.getId() == id).findFirst().orElseThrow();

	}
}

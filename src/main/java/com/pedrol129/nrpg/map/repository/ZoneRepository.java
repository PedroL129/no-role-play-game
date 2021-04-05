package com.pedrol129.nrpg.map.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.pedrol129.nrpg.map.entity.Zone;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ZoneRepository {
	public static List<Zone> getZones() {
		ArrayList<Zone> maps = null;

		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		mapper.findAndRegisterModules();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Zone.class);

		File file = new File("src/main/resources/zones.yaml");

		try {
			maps = mapper.readValue(file, type);
		} catch (IOException e) {
			log.error("Error at reading zones", e);
		}

		return maps;

	}

	public static Zone getZone(int id) {
		List<Zone> zones = getZones();

		return zones.stream().filter(z -> z.getId() == id).findFirst().orElseThrow();

	}
}

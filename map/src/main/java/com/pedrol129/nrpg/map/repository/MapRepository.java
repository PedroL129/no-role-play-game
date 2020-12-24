package com.pedrol129.nrpg.map.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.pedrol129.nrpg.map.entity.MapEntity;

@Component
public class MapRepository {

	public List<MapEntity> getMaps(){
		ArrayList<MapEntity> maps = null;
		
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		mapper.findAndRegisterModules();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, MapEntity.class);

		File file = new File("src/main/resources/maps.yaml");

		try {
			maps = mapper.readValue(file, type);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return maps;
		
	}
}

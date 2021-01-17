package com.pedrol129.nrpg.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.pedrol129.nrpg.entity.EnemyEntity;

@Component
public class EnemyRepository {
	public List<EnemyEntity> getWeapons() {
		ArrayList<EnemyEntity> types = null;
		
		ObjectMapper mapper =YAMLMapper.builder().build();
	
		mapper.findAndRegisterModules();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, EnemyEntity.class);

		File file = new File("src/main/resources/enemy.yaml");

		try {
			types = mapper.readValue(file, type);
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

		return types;
	}
}

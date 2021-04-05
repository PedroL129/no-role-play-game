package com.pedrol129.nrpg.enemy.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.pedrol129.nrpg.enemy.entity.Enemy;

public class EnemyRepository {
	public static List<Enemy> getEnemies() {
		ArrayList<Enemy> types = null;
		
		ObjectMapper mapper =YAMLMapper.builder().build();
	
		mapper.findAndRegisterModules();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Enemy.class);

		File file = new File("src/main/resources/enemies.yaml");

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

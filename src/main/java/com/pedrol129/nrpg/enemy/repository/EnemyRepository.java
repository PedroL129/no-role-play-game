package com.pedrol129.nrpg.enemy.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.pedrol129.nrpg.enemy.entity.Enemy;

public class EnemyRepository {

	private EnemyRepository() {

	}

	public static List<Enemy> getEnemies() {
		List<Enemy> enemies = new ArrayList<>();

		ObjectMapper mapper = YAMLMapper.builder().build();

		File file = new File("src/main/resources/enemies.yaml");

		try {
			enemies = mapper.readValue(file, new TypeReference<List<Enemy>>() {
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enemies;
	}

	public static Enemy getEnemyByBiome(int biomeId) {
		return getEnemies().stream().filter(e -> e.getBiomes().contains(biomeId)).findAny().orElse(null);
	}
}

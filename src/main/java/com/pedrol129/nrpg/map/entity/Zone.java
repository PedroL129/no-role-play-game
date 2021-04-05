package com.pedrol129.nrpg.map.entity;

import com.pedrol129.nrpg.map.repository.BiomeRepository;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Zone {
	private int id;
	private int biomeId;
	private Biome biome;
	private int enemyRate = 30;

	public Biome getBiome() {
		if (biome == null) {
			this.biome = BiomeRepository.getBiome(this.biomeId);
		}

		return this.biome;
	}
	
	
}

package com.pedrol129.nrpg.enemy.entity;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pedrol129.nrpg.Character;
import com.pedrol129.nrpg.item.entity.Item;
import com.pedrol129.nrpg.item.repository.ItemRepository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@JsonDeserialize(converter = EnemySanitizer.class)
@Setter
public class Enemy extends Character {

	private List<Integer> defaultInventory;

	private int minLevel;
	private int maxLevel;

	private float coefAttack;
	private float coefDefense;

	private List<Integer> zones;
	private List<Integer> biomes;

	@Override
	public List<Item> getInventory() {
		if (this.inventory.isEmpty()) {
			this.inventory = ItemRepository.getItems(this.defaultInventory);
		}

		return this.inventory;
	}

	/**
	 * Initialize Enemy.
	 * 
	 * Call all initialize(*) methods
	 */
	public void initialize() {

		this.initializeLevel();

		this.initializeStats();

		this.initializeInventory();
	}

	/**
	 * Initialize the level of the enemy. In YAML file can be defined the level or a
	 * max and min level
	 */
	public void initializeLevel() {
		if (this.level == 0) {
			this.level = ThreadLocalRandom.current().nextInt(this.minLevel, this.maxLevel + 1);
		}
	}

	/**
	 * Initialize all stats for a enemy.
	 * 
	 * The YAML file can define a value for the stats, but also can define a
	 * coefficient, a percentage applied by the level
	 */
	public void initializeStats() {
		float attack = this.attack + (this.attack * (this.level * this.coefAttack));
		this.attack = (int) Math.ceil(attack);

		float defense = this.defense + (this.defense * (this.level * this.coefDefense));
		this.defense = (int) Math.ceil(defense);
	}

	/**
	 * Check and equip items
	 */
	public void initializeInventory() {
		if (this.getRace().getIntelligence() > 0 && !this.inventory.isEmpty()) {
			this.inventory.forEach(item -> {
				if (item.getIdType() == 1 || item.getIdType() == 2) {
					// replace the key for the position
					this.equipped.put(String.valueOf(item.getId()), item);
				}
			});
		}
	}
}

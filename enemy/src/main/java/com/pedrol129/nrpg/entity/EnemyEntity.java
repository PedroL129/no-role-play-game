package com.pedrol129.nrpg.entity;

import java.util.List;
import java.util.Map;

import com.pedrol129.nrpg.itemclient.model.ItemEntity;
import com.pedrol129.nrpg.itemclient.model.WeaponEntity;
import com.pedrol129.nrpg.raceclient.model.RaceEntity;

public class EnemyEntity {
	private String name;
	private RaceEntity race;
	private int life;
	private int level;
	private int attack;
	private int defense;
	private List<ItemEntity> inventory;
	private Map<String, ItemEntity> equipped;
	private WeaponEntity weapon;

}

package com.pedrol129.nrpg.enemy.entity;

import com.fasterxml.jackson.databind.util.StdConverter;

public class EnemySanitizer extends StdConverter<Enemy, Enemy> {
	@Override
	public Enemy convert(Enemy enemy) {
		enemy.initialize();

		return enemy;
	}
}

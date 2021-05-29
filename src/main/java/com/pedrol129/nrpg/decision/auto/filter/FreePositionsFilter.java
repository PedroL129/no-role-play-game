package com.pedrol129.nrpg.decision.auto.filter;

import java.util.List;
import java.util.stream.Collectors;

import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.item.entity.Item;

public class FreePositionsFilter implements ItemFilter<Item> {

	public boolean filter(Hero hero, Item item) {
		if (!item.canBeEquiped())
			return false;
		List<String> freePositions = item.getType().getPositions().stream()
				.filter(key -> !hero.getEquipped().keySet().contains(key)).collect(Collectors.toList());

		boolean freePosition = freePositions.size() >= item.getPositionsRequired();

		if (freePosition) {
			List<String> positions = freePositions.subList(0, item.getPositionsRequired());
			hero.equip(positions, item);
		}

		return freePosition;
	}
}

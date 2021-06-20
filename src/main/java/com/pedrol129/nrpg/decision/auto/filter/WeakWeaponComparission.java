package com.pedrol129.nrpg.decision.auto.filter;

import java.util.ArrayList;
import java.util.List;

import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.item.entity.Item;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class WeakWeaponComparission implements ItemFilter<Item> {

	@Override
	public boolean filter(Hero hero, Item item) {

		// Equipped items that occupy positions of the new item
		List<Item> itemsInConflic = new ArrayList<>();

		hero.getEquipped().forEach((k, v) -> {
			if (item.getType().getPositions().contains(k)) {
				int index = hero.getEquippedItems().indexOf(v);
				itemsInConflic.add(hero.getEquippedItems().get(index));
			}
		});

		// Order items by points
		itemsInConflic.sort((item1, item2) -> Integer.compare(hero.getItemPoints(item1), hero.getItemPoints(item2)));

		// Check the minimal items with the lower points for needed positions
		// TODO: check combinations of items, now the algorithm only gets the weakest
		// items

		List<Item> itemsToRemove = new ArrayList<>();

		for (Item removable : itemsInConflic) {
			var positions = itemsToRemove.stream().mapToInt(Item::getPositionsRequired).sum();
			if (positions < item.getPositionsRequired()) {
				itemsToRemove.add(removable);
			} else {
				break;
			}
		}

		if (itemsToRemove.isEmpty()) {
			return false;
		}

		List<String> positions = new ArrayList<>();

		hero.getEquipped().forEach((k, v) -> {
			if (itemsToRemove.contains(v)) {
				positions.add(k);
			}
		});

		hero.equip(positions, item);

		return true;
	}

}

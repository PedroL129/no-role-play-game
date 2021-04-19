package com.pedrol129.nrpg.decision;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.item.entity.Item;
import com.pedrol129.nrpg.item.entity.Shield;
import com.pedrol129.nrpg.item.entity.Weapon;

public class AutoDecision implements Decision {

	@Override
	public void chooseItem(Hero hero, Item item) {
		List<String> positions = item.getType().getPositions();

		switch (item.getIdType()) {
		case 1:
			Weapon witem = (Weapon) item;

			if (witem.isTwoHanded()) {
				// If both hands are empty, equip them
				List<String> ocuppedPositions = hero.getEquipped().keySet().stream()
						.filter(key -> positions.contains(key)).collect(Collectors.toList());

				if (ocuppedPositions.isEmpty()) {
					this.equip(hero, witem);
				}

				// else If the sum of attack && defense of equipped items are less than the
				// attack, equip them
				List<Item> equippedItems = new ArrayList<>();
				ocuppedPositions.forEach(key -> equippedItems.add(hero.getEquipped().get(key)));
				if (this.getCombinedPoints(equippedItems) < witem.getAttack()) {
					ocuppedPositions.forEach(key -> hero.getEquipped().remove(key));
					this.equip(hero, witem);
				}

			} else {
				// If one hand are empty, equip them
				// else replace for one item, if the attack or defense are less
				// if the equipped item is a two handed weapon, check if the inventory contains
				// another weapon or shield to equip
			}

			break;

		default:
			break;
		}

	}

	private void equip(Hero hero, Weapon item) {
		List<String> positions = item.getType().getPositions();
		hero.getEquipped().put(item.getType().getPositions().get(0), item);
	}

	private int getCombinedPoints(List<Item> items) {
		int result = 0;

		for (Item item : items) {
			switch (item.getIdType()) {
			case 1:
				Weapon witem = (Weapon) item;
				result += witem.getAttack();
				break;
			case 2:
				Shield sitem = (Shield) item;
				result += sitem.getDefense();
				break;
			}
		}

		return result;
	}

}

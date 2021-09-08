package com.pedrol129.nrpg.decision.auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.item.entity.Item;

public class FoundItems {

	private FoundItems() {
	}

	private static List<Item> getItemsInConflic(Item item, Hero hero) {
		// Equipped items that occupy positions of the new item
		List<Item> itemsInConflic = new ArrayList<>();

		// For all the positions required get the object in that position and add it to
		// an array
		for (String position : item.getType().getPositions()) {
			if (hero.getEquipped().containsKey(position)) {
				String itemId = hero.getEquipped().get(position);
				var equipped = hero.getEquippedItemByUID(itemId);
				itemsInConflic.add(equipped);
			}
		}

		return itemsInConflic;
	}

	/**
	 * Check if the hero have positions free for the weapon
	 * 
	 * @param item
	 * @param hero
	 * @return Return a map of Item UID and an array of positions 
	 */
	public static Map<String, String[]> haveFreePositions(Item item, Hero hero) {

		List<String> freePositions = item.getType().getPositions().stream()
				.filter(key -> !hero.getEquipped().keySet().contains(key)).collect(Collectors.toList());

		boolean freePosition = freePositions.size() >= item.getPositionsRequired();

		if (freePosition) {
			List<String> positions = freePositions.subList(0, item.getPositionsRequired());
			return Map.of(item.getUniqueID(), positions.toArray(new String[positions.size()]));
		}

		return Map.of();
	}
	
	
	/**
	 * Check if the given item is powerful than the weaker
	 * 
	 * @param item
	 * @param hero
	 * @return Return a map of Item UID and an array of positions
	 */
	public static Map<String, String[]> powerfulThanWeakEquipedItem(Item item, Hero hero) {

		// Equipped items that occupy positions of the new item
		List<Item> itemsInConflic = getItemsInConflic(item, hero);

		// Order items by points
		itemsInConflic.sort((item1, item2) -> Integer.compare(hero.getItemPoints(item1), hero.getItemPoints(item2)));

		List<Item> itemsToRemove = new ArrayList<>();

		// Get the the minimum objects for the required positions
		for (Item removable : itemsInConflic) {
			var positions = itemsToRemove.stream().mapToInt(Item::getPositionsRequired).sum();
			if (positions < item.getPositionsRequired()) {
				itemsToRemove.add(removable);
			} else {
				break;
			}
		}

		if (itemsToRemove.isEmpty()) {
			return Map.of();
		}

		// If the minimum required objects are stronger than the new item, do nothing
		if (itemsToRemove.stream().mapToInt(Item::getPoints).sum() > item.getPoints()) {
			return Map.of();
		}

		List<String> positions = new ArrayList<>();

		// Get the position of the items to remove
		hero.getEquipped().forEach((k, v) -> {
			if (itemsToRemove.contains(v)) {
				positions.add(k);
			}
		});
		
		return Map.of(item.getUniqueID(), positions.toArray(new String[positions.size()]));
	}

	public static  Map<String, String[]> convinationsWithInventory(Item item, Hero hero) {
		// TODO: Check the convinations with inventory items
		return Map.of();
	}

	public static boolean haveWeaponEquiped(Hero hero, Item item, Map<String, String[]> itemsToEquip) {
		hero.getEquipped().forEach((position, uid) -> {
			if(itemsToEquip.containsKey(uid)) {
				
			}
		});
		
		return false;
	}

	
	
	

}

package com.pedrol129.nrpg.decision;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.pedrol129.nrpg.decision.auto.FoundItems;
import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.item.entity.Item;
import com.pedrol129.nrpg.item.entity.ItemTypeEnum;

public class AutoDecision implements Decision {

	public AutoDecision() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void foundItems(Hero hero, List<Item> items) {
		for (Item item : items) {
			if (!item.canBeEquiped())
				continue;

			Map<String, String[]> itemsToEquip = FoundItems.haveFreePositions(item, hero);
			if (itemsToEquip.isEmpty())
				continue;

			var type = ItemTypeEnum.valueOf(item.getIdType());
			switch (type) {
			case WEAPON:
			case ARMOR:
				itemsToEquip = FoundItems.powerfulThanWeakEquipedItem(item, hero);
				break;
			case SHIELD:
				itemsToEquip = FoundItems.powerfulThanWeakEquipedItem(item, hero);
				boolean haveWeapon = FoundItems.haveWeaponEquiped(hero, item, itemsToEquip);
				break;
			default:
				break;
			}

			if (itemsToEquip.isEmpty()) {
				itemsToEquip = FoundItems.convinationsWithInventory(item, hero);
			}
			
			if(!itemsToEquip.isEmpty()) {
				itemsToEquip.forEach((uid, positions) ->  {
					Item itemToEquip = item.getUniqueID().equals(uid) ? item: hero.getEquippedItemByUID(uid);
					hero.equip(Arrays.asList(positions), itemToEquip);
				});
			}
		}
	}

}

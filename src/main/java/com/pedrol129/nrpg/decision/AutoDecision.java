package com.pedrol129.nrpg.decision;

import java.util.Arrays;
import java.util.List;

import com.pedrol129.nrpg.decision.auto.filter.FreePositionsFilter;
import com.pedrol129.nrpg.decision.auto.filter.ItemFilter;
import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.item.entity.Item;

public class AutoDecision implements Decision {

	private List<ItemFilter<? extends Item>> itemFilters;

	public AutoDecision() {
		itemFilters = Arrays.asList(new FreePositionsFilter());
	}

	@Override
	public void foundItems(Hero hero, Item[] items) {
		for (Item item : items) {
			boolean exit = false;
			for (ItemFilter filter : this.itemFilters) {
				boolean canInvocate = filter.getClass().getDeclaredMethods()[0].getParameters()[1].getType()
						.isAssignableFrom(item.getClass());

				if (canInvocate) {
					exit = filter.filter(hero, item);

					if (exit) {
						break;
					}
				}
			}
		}
	}

}

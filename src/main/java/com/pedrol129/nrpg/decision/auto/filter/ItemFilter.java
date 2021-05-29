package com.pedrol129.nrpg.decision.auto.filter;

import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.item.entity.Item;

public interface ItemFilter<T extends Item> {

	boolean filter(Hero hero, T item);
}

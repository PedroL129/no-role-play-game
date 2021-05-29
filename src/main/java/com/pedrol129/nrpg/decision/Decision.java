package com.pedrol129.nrpg.decision;

import java.util.List;

import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.item.entity.Item;

public interface Decision {
	
	public void foundItems(Hero hero, List<Item> list);
	
}

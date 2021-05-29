package com.pedrol129.nrpg.decision;

import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.item.entity.Item;

public class ManualDecision implements Decision {

	/**
	 * Time of seconds that the input will wait for make an autodecision. If 0 wait
	 * forever
	 */
	private int debounce;


	public ManualDecision(int debounce) {
		this.debounce = debounce;
	}

	@Override
	public void foundItems(Hero hero, Item[] items) {
		// TODO Auto-generated method stub
		
	}

}

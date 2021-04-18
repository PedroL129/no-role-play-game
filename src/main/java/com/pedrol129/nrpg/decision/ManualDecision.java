package com.pedrol129.nrpg.decision;

import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.item.entity.Item;

public class ManualDecision implements Decision {

	/**
	 * Time of seconds that the input will wait for make an autodecision. If 0 wait
	 * forever
	 */
	private int debounce;

	@Override
	public void chooseItem(Hero hero, Item item) {
		// TODO Auto-generated method stub

	}

	public ManualDecision(int debounce) {
		this.debounce = debounce;
	}

}

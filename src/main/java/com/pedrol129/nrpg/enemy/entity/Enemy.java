package com.pedrol129.nrpg.enemy.entity;

import java.util.List;

import com.pedrol129.nrpg.Character;
import com.pedrol129.nrpg.item.entity.Item;
import com.pedrol129.nrpg.item.repository.ItemRepository;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Enemy extends Character {
	
	private List<Integer> defaultInventory;
	
	@Override
	public List<Item> getInventory(){
		if(this.inventory.isEmpty()) {
			this.inventory = ItemRepository.getItems(this.defaultInventory);
		}
		
		return this.inventory;
	}
}

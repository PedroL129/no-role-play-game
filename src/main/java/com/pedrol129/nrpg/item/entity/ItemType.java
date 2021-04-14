package com.pedrol129.nrpg.item.entity;

import java.util.List;

import lombok.Getter;

@Getter
public class ItemType {
	private Integer id;
	private String name;
	private List<String> positions;
}

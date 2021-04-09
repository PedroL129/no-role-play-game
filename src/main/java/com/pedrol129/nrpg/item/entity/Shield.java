package com.pedrol129.nrpg.item.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.Getter;

@Getter
public class Shield extends Item {

	private int defense;
}

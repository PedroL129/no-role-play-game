package com.pedrol129.nrpg.item.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.pedrol129.nrpg.item.entity.ItemEntity;
import com.pedrol129.nrpg.item.entity.WeaponEntity;

public class WeaponRepository {
	public List<WeaponEntity> getWeapons() {
		ArrayList<WeaponEntity> types = null;

		PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator
			    .builder()
			    .allowIfSubType(ItemEntity.class)
			    .build();
		
		
		ObjectMapper mapper =YAMLMapper.builder().polymorphicTypeValidator(ptv).build();
	
		mapper.findAndRegisterModules();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(ArrayList.class, WeaponEntity.class);

		File file = new File("src/main/resources/weapon.yaml");

		try {
			types = mapper.readValue(file, type);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return types;
	}
}

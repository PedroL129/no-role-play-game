package com.pedrol129.nrpg.comunication;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class Comunication {

	public void send(String message) {
		log.info(message);
	}
}

package com.pedrol129.nrpg.comunication;

import java.util.Scanner;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CommunicationCLI implements Communication {

	private static Scanner scanner;

	public CommunicationCLI() {
		super();
		if (scanner == null) {
			scanner = new Scanner(System.in);
		}
	}

	@Override
	public void send(Object message) {
		log.info(message.toString());
	}

	@Override
	public String sendAndReceive(Object message) {
		this.send(message);

		var response = "";
		response = scanner.next();

		return response;
	}
}

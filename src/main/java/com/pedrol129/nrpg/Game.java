package com.pedrol129.nrpg;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedrol129.nrpg.batch.GameProcessor;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class Game {
	
	public static void main(String[] args) {

		log.info("  _  _  ___  ___ ___    \r\n" + " | \\| |/ _ \\| _ \\ __|   \r\n" + " | .` | (_) |  _/ _|    \r\n"
				+ " |_|\\_|\\___/|_| |___|   \r\n" + " | _ \\/ _ \\| |  | __|   \r\n" + " |   / (_) | |__| _|    \r\n"
				+ " |_|_\\\\___/|____|___|   \r\n" + " | _ \\ |    /_\\ \\ / /   \r\n" + " |  _/ |__ / _ \\ V /    \r\n"
				+ " |_|_|____/_/_\\_\\_| ___ \r\n" + "  / __| /_\\ |  \\/  | __|\r\n" + " | (_ |/ _ \\| |\\/| | _| \r\n"
				+ "  \\___/_/ \\_\\_|  |_|___|\r\n" + "                        ");

		log.info("Let's start your adventure");

		GameProcessor batch = new GameProcessor();
		batch.run();

	}

}

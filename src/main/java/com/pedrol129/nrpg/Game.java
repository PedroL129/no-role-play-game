package com.pedrol129.nrpg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedrol129.nrpg.batch.GameProcessor;
import com.pedrol129.nrpg.decision.AutoDecision;
import com.pedrol129.nrpg.hero.entity.Hero;
import com.pedrol129.nrpg.item.entity.Item;
import com.pedrol129.nrpg.item.repository.ItemRepository;
import com.pedrol129.nrpg.race.repository.RaceRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class Game implements CommandLineRunner {
		
	@Autowired
	private GameProcessor batch;
	
	public static void main(String[] args) {
		SpringApplication.run(Game.class, args);
		log.info("  _  _  ___  ___ ___    \r\n" + " | \\| |/ _ \\| _ \\ __|   \r\n" + " | .` | (_) |  _/ _|    \r\n"
				+ " |_|\\_|\\___/|_| |___|   \r\n" + " | _ \\/ _ \\| |  | __|   \r\n" + " |   / (_) | |__| _|    \r\n"
				+ " |_|_\\\\___/|____|___|   \r\n" + " | _ \\ |    /_\\ \\ / /   \r\n" + " |  _/ |__ / _ \\ V /    \r\n"
				+ " |_|_|____/_/_\\_\\_| ___ \r\n" + "  / __| /_\\ |  \\/  | __|\r\n" + " | (_ |/ _ \\| |\\/| | _| \r\n"
				+ "  \\___/_/ \\_\\_|  |_|___|\r\n" + "                        ");

		log.info("Let's start your adventure");	
	}
	
	
	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}
		
		batch.run();

	}

	class ExitException extends RuntimeException implements ExitCodeGenerator {
		private static final long serialVersionUID = 1L;

		@Override
		public int getExitCode() {
			return 10;
		}

	}
}

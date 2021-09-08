package com.pedrol129.nrpg;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedrol129.nrpg.batch.GameProcessor;

@SpringBootApplication
public class Game implements CommandLineRunner {
		
	private GameProcessor batch;
	
	public static void main(String[] args) {
		SpringApplication.run(Game.class, args);
	}
	
	
	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length > 0 && arg0[0].equals("exitcode")) {
			throw new ExitException();
		}
		this.batch = new GameProcessor();
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

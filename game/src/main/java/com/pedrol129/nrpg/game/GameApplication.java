package com.pedrol129.nrpg.game;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync	
public class GameApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
	}
	
	  @Bean
	  public Executor taskExecutor() {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(1);
	    executor.setMaxPoolSize(25);
	    executor.setQueueCapacity(500);
	    executor.setThreadNamePrefix("GameProcessor-");
	    executor.initialize();
	    return executor;
	  }

}

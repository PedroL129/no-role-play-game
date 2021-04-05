package com.pedrol129.nrpg.cli;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Utils {
	public static void pause(long milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			log.error("Error while pause", e);
		}
	}

	public static void pause() {
		pause(1000l);
	}
}

package com.pedrol129.nrpg.comunication;

public interface Communication {

	public void send(Object message);

	public String sendAndReceive(Object message);
}

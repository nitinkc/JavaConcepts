package com.nitin.a8designPatternsNPrinciples.designPrinciples.SOLID.D;

public class OracleDatabase implements Database {

	@Override
	public void connect() {
		System.out.println("Connecting to Oracle database...");
	}

	@Override
	public void disconnect() {
		System.out.println("Disconnection Oracle database...");
	}
}

package com.nitin.a8designPatternsNPrinciples.Behavioral.B2Observer.O1WeatherObserver;

public interface Observer {
	public void update(int pressure, int temperature, int humidity);
}

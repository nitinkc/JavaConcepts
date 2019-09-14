package com.nitin.a8designPatternsNPrinciples.Creational.C2FactoryPattern;

public class AlgorithmFactory {

	/**
	 * Factory class are the only class the handles object creation.
	 */
	public static final int SHORTEST_PATH = 0;
	public static final int SPANNING_TREE = 1;
	
	//public static Algorithm createAlgorithm(String type) {
	public static Algorithm createAlgorithm(int type) {
		switch (type) {
		case SHORTEST_PATH:
			return new ShortestPath();
		case SPANNING_TREE:
			return new SpanningTree();
		default:
			return null;
		}
	}
}

package com.nitin.a8designPatternsNPrinciples.Structural.S2FacadePattern;

public class SortingManager {

	private Algorithm bubbleSort;//Programming to Interface
	private Algorithm mergeSort;
	private Algorithm heapSort;
	
	public SortingManager(){
		this.bubbleSort = new BubbleSort();
		this.mergeSort = new MergeSort();
		this.heapSort = new HeapSort();
	}
	
	public void mergeSort(){
		this.mergeSort.sort();
	}
	
	public void bubbleSort(){
		this.bubbleSort.sort();
	}
	
	public void heapSort(){
		this.heapSort.sort();
	}
}

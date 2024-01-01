/**
 * 
 */
package com.practice.firstassignment;

/**
 * @author Shrikant_Bhadgaonkar
 * 1. Basics of Java: Concept of Class,Object, State(instance variable) and Methods(behaviour) 
 */
public class Zoo implements Comparable<Zoo> {
	
	private int numberOfCells;
	/**
	 * class Zoo has state number of cells
	 * (cells house animals)
	 */
//	constructor which initializes number of cells
	Zoo(int a){
		numberOfCells=a;
	}
//	method to retrieve number of cells
	public int getNumberOfCells() {
		return numberOfCells;
	}
	public static void main(String[] args) {
		
// 		Instantiating an object of zoo with 5 cells
		Zoo z= new Zoo(5);
//		getting the number of cells in z
		int n=z.getNumberOfCells();
		System.out.println("Number of cells in zoo: "+n);
	}
	
//	compareTo method used in part 7 in this assignment
	public int compareTo(Zoo b) {
		return this.getNumberOfCells()-b.getNumberOfCells();
	}

}

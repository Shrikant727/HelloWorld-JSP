
package com.practice.firstassignment;

/**
 * @author Shrikant_Bhadgaonkar
 * 2.Basic Datatypes, variable types, Modifier types, final keyword, Constructors
 */
final public class GameScreen {

	/**
	 * this class holds the configuration and properties of the current state of a game screen.
	 * no class can extend this as this is final.
	 */

//	instance variables-------------------
//	bit depth of the screen, set to default as 8
	private int depth=8;
//	status variable to check if screen is active.
	protected boolean isActive=false;
//	screen width and height
	private final int screenWidth=100,screenHeight=100;
//	float and double values
	public float gamma=85.0f;
	public double opacity=85.86;
//	unique identifier
	long uid=123258459823424L;
//	primary orientation
	String orient="portrait";
//	scaling
	char scale='v';
//	class variables---------------------
//	static refresh counter
	static int refreshCount=0;
	
//	Constructor:
	GameScreen(GameScreen old){
		this.depth=old.depth;
		this.gamma=old.gamma;
	}
	GameScreen(){}
//	no overriding due to final status of method
	final void modifydepth(int d) {
//		local variables-----------------
		int newDepth=d;
		depth=newDepth;
	}
	int getDepth() {return depth;}
 public int getRefreshCount() {
	 	refreshCount+=1;
		return refreshCount;
	}
 
	
	public static void main(String[] args) {
		// Instantiating objects
		GameScreen first=new GameScreen();
		System.out.println("Depth of First GameScreen: "+first.getDepth());
		first.modifydepth(10);
		System.out.println("RefreshCount of First GameScreen: "+first.getRefreshCount());
		GameScreen second=new GameScreen(first);
		System.out.println("Depth of Second GameScreen: "+second.getDepth());
		System.out.println("RefreshCount of Second GameScreen: "+second.getRefreshCount());
	}

}

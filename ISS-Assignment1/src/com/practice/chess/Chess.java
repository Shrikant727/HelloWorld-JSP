//Created a new package
package com.practice.chess;

/**
 * @author Shrikant_Bhadgaonkar
 * 5.Inheritance,Overriding,Polymorphism,Abstraction,Encapsulation,Interfaces,Packages
 */
public class Chess {

	// Interface representing the common behavior for all game pieces
	public interface GamePiece {
	    void move();
	}

//	Abstract class for common properties of chess pieces
	public abstract class ChessPiece implements GamePiece {
	    protected int x;
	    protected int y;
//	constructor
	    ChessPiece(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

//	Abstract method to be implemented by concrete classes
	    public abstract void move();

//	Common method for displaying the position
	    public void displayPosition() {
	        System.out.println("Current position: (" + x + ", " + y + ")");
	    }
	}

//	Concrete classes representing a specific chess piece
	public class Bishop extends ChessPiece {
	    public Bishop(int x, int y) {
	        super(x, y);
	    }

//	Overriding the move method for the specific behavior of a bishop
	    @Override
	    public void move() {
	        System.out.println("Bishop will move diagonally.");
	    }
	}

	public class Knight extends ChessPiece {
	    public Knight(int x, int y) {
	        super(x, y);
	    }

	    @Override
	    public void move() {
	        System.out.println("Knight will move in an L-shape.");
	    }
	}
	public static void main(String[] args) {
		Chess chess=new Chess();
		Bishop whiteBishop1=chess.new Bishop(2,0);
		Knight blackKnight1=chess.new Knight(1,7);
		whiteBishop1.move();
		blackKnight1.move();
		
		

	}

}

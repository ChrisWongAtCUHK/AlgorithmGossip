package algo;

import java.util.*;
import static java.lang.Math.abs;
import static java.lang.System.out;

class Queen {
	final int x, y;
	
	/**
	  * Constructor 
	  */
	Queen(int x, int y){
		this.x = x;
		this.y = y;
	}

	/**
	  * @return the string of coordinates with format
	  */
	public String toString(){
		return String.format("(%d, %d)", x, y);
	}
}

/**
  * <a href="http://openhome.cc/Gossip/AlgorithmGossip/EightQueen.htm#Java">Queens</a>
  */
public class Queens {

	/**
	  *	@param n the dimension of the chess board
	  * @return the list of list of queens
	  */
	public static List<List<Queen>> queens(int n){
		return placeQueens(n, n);	
	}

	/**
	  *	@param n number of column of the chess board 
	  *	@param k number of row of the chess board 
	  * @return the list of list of queens
	  */
	public static List<List<Queen>> placeQueens(int n, int k){
		List<List<Queen>> queensList = new ArrayList<List<Queen>>();
		if(k == 0){
			// end of recursion
			queensList.add(new ArrayList<Queen>());
		} else {
			for(List<Queen> queens : placeQueens(n, k - 1)){	// recursive search
				for(int column = 1; column <= n; column++){		// column by column
					Queen queen = new Queen(k, column);
					if(isSafe(queen, queens)){
						List<Queen> qs = new ArrayList<Queen>();
						qs.addAll(queens);
						qs.add(queen);
						queensList.add(qs);
					}
				}
			}
		}
		
		// return all
		return queensList;
	}

	/**
	  *	Check a queen if it is on the same column/row/diagonal with other queens on the chess board
	  * @param queen the queen to be checked
	  * @param queens the queens already on the chess board
	  */
	public static boolean isSafe(Queen queen, List<Queen> queens){
		for(Queen q: queens){
			if(inCheck(queen, q)){
				return false;
			}
		}

		return true;
	}

	/**
	  * Compare two queens if they are on the same colum/row/diagonal
	  * @param q1 the first queen
	  * @param q2 the second queen
	  * @return boolean of two queens on the same colum/row/diagonal
	  */
	public static boolean inCheck(Queen q1, Queen q2){
		return q1.x == q2.x ||	// same column
			   q1.y == q2.y ||  // same row
			   abs(q1.x - q2.x) == abs(q1.y - q2.y);	// diagonal
	}

	/**
	  * Main program
	  */
	public static void main(String[] args){
		for(List<Queen> queens: queens(8)){
			for(Queen queen: queens){
				out.print(queen);
			}
			out.println();
		}
		
	}
}

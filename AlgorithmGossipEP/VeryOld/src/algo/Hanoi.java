package algo;

import java.util.*;

import static java.lang.System.out;

/**
 * @author Chris Wong
 * <p>
 * <a href="http://openhome.cc/Gossip/AlgorithmGossip/HanoiTower.htm">Hanoi</a>
 * </p>
 */
public class Hanoi {
	
	/**
	 * @author Chris Wong
	 *
	 */
	static class Move {
		char from, to;
		Move(char from, char to){
			this.from = from;
			this.to = to;
		}
	}
	
	/**
	 * Store the moves of plates
	 */
	private List<Move> moves;
	
	
	/**
	 * @param n	current move counter
	 * @param a	pole a
	 * @param b pole b
	 * @param c pole c
	 */
	private void move(int n, char a, char b, char c){
		if(n == 1){
			moves.add(new Move(a, c));
		} else {
			move(n - 1, a, c, b);
			move(1, a, b, c);
			move(n - 1, b, a, c);
		}
	}
	
	/**
	 * @param n kick out the solution
	 * @return the moves
	 */
	List<Move> solve(int n){
		moves = new ArrayList<Move>();
		move(n, 'A', 'B', 'C');
		return moves;
	}
	
	/**
	 * @param args
	 */
	public static void main(String args[]){
		out.format("請輸入盤數:");
		Hanoi hanoi = new Hanoi();
		try {
			int n = new Scanner(System.in).nextInt();
			for(Move move: hanoi.solve(n)){
				out.format("盤由  %c 移至 %c%n", move.from, move.to);
			}
		} catch (NumberFormatException nfe) {
			out.format("Not a number");
		}
	}
}

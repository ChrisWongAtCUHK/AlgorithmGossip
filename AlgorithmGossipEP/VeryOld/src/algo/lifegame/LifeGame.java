package algo.lifegame;

import java.util.*;
import static java.lang.System.out;

/**
  *	<a href="http://openhome.cc/Gossip/AlgorithmGossip/LifeGame.htm#Java">LifeGame</a> 
  */
public class LifeGame{
	
	/** Create the 2-D array of cells.
	  *	@param	rowData	a 2-D array of int
	  *	@return			a 2-D array of cells
	  */
	public static Cell[][] asCells(int[][] rowData){
		Cell[][] cells = new Cell[rowData.length][rowData[0].length];
		for(int i = 0; i < rowData.length; i++){
			for(int j = 0; j < rowData[i].length; j++){
				if(rowData[i][j] == 1){
					cells[i][j] = new Cell(i, j);
				}
			}
		}

		return cells;
	}

	/** Get or create a cell.
	  *	@param 	cells	the 2-D array of cells
	  * @param	i		the row
	  * @param	j		the colum
	  *	@return			a cell instance
	  */
	public static Cell getOrNew(Cell[][] cells, int i, int j){
		return cells[i][j] == null ? new Cell(i, j) : cells[i][j];
	}

	/** Produce the next 2-D array of cells.
	  * @param current	the current 2-D array of cells	
	  *	@return 		the next 2-D array of cells
	  */
	public static Cell[][] produce(Cell[][] current){
		Cell[][] next = new Cell[current.length][current[0].length];
		for(int i = 0; i < current.length; i++){
			for(int j = 0; j < current.length; j++){
				next[i][j] = getOrNew(current, i, j).seekToSurvive(current);
			}
		}
		return next;
	}

	/** Print out the 2-D array of cells.
	  * @param cells	2-D array of cells to be printed
	  */
	public static void print(Cell[][] cells){
		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i < cells[0].length + 2; i++){
			out.print('-');
		}
		out.println();
		
		for(int i = 0; i < cells.length; i++){
			out.print('|');
			for(int j = 0; j < cells[i].length; j++){
				out.print(cells[i][j] == null ? '~' : '*');
			}
			out.println('|');
		}
		
		for(int i = 0; i < cells[0].length + 2; i++){
			out.print('-');
		}
		out.println();
		out.println();

		// exit command
		String next = scanner.nextLine();
		next = next.toLowerCase();
		if(next.equals("exit") || next.equals("quit")){
			System.exit(0);
		}

	}

	/** Main Program.
	  */
	public static void main(String[] args){
		Cell[][] current = asCells(new int[][] {
				{0, 1, 0, 1, 0, 0, 0, 0, 1, 1},
				{0, 1, 0, 1, 0, 0, 0, 0, 1, 1},
				{0, 1, 0, 1, 0, 0, 0, 0, 1, 1},
				{0, 1, 1, 1, 0, 0, 1, 0, 1, 1},
				{0, 1, 1, 1, 0, 1, 0, 0, 1, 1},
				{0, 1, 0, 1, 1, 0, 0, 1, 1, 1},
				{0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
				{0, 1, 0, 1, 0, 0, 1, 0, 1, 1},
				{0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
				{0, 1, 0, 1, 1, 0, 0, 0, 1, 1}});

		print(current);
		Cell[][] next = produce(current);

		while(!Arrays.deepEquals(current, next)){
			current = next;
			print(current);
			next = produce(current);
		}
	}
}


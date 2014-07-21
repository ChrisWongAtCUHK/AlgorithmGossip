package algo.lifegame;

import java.util.*;
import static java.lang.System.out;

class Cell{
	final int i, j;
	
	public Cell(int i, int j){
		this.i = i;
		this.j = j;
	}

	/**
	  * @param current 	current 2-D array of cell 
	  * @return 		the  
	  */
	public Cell seekToSurvive(Cell[][] current){
		return isLivable(current) ? this : null;
	}
	
	/**
	  *	@param cells the 2-D array of cells 
	  * @return the boolean value if this cell is livable, i.e. 2 or 3
	  */
	public boolean isLivable(Cell[][] cells){
		switch(neighbors(cells)){
			case 0: case 1: case 4: return false;
			case 2: return this == cells[i][j]; 
		}

		// case 3
		return true;
	}

	public int neighbors(Cell[][] cells){
		int dirs[][] = {{-1,  0}, {-1,  1}, { 0,  1}, { 1,  1},
						{ 1,  0}, { 1, -1}, { 0, -1}, {-1, -1}};	
		
		int count = 0;

		// when count is larger than 4, this cell is not livable
		for(int i = 0; i < 8 && count < 4; i++){
			int r = this.i + dirs[i][0];
			int c = this.j + dirs[i][1];

			if(r > -1 && r < cells.length && c > -1 && c < cells[0].length && cells[r][c] != null){
				count++;	
			}
		}

		return count;
	}

	public boolean equals(Object obj){
		if(obj == null || getClass() != obj.getClass()){
			return false;		
		}

		final Cell that = (Cell)obj;
		return this.i == that.i && this.j == that.j;
	}

	public int hashCode(){
		int hash = 7;
		hash = 59 * hash + this.i;
		hash = 59 * hash + this.j;

		return hash;
	}
}

/**
  *	<a href="http://openhome.cc/Gossip/AlgorithmGossip/LifeGame.htm#Java">LifeGame</a> 
  */
public class LifeGame{

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

	public static Cell getOrNew(Cell[][] cells, int i, int j){
		return cells[i][j] == null ? new Cell(i, j) : cells[i][j];
	}

	public static Cell[][] produce(Cell[][] current){
		Cell[][] next = new Cell[current.length][current[0].length];
		for(int i = 0; i < current.length; i++){
			for(int j = 0; j < current.length; j++){
				next[i][j] = getOrNew(current, i, j).seekToSurvive(current);
			}
		}
		return next;
	}

	/**
	  * @param cells	2-D array of cells
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

	/**
	  * Main Program
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


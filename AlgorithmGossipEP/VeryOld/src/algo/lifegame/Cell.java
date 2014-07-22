package algo.lifegame;

import java.util.*;
import static java.lang.System.out;

/**
  *	Cell
  */
public class Cell{
	final int i, j;

	/** Constructor.
	  *	@param	i	row
	  *	@param	j	column
	  */
	public Cell(int i, int j){
		this.i = i;
		this.j = j;
	}

	/** Seek the survive cell.
	  * @param current 	current 2-D array of cell 
	  * @return 		the survive cell
	  */
	public Cell seekToSurvive(Cell[][] current){
		return isLivable(current) ? this : null;
	}
	
	/** Check if this cell is livable or not.
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

	/** Count the number of neighbors of this cell
	  *	@param	cells	the 2-D array of cells
	  *	@return			the number of neighbors of this cell 
	  */
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


package algo;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Chris Wong
 * <p>
 *  Point contains coordinates in form of (x, y) 
 * </p>
 */
class Point {
    final int x;
    final int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * @author Chris Wong
 *	<p>
 *	<a href="http://openhome.cc/Gossip/AlgorithmGossip/MouseGoMaze.htm#Java">Mouse</a>
 *	</p>
 */
public class Mouse {
    /** Go from one point to another point
     * @param maze	integer 2d-array
     * @param start	start point
     * @param end	end point
     * @return		integer 2d-array
     */
    public static ArrayList<ArrayList<Integer>> go(ArrayList<ArrayList<Integer>> maze, Point start, Point end) {
        visit(maze, start, end);
        return maze;
    }
    
    /**	Take a visit
     * @param maze	integer 2d-array
     * @param pt	the point
     * @param end	the end point
     * @return		if end point could be found
     */
    public static boolean visit(ArrayList<ArrayList<Integer>> maze, Point pt, Point end) {
        if(isVisitable(maze, pt)) {
        	maze.get(pt.x).set(pt.y, 1);
            printMaze(maze, pt.x, pt.y);

            if(!isEnd(maze, end) && !tryOneOut(maze, pt, end)) {
            	maze.get(pt.x).set(pt.y, 0);
                printMaze(maze, pt.x, pt.y);
            } 
            
        }
        return isEnd(maze, end);
    }

    /**	Check if the point could be visited
     * @param maze	integer 2d-array
     * @param pt	the point
     * @return		if the point is visitable
     */
    public static boolean isVisitable(ArrayList<ArrayList<Integer>> maze, Point pt) {
    	return maze.get(pt.x).get(pt.y).intValue() == 0;
    }
    
    /**	Check if a point is the end point
     * @param maze	integer 2d-array
     * @param end	the end point
     * @return		if end point is found
     */
    public static boolean isEnd(ArrayList<ArrayList<Integer>> maze, Point end) {
        return maze.get(end.x).get(end.y).intValue() == 1;
    }
    
    /** Make visits in four directions
     * @param maze	integer 2d-array
     * @param pt	the point
     * @param end	the end point
     * @return
     */
    public static boolean tryOneOut(ArrayList<ArrayList<Integer>> maze, Point pt, Point end) {
        return visit(maze, new Point(pt.x, pt.y + 1), end) ||
               visit(maze, new Point(pt.x + 1, pt.y), end) ||
               visit(maze, new Point(pt.x, pt.y - 1), end) ||
               visit(maze, new Point(pt.x - 1, pt.y), end);
    }
    
    public static void printMaze(ArrayList<ArrayList<Integer>> maze, int x, int y){
    	for(ArrayList<Integer> row : maze) {
	    	for(Integer block : row) switch(block.intValue()) {
		        case 0: out.print(" "); break;
		        case 1: out.print("."); break;
		        case 2: out.print("#");
		    }
		    out.println();
    	}
    	out.println("(" + x + ", " + y + ")");
    	out.println("--------------------------");
    	Scanner scanner = new Scanner(System.in);
    	//scanner.nextLine();
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
    	ArrayList<ArrayList<Integer>> maze = new ArrayList<ArrayList<Integer>>();
    	try {
			FileInputStream fis = new FileInputStream("maze.txt");
			DataInputStream dis = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(dis));
			String strLine;
			try {
				while((strLine = br.readLine()) != null){	// read file line by line
					String[] strings = strLine.split(",");
					ArrayList<Integer> row = new ArrayList<Integer>();
					for(String s: strings){					// read line one element by one element
						row.add(Integer.valueOf(s.trim()));
					}
					maze.add(row);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

    	
        int[][] aMaze = new int[][]{{2, 2, 2, 2, 2, 2, 2}, 
                                   {2, 0, 0, 0, 0, 0, 2}, 
                                   {2, 0, 2, 0, 2, 0, 2}, 
                                   {2, 0, 0, 2, 0, 2, 2}, 
                                   {2, 2, 0, 2, 0, 2, 2}, 
                                   {2, 0, 0, 0, 0, 0, 2}, 
                                   {2, 2, 2, 2, 2, 2, 2}};
                                   
        for(ArrayList<Integer> row: Mouse.go(maze, new Point(1, 1), new Point(5, 5))) {
        	for(Integer block : row) switch(block.intValue()) {
		        case 0: out.print(" "); break;
		        case 1: out.print("."); break;
		        case 2: out.print("#");
		    }
            out.println();
        }
        out.println(Mouse.isEnd(maze, new Point(5, 5)) 
                    ? "找到出口" : "沒有找到出口！");
    }
} 
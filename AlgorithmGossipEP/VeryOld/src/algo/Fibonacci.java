package algo;

import java.util.*;
/**
 * @author Chris Wong
 * <p>
 * <a href="http://openhome.cc/Gossip/AlgorithmGossip/FibonacciNumber.htm.htm">Fibonacci</a>
 * </p>
 */
public class Fibonacci {

	/**
	 * 
	 */
	private List<Integer> fib = new ArrayList<>();
	{
		fib.add(0);
		fib.add(1);
	}
	
	/**
	 * @param n index of list
	 * @return nth fibonacci number
	 */
	Integer get(int n){
		if(n >= fib.size()){
			for(int i = fib.size(); i <= n; i++){
				fib.add(fib.get(i - 1) + fib.get(i - 2));
			}
		}
		
		return fib.get(n);
	}
	
	public static void main(String[] args){
		Fibonacci fibonacci = new Fibonacci();
		String arg = System.getProperty("n");
		try {
			
			int n = Integer.valueOf(arg);
			for(int i = 0; i < n; i++){
				System.out.format("%d %n", fibonacci.get(i));
			}
		} catch (NumberFormatException nfe) {
			System.out.format("%s is not an integer.%n", arg);
		}
	}
}
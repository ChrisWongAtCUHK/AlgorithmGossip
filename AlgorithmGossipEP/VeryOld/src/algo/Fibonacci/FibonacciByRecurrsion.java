package algo.Fibonacci;

/**
 * @author Chris Wong
 * <p>
 * <a href="http://openhome.cc/Gossip/AlgorithmGossip/FibonacciNumber.htm.htm">FibonacciByRecurrsion</a>
 * </p>
 */
public class FibonacciByRecurrsion {

	/**
	 * @param n index of fibonacci number
	 * @return fibonacci number result
	 */
	public static int fib(int n){
		if((n == 0) || (n == 1)){
			return n;
		}
		
		return fib(n - 1) + fib(n - 2);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String arg = System.getProperty("n");
		try {
			int n = Integer.valueOf(arg);
			for(int i = 0; i < n; i++){
				System.out.format("fib(%d)=%d %n", i, fib(i));
			}
		} catch (NumberFormatException nfe) {
			System.out.format("%s is not an integer.%n", arg);
		}
	}

}

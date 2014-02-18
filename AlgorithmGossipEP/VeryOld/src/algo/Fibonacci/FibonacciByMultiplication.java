package algo.Fibonacci;

/**
 * @author Chris Wong
 * <p>
 * <a href="http://openhome.cc/Gossip/AlgorithmGossip/FibonacciNumber.htm.htm">FibonacciByMultiplication</a>
 * </p>
 */
public class FibonacciByMultiplication {
	
	/**
	 * @param n index of fibonacci number
	 * @return fibonacci number result
	 */
	public static int fib(int n){
		if((n == 0) || (n == 1)){
			return n;
		}
		
		if(n == 2){
			return 1;
		}
		
		int i = n/2;
		int f1 = fib(i + 1);
		int f2 = fib(i);
		
		if((n % 2) == 0)
			return (f2 * (2 * f1 -f2));
		
		return f1 * f1 + f2 * f2;
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

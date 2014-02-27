package test.algo.FibonacciNumber;

import java.math.BigInteger;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import algo.FibonacciNumber.*;

/**
 * @author Chris Wong
 * <p>
 *  <a href="http://openhome.cc/Gossip/JUnit/JUnit4.html">FibonacciByArrayTest</a>
 * </p>
 */
@RunWith(value=Parameterized.class)
public class FibonacciByArrayTest {
	/**
	 * @return the 2d-array of expected values and parameters
	 */
	@Parameterized.Parameters
    public static Collection<String[]> getParameters() {
        return Arrays.asList(
            new String[][] {
                {"0", "0"}, //expected, n
                {"1", "1"}, //expected, n
                {"1", "2"}, //expected, n
                {"2", "3"}, //expected, n
                {"3", "4"}, //expected, n
                {"5", "5"}, //expected, n
                {"8", "6"}, //expected, n
                {"13", "7"}, //expected, n
                {"21", "8"}, //expected, n
                {"34", "9"}, //expected, n
                {"55", "10"}, //expected, n
                {"89", "11"}, //expected, n
                {"144", "12"}, //expected, n
                {"233", "13"}, //expected, n
                {"377", "14"}, //expected, n
                {"610", "15"}, //expected, n
                {"987", "16"}, //expected, n
                {"1597", "17"}, //expected, n
                {"2584", "18"}, //expected, n
                {"4181", "19"}, //expected, n
                {"6765", "20"}, //expected, n
                {"10946", "21"} //expected, n
                // if your are in...,
                // http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibtable.html
            }
        );
    }
    
    private String expected;
    private String n;
    
    /**
     * @param expected expected result
     * @param n parameter for get() method 
     */
    public FibonacciByArrayTest(String expected, String n) {
        this.expected = expected;
        this.n = n;
    }
    
    @Test
    public void testPlus() {
    	FibonacciByArray fibonacciByArray = new FibonacciByArray();
    	String result = fibonacciByArray.get(Integer.valueOf(n).intValue()).toString();
        assertEquals(expected, result);
    }
}

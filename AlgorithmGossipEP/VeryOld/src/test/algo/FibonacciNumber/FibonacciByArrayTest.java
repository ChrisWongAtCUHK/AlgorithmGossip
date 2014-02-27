package test.algo.FibonacciNumber;

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
    public static Collection<Integer[]> getParameters() {
        return Arrays.asList(
            new Integer[][] {
                {0, 0}, //expected, n
                {1, 1}, //expected, n
                {1, 2}  //expected, n
            }
        );
    }
    
    private int expected;
    private int n;
    
    /**
     * @param expected expected result
     * @param n parameter for get() method 
     */
    public FibonacciByArrayTest(int expected, int n) {
        this.expected = expected;
        this.n = n;
    }
    
    @Test
    public void testPlus() {
    	FibonacciByArray fibonacciByArray = new FibonacciByArray();
        int result = fibonacciByArray.get(n).intValue();
        assertEquals(expected, result);
    }
}

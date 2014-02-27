package test.algo.FibonacciNumber;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import algo.FibonacciNumber.*;

@RunWith(value=Parameterized.class)
public class FibonacciByArrayTest {
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

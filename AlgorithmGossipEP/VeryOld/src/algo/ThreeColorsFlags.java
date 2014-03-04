package algo;

/**
 * @author Chris Wong
 *
 * <p>
 *  <a href="http://openhome.cc/Gossip/AlgorithmGossip/ThreeColorsFlags.htm">ThreeColorsFlags</a>
 * </p>
 */
public class ThreeColorsFlags {
    /**
     * @param arr	array to be swapped
     * @param x		index of first element
     * @param y		index of second element
     */
    private static void swap(char[] arr, int x, int y) {
        char tmp = arr[x]; 
        arr[x] = arr[y]; 
        arr[y] = tmp;
        // show the steps in verbose
        for(char c: arr){
        	System.out.print(c);
        }
        System.out.println();
    }
    
    /**
     * @param flags
     * @return the string after algorithm
     */
    public static String adjust(String flags) {
        char[] fs = flags.toCharArray();
        
        int b = 0, w = 0, r = fs.length - 1;
        while(fs[w] == 'B' && w < fs.length) { b++; w++; }
        while(fs[r] == 'R' && r > 0) { r--; }
        while(w <= r) switch(fs[w]) {
            case 'W': 
                w++;
                break;
            case 'B': 
                swap(fs, b, w);
                b++; w++; 
                break;
            case 'R': 
                swap(fs, r, w);
                r--;
        }
        
        return new String(fs);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
    	
    	// modification for apache ant
        System.out.println(adjust(System.getProperty("flags")));
    }
}

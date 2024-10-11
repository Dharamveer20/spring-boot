import org.junit.Test;

import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MyAssertTest {
    List<String> names = Arrays.asList("Aano", "Bano", "Cano");

    @Test
    public void testAsserts(){
        boolean banoPresent = names.contains("Bano");

//        Below para 1 == True ? Pass the Test case : Fail the Test Case
        assertTrue(banoPresent); // Test Case will pass

//        Ulta of assertTrue
        assertFalse(banoPresent);

//        Checks if expected and returned same hai ki nhi
        assertArrayEquals(new int []{1,2,3}, new int[]{2,3});
//         More Assertion methods :- assertNull, assertNotNull,etc.
    }
}

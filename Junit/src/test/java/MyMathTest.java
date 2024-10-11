import com.studyjunit.junit.MyMath;
import org.junit.jupiter.api.*;

import static org.junit.Assert.assertEquals;

class MyMathTest {
        MyMath myMath = new MyMath();
    @Test
    void calcSumTestForThreeValArray(){
//        assertEquals checks if both para matches or not. Matches ? Test Passed : Test Failed
        Assertions.assertEquals(6, myMath.calcSum(new int [] {1,2,3})); // Para 1: Expected Op. Para 2: Actual Result
    }

    @Test
    void calcSumForZeroValArray(){
        Assertions.assertEquals(9, myMath.calcSum(new int [] {}));
    }
}

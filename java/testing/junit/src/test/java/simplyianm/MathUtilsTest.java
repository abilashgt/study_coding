package simplyianm;

import org.junit.Test;
import simplyianm.MathUtils;
import static org.junit.Assert.*;


public class MathUtilsTest {
    @Test
    public void testMultiply(){
        double a = 5;
        double b = -4.0;
        double expected = - 20.0;

        double result = MathUtils.multiply(a, b);

        assertEquals(expected, result, 0.00001);
    }
}

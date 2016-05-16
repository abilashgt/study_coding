package simplyianm;

import org.junit.*;
import static org.junit.Assert.*;


public class Vector3Test {
    Vector3 vector3;

    @BeforeClass
    public static void setUpClass(){
        System.out.println("== setup class");
    }

    @Before
    public void setUp(){
        System.out.println("== setup");
        vector3 = new Vector3(1, 1, 1);
    }

    @After
    public void tearDown(){
        System.out.println("= tear down");
        vector3 = null;
    }

    @AfterClass
    public static void tearDownClass(){
        System.out.println("== tear down class");
    }

    @Test
    public void testMultiply(){
        Vector3 expected = new Vector3(2.0, 2.0, 2.0);
        Vector3 result = vector3.multiply(2);

        assertEquals(expected, result);
    }

    @Test
    public void testDivide(){
        Vector3 expected = new Vector3(0.5, 0.5, 0.5);
        Vector3 result = vector3.divide(2);

        assertEquals(expected, result);
    }
}

package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FibonacciNumbersTest {
    FibonacciNumbers fn;

    @Before
    public void setUp(){
        fn = new FibonacciNumbers();
    }

    @Test
    public void should_return_1_when_calculate_value_given_1_position(){
        long value[] = fn.create(1);
        assertEquals(1, value[0]);
    }

    @Test
    public void should_return_1_when_calculate_value_given_2_position(){
        long value[] = fn.create(2);
        assertEquals(1, value[1]);
    }

    @Test
    public void should_return_2_when_calculate_value_given_3_position(){
        long value[] = fn.create(3);
        assertEquals(2, value[2]);
    }

    @Test
    public void should_return_3_when_calculate_value_given_4_position(){
        long value[] = fn.create(4);
        assertEquals(3, value[3]);
    }

    @Test
    public void should_return_12586269025L_when_calculate_value_given_50_position(){
        long value[] = fn.create(50);
        assertEquals(12586269025L, value[49]);
    }


    @Test
    public void should_return_1_1_2_when_create__fibonacci_numbers(){
        long[] finonacciNumbers = fn.create(3);
        assertEquals(finonacciNumbers[0],1);
        assertEquals(finonacciNumbers[1],1);
        assertEquals(finonacciNumbers[2],2);
    }


}

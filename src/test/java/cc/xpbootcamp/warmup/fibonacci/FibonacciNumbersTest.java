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
        long value = fn.calculate(0);
        assertEquals(1, value);
    }

    @Test
    public void should_return_1_when_calculate_value_given_2_position(){
        long value = fn.calculate(1);
        assertEquals(1, value);
    }

    @Test
    public void should_return_2_when_calculate_value_given_3_position(){
        long value = fn.calculate(2);
        assertEquals(2, value);
    }

    @Test
    public void should_return_3_when_calculate_value_given_4_position(){
        long value = fn.calculate(3);
        assertEquals(3, value);
    }

}

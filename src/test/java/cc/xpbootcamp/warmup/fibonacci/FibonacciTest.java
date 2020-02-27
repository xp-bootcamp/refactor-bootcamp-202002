package cc.xpbootcamp.warmup.fibonacci;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciTest {
    @Test
    void should_return_1_when_calc_position_is_1() {
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.getFibonacci(1);
        assertEquals(1, result);

    }

    @Test
    void should_return_2_when_calc_position_is_1() {
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.getFibonacci(2);
        assertEquals(1, result);
    }

    @Test
    void should_return_8_when_calc_position_is_6() {
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.getFibonacci(6);
        assertEquals(8, result);
    }

    @Test
    void should_return_12586269025L_when_calc_position_is_50() {
        Fibonacci fibonacci = new Fibonacci();
        long result = fibonacci.getFibonacci(50);
        assertEquals(12586269025L, result);
    }

    @Test
    void should_throw_Exception_when_position_lower_than_1_or_upper_than_50() {
        Fibonacci fibonacci = new Fibonacci();
        assertThrows(ValueException.class, () ->fibonacci.getFibonacci(0), "position is out of bounding");
        assertThrows(ValueException.class, () ->fibonacci.getFibonacci(51), "position is out of bounding");
    }
}

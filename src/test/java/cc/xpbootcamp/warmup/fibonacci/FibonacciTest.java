package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}

package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciNumbers {
    public long calculate(int i) {
        if (i == 0 || i == 1) return 1;
        return calculate(0) + calculate(1);
    }
}

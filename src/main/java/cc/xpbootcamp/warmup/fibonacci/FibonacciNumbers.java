package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciNumbers {
    public long calculate(int index) {
        if (index == 0 || index == 1) return 1;
        return calculate(index - 1) + calculate(index - 2);
    }
}

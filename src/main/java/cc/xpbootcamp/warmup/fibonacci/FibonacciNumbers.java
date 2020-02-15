package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciNumbers {

    public long calculate(int index) {
        if (index == 0 || index == 1) return 1;
        return calculate(index - 1) + calculate(index - 2);
    }

    public long[] create(int length) {
        long[] numbers = new long[length];
        for(int i = 0; i< length; i++){
            numbers[i] = calculate(i);
        }
        return numbers;
    }

}

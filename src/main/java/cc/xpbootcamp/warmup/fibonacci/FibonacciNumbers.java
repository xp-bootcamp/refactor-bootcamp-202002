package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciNumbers {

    public long[] create(int length) {
        long[] numbers = new long[length];
        for(int i = 0; i< length; i++){
            if(i ==0 || i == 1) numbers[i] = 1;
            else  numbers[i] = numbers[i-1] + numbers[i-2];
        }
        return numbers;
    }

}

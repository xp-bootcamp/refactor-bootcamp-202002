package cc.xpbootcamp.warmup.fibonacci;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class Fibonacci {

    public Fibonacci() {
    }

    public long getFibonacci(int position) {
        if (position <1 || position>50){
            throw new ValueException("position is out of bounding");
        }
        if (position == 1) {
            return 1;
        }
        if (position == 2) {
            return 1;
        } else {
            return getFibonacci(position - 1) + getFibonacci(position - 2);
        }
    }
}

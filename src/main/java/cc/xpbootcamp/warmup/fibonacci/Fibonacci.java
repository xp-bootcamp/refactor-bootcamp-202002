package cc.xpbootcamp.warmup.fibonacci;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class Fibonacci {

    public Fibonacci() {
    }

    public long getFibonacci(int position) {
        if (position < 1 || position > 50) {
            throw new ValueException("position is out of bounding");
        } else if (position == 1 || position == 2) {
            return 1;
        } else {
            long f_1 = 1;
            long f_2 = 1;
            long result = 0;
            for (int i = 3; i <= position; i++) {
                result = f_1 + f_2;
                f_2 = f_1;
                f_1 = result;
            }
            return result;
        }
    }
}

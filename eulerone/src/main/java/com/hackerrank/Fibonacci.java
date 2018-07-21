package com.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public List<Long> generateSequenceUnder(long threshold) {
        List<Long> sequence = new ArrayList<Long>();

        long i = 0;
        int index = 0;
        while (i < threshold) {
            sequence.add(i);
            index++;
            if (i < 2) {
                i++;
            } else {
                i = sequence.get(index - 1) + sequence.get(index - 2);
            }
        }

        return sequence;
    }

    public long sumEvensIn(List<Long> sequence) {
        long result = 0;
        for (Long i : sequence) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }

}

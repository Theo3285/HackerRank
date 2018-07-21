package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciSolution {
    private Fibonacci fibonacci;

    public FibonacciSolution() {
        fibonacci = new Fibonacci();
    }

    public static void main(String... args) {
        FibonacciSolution app = new FibonacciSolution();
        app.run();
    }

    private void run() {
        List<Long> sums = new ArrayList<Long>();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            final List<Long> sequence = fibonacci.generateSequenceUnder(n);
            sums.add(fibonacci.sumEvensIn(sequence));
        }
        in.close();

        for (Long sum : sums) {
            System.out.println(sum);
        }

    }
}

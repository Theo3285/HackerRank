package com.hackerrank;

public class Serie {
    private final int a;
    private final int b;
    private final int n;

    public Serie(int a, int b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
    }

    public String generate() {
        StringBuilder result = new StringBuilder();

        for (int serie = 0; serie < n; serie++) {
            result.append(terms(serie));
            result.append(separator(serie));
        }

        return result.toString();
    }

    private String separator(int serie) {
        return serie < n - 1 ? " " : "";
    }

    private int terms(int serie) {
        int term = a;
        int exponent = 1;

        for (int j = 0; j <= serie; j++) {
            term += exponent * b;
            exponent = exponent + exponent;
        }

        return term;
    }
}

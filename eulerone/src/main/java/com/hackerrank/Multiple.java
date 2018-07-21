package com.hackerrank;

public class Multiple {
    public int generate(int i) {
        int multiple = 0;

        for (int j = 1; j < i; j++) {

            if(j % 3 == 0) {
                multiple += j;
            } else if (j % 5 == 0){
                multiple += j;
            }
        }
        return multiple;
    }
}

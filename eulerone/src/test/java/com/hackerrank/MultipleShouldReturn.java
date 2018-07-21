package com.hackerrank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MultipleShouldReturn {

    @Test
    @Parameters({
            "10, 23",
            "12, 33",
            "15, 45",
            "18, 60",
            "100, 2318",
            "1000, 233168"
    })
    public void sum_of_natural_numbers_multipliable_by_three_or_five(int in, int expected) {
        //ignore 5 when multipliable by both 3 and 5
        Multiple multiple = new Multiple();
        assertThat(multiple.generate(in), is(expected));
    }
}

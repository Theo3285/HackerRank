package com.hackerrank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class EvenFibonacciShouldReturn {

    private Fibonacci fibonacci;
    private List<Long> expectedSequence;

    @Before
    public void setUp() throws Exception {
        fibonacci = new Fibonacci();
        expectedSequence = new ArrayList<Long>();
        expectedSequence.add(new Long(0));
        expectedSequence.add(new Long(1));
        expectedSequence.add(new Long(2));
        expectedSequence.add(new Long(3));
        expectedSequence.add(new Long(5));
        expectedSequence.add(new Long(8));
        expectedSequence.add(new Long(13));
        expectedSequence.add(new Long(21));
        expectedSequence.add(new Long(34));
        expectedSequence.add(new Long(55));
        expectedSequence.add(new Long(89));
    }


    @Test
    public void fibonacci_list_under_ten_threshold() {
        assertSequence(fibonacci.generateSequenceUnder(10));
    }


    @Test
    public void fibonacci_list_under_fifteen_threshold() {
        assertSequence(fibonacci.generateSequenceUnder(15));
    }

    @Test
    public void fibonacci_list_under_one_hundred_threshold() {
        assertSequence(fibonacci.generateSequenceUnder(100));

    }

    @Test
    @Parameters({
            "3, 2",
            "10, 10",
            "100, 44"
    })
    public void sum_of_evens_in_fibonacci(long n, long expected) {
        List<Long> sequence = fibonacci.generateSequenceUnder(n);
        assertEquals(expected, fibonacci.sumEvensIn(sequence));
    }

    private void assertSequence(List<Long> sequence) {
        for (int i = 0; i < sequence.size(); i++) {
            assertThat(sequence.get(i), is(expectedSequence.get(i)));
        }
    }
}

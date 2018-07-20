package com.hackerrank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VariableShould {

    private TypesStatement statement;

    @Before
    public void setUp() throws Exception {
        statement = new TypesStatement();
    }

    @Test
    public void return_that_ten_billion_can_be_fitted_in_a_long_only() {
        Variable variable = new Variable(statement, "-100000000000000");
        String types = variable.determine();
        assertThat(types, is("-100000000000000 can be fitted in:\\n* long"));
    }

    @Test
    public void return_that_one_can_be_fitted_in_a_byte_short_int_and_long() {
        Variable variable = new Variable(statement, "1");
        String types = variable.determine();
        assertThat(types, is("1 can be fitted in:\\n* byte\\n* short\\n* int\\n* long"));
    }

    @Test
    public void return_that_a_hundred_fifty_thousand_can_be_fitted_in_int_and_long() {
        Variable variable = new Variable(statement, "150000");
        String types = variable.determine();
        assertThat(types, is("150000 can be fitted in:\\n* int\\n* long"));
    }

    @Test
    public void return_that_one_thousand_five_hundred_million_can_be_fitted_in_int_and_long() {
        Variable variable = new Variable(statement, "1500000000");
        String types = variable.determine();
        assertThat(types, is("1500000000 can be fitted in:\\n* int\\n* long"));
    }

    @Test
    public void return_that_long_number_does_not_fit_anywhere() {
        Variable variable = new Variable(statement, "213333333333333333333333333333333333");
        String types = variable.determine();
        assertThat(types, is("213333333333333333333333333333333333 can't be fitted anywhere."));
    }

}
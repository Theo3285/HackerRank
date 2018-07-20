package com.hackerrank;

import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class DatatypesShould {

    @Mock
    private Variable variable;

    @Test
    public void determine_and_store_datatypes_from_variables() {
        List<Variable> variables = Arrays.asList(variable);
        Datatypes datatypes = new Datatypes(variables);

        given(variable.determine()).willReturn("-150 can be fitted in:\n* short\n int* long");
        
        datatypes.determine();

        verify(va)
    }
}
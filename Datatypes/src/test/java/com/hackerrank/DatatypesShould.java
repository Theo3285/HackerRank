package com.hackerrank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DatatypesShould {

    @Mock
    private DatatypeOutputRepository datatypeOutputRepository;

    @Mock
    private TypeStatementOutputsPrinter typeStatementOutputsPrinter;

    @Mock
    private Variable variable;
    private List<Variable> variables;
    private Datatypes datatypes;

    @Before
    public void setUp() throws Exception {
        variables = asList(variable);
        datatypes = new Datatypes(
                datatypeOutputRepository,
                typeStatementOutputsPrinter,
                variables);
    }

    @Test
    public void determine_and_store_datatypes_from_variables() {
        given(variable.determine()).willReturn("-150 can be fitted in:\n* short\n int* long");

        datatypes.determine();

        verify(datatypeOutputRepository).add("-150 can be fitted in:\n* short\n int* long");
    }

    @Test
    public void print_type_statment_outputs() {
        List<String> typeStatementOutputs = asList("-150 can be fitted in:\n* short\n int* long");

        given(datatypeOutputRepository.all()).willReturn(typeStatementOutputs);

        datatypes.print();

        verify(typeStatementOutputsPrinter).print(typeStatementOutputs);

    }
}
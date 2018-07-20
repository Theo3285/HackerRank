package com.hackerrank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TypeStatementOutputsPrinterShould {

    @Mock
    private Console console;

    @Test
    public void print_type_statement_outputs() {
        TypeStatementOutputsPrinter typeStatementOutputsPrinter = new TypeStatementOutputsPrinter(console);
        List<String> typeStatementOutputs = asList("-150 can be fitted in:\n* short\n int* long");

        typeStatementOutputsPrinter.print(typeStatementOutputs);

        verify(console).printLine("-150 can be fitted in:\n* short\n int* long");
    }

}
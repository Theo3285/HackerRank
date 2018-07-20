package com.hackerrank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DatatypesFeature {

    @Mock
    private Console console;

    private DatatypeOutputRepository datatypeOutputRepository;

    private TypeStatementOutputsPrinter typeStatementOutputsPrinter;

    private TypesStatement statement;

    @Before
    public void setUp() throws Exception {
        datatypeOutputRepository = new DatatypeOutputRepository();
        typeStatementOutputsPrinter = new TypeStatementOutputsPrinter(console);
        statement = new TypesStatement();
    }

    @Test
    public void determine_and_print_primitive_datatypes_to_store_inputs() {
        List<Variable> variables = asList(
                new Variable(statement, "-150"),
                new Variable(statement, "150000"),
                new Variable(statement, "1500000000"),
                new Variable(statement, "213333333333333333333333333333333333"),
                new Variable(statement, "-100000000000000")
        );

        Datatypes datatypes = new Datatypes(
                datatypeOutputRepository,
                typeStatementOutputsPrinter,
                variables);

        datatypes.determine();

        datatypes.print();

        verify(console).printLine("-150 can be fitted in:\n* short\n* int\n* long");
        verify(console).printLine("150000 can be fitted in:\n* int\n* long");
        verify(console).printLine("1500000000 can be fitted in:\n* int\n* long");
        verify(console).printLine("213333333333333333333333333333333333 can't be fitted anywhere.");
        verify(console).printLine("-100000000000000 can be fitted in:\n* long");
    }
}

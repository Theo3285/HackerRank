package com.hackerrank;

import java.util.List;

public class Datatypes {

    private DatatypeOutputRepository datatypeOutputRepository;
    private TypeStatementOutputsPrinter typeStatementOutputsPrinter;

    private final List<Variable> variables;

    public Datatypes(DatatypeOutputRepository datatypeOutputRepository, TypeStatementOutputsPrinter typeStatementOutputsPrinter, List<Variable> variables) {
        this.datatypeOutputRepository = datatypeOutputRepository;
        this.typeStatementOutputsPrinter = typeStatementOutputsPrinter;
        this.variables = variables;
    }

    public void determine() {
        for (Variable variable : variables) {
            datatypeOutputRepository.add(variable.determine());
        }
    }

    public void print() {
        typeStatementOutputsPrinter.print(datatypeOutputRepository.all());
    }
}

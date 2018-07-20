package com.hackerrank;

import java.util.List;

public class TypeStatementOutputsPrinter {
    private Console console;

    public TypeStatementOutputsPrinter(Console console) {
        this.console = console;
    }

    public void print(List<String> typeStatementOutputs) {
        for (String typeStatementOutput : typeStatementOutputs) {
            console.printLine(typeStatementOutput);
        }
    }
}

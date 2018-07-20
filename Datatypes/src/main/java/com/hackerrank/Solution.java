package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private Console console;
    private DatatypeOutputRepository datatypeOutputRepository;
    private TypeStatementOutputsPrinter typeStatementOutputsPrinter;
    private TypesStatement statement;

    public Solution() {
        console = new Console();
        datatypeOutputRepository = new DatatypeOutputRepository();
        typeStatementOutputsPrinter = new TypeStatementOutputsPrinter(console);
        statement = new TypesStatement();
    }

    public static void main(String[] argh) {
        Solution app = new Solution();
        app.run();

    }

    private void run() {
        List<Variable> variables = new ArrayList<Variable>();

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            variables.add(new Variable(statement, sc.next()));
        }
        sc.close();

        Datatypes datatypes = new Datatypes(
                datatypeOutputRepository,
                typeStatementOutputsPrinter,
                variables);
        datatypes.determine();
        datatypes.print();
    }
}

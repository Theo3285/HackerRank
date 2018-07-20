import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static java.lang.Long.valueOf;

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

    private class Console {
        void printLine(String s) {
            System.out.println(s);
        }
    }

    private class DatatypeOutputRepository {
        List<String> typesStatementOutputs = new ArrayList<String>();

        void add(String typeStatementOutput) {
            typesStatementOutputs.add(typeStatementOutput);
        }

        List<String> all() {
            return typesStatementOutputs;
        }
    }

    private class TypeStatementOutputsPrinter {
        private Console console;

        TypeStatementOutputsPrinter(Console console) {
            this.console = console;
        }

        void print(List<String> typeStatementOutputs) {
            for (String typeStatementOutput : typeStatementOutputs) {
                console.printLine(typeStatementOutput);
            }
        }
    }

    private class TypesStatement {
        String appendAll(List<String> types, String value) {
            StringBuilder result = new StringBuilder();

            result.append(value);
            result.append(" can be fitted in:\n");

            Iterator<String> iter = types.iterator();
            while (iter.hasNext()) {
                result.append("* " + iter.next());
                result.append(newLine(iter));
            }

            return result.toString();
        }

        private String newLine(Iterator<String> iter) {
            return iter.hasNext() ? "\n" : "";
        }
    }

    private abstract class TypesRule {

        private TypesRule nextRule;

        void setSuccesor(TypesRule nextRule) {
            this.nextRule = nextRule;
        }

        void execute(List<String> types, String value) {
            if (nextRule != null) {
                nextRule.execute(types, value);
            }
        }
    }

    private class ByteRule extends TypesRule {

        void execute(List<String> types, String value) {
            if (fitsInByte(value)) {
                types.add("byte");
            }
            super.execute(types, value);
        }

        private boolean fitsInByte(String value) {
            return valueOf(value) >= Byte.MIN_VALUE && valueOf(value) <= Byte.MAX_VALUE;
        }
    }

    private class ShortRule extends TypesRule {

        void execute(List<String> types, String value) {
            if (fitsInShort(value)) {
                types.add("short");
            }
            super.execute(types, value);
        }

        private boolean fitsInShort(String value) {
            return valueOf(value) >= Short.MIN_VALUE && valueOf(value) <= Short.MAX_VALUE;
        }
    }

    private class IntRule extends TypesRule {

        void execute(List<String> types, String value) {
            if (fitsInInt(value)) {
                types.add("int");
            }
            super.execute(types, value);
        }

        private boolean fitsInInt(String value) {
            return valueOf(value) >= Integer.MIN_VALUE && valueOf(value) <= Integer.MAX_VALUE;
        }
    }

    private class LongRule extends TypesRule {

        void execute(List<String> types, String value) {
            if (fitsInLong(value)) {
                types.add("long");
            }
            super.execute(types, value);
        }

        private boolean fitsInLong(String value) {
            return valueOf(value) >= Long.MIN_VALUE && valueOf(value) <= Long.MAX_VALUE;
        }
    }

    class Variable {
        private TypesStatement statement;
        private final String value;

        private TypesRule byteRule = new ByteRule();
        private TypesRule shortRule = new ShortRule();
        private TypesRule intRule = new IntRule();
        private TypesRule longRule = new LongRule();

        Variable(TypesStatement statement, String value) {
            this.statement = statement;
            this.value = value;
            byteRule.setSuccesor(shortRule);
            shortRule.setSuccesor(intRule);
            intRule.setSuccesor(longRule);
        }

        String determine() {
            List<String> types = new ArrayList<String>();

            try {
                byteRule.execute(types, value);
            } catch (NumberFormatException e){
                return value + " can't be fitted anywhere.";
            }

            return statement.appendAll(types, value);
        }
    }

    private class Datatypes {

        private DatatypeOutputRepository datatypeOutputRepository;
        private TypeStatementOutputsPrinter typeStatementOutputsPrinter;

        private final List<Variable> variables;

        Datatypes(DatatypeOutputRepository datatypeOutputRepository, TypeStatementOutputsPrinter typeStatementOutputsPrinter, List<Variable> variables) {
            this.datatypeOutputRepository = datatypeOutputRepository;
            this.typeStatementOutputsPrinter = typeStatementOutputsPrinter;
            this.variables = variables;
        }

        void determine() {
            for (Variable variable : variables) {
                datatypeOutputRepository.add(variable.determine());
            }
        }

        void print() {
            typeStatementOutputsPrinter.print(datatypeOutputRepository.all());
        }
    }
}
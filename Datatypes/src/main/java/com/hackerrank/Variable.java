package com.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Variable {
    private TypesStatement statement;
    private final String value;

    private TypesRule byteRule = new ByteRule();
    private TypesRule shortRule = new ShortRule();
    private TypesRule intRule = new IntRule();
    private TypesRule longRule = new LongRule();

    public Variable(TypesStatement statement, String value) {
        this.statement = statement;
        this.value = value;
        byteRule.setSuccesor(shortRule);
        shortRule.setSuccesor(intRule);
        intRule.setSuccesor(longRule);
    }

    public String determine() {
        List<String> types = new ArrayList<>();

        try {
            byteRule.execute(types, value);
        } catch (NumberFormatException e){
            return value + " can't be fitted anywhere.";
        }

        return statement.appendAll(types, value);
    }
}

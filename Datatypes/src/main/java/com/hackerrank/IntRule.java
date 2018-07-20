package com.hackerrank;

import java.util.List;

import static java.lang.Long.valueOf;

public class IntRule extends TypesRule {

    public void execute(List<String> types, String value) {
        if (fitsInInt(value)) {
            types.add("int");
        }
        super.execute(types, value);
    }

    private boolean fitsInInt(String value) {
        return valueOf(value) >= Integer.MIN_VALUE && valueOf(value) <= Integer.MAX_VALUE;
    }
}

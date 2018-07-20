package com.hackerrank;

import java.util.List;

import static java.lang.Long.valueOf;

public class LongRule extends TypesRule {

    public void execute(List<String> types, String value) {
        if (fitsInLong(value)) {
            types.add("long");
        }
        super.execute(types, value);
    }

    private boolean fitsInLong(String value) {
        return valueOf(value) >= Long.MIN_VALUE && valueOf(value) <= Long.MAX_VALUE;
    }
}

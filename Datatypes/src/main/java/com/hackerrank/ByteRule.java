package com.hackerrank;

import java.util.List;

import static java.lang.Long.valueOf;

public class ByteRule extends TypesRule {

    public void execute(List<String> types, String value) {
        if (fitsInByte(value)) {
            types.add("byte");
        }
        super.execute(types, value);
    }

    private boolean fitsInByte(String value) {
        return valueOf(value) >= Byte.MIN_VALUE && valueOf(value) <= Byte.MAX_VALUE;
    }

}

package com.hackerrank;

import java.util.List;

import static java.lang.Long.valueOf;

public class ShortRule extends TypesRule {

    public void execute(List<String> types, String value) {
        if (fitsInShort(value)) {
            types.add("short");
        }
        super.execute(types, value);
    }

    private boolean fitsInShort(String value) {
        return valueOf(value) >= Short.MIN_VALUE && valueOf(value) <= Short.MAX_VALUE;
    }

}

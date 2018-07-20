package com.hackerrank;

import java.util.Iterator;
import java.util.List;

public class TypesStatement {
    public String appendAll(List<String> types, String value) {
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

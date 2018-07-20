package com.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class DatatypeOutputRepository {
    List<String> typesStatementOutputs = new ArrayList<>();

    public void add(String typeStatementOutput) {
        typesStatementOutputs.add(typeStatementOutput);
    }

    public List<String> all() {
        return typesStatementOutputs;
    }
}

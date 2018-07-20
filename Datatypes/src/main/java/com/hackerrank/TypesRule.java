package com.hackerrank;

import java.util.List;

public abstract class TypesRule {

    private TypesRule nextRule;

    public void setSuccesor(TypesRule nextRule) {
        this.nextRule = nextRule;
    }

    public void execute(List<String> types, String value) {
        if (nextRule != null) {
            nextRule.execute(types, value);
        }
    }
}

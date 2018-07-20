package com.hackerrank;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DatatypeOutputRepositoryShould {

    @Test
    public void store_a_type_statement() {
        DatatypeOutputRepository datatypeOutputRepository = new DatatypeOutputRepository();

        datatypeOutputRepository.add("-150 can be fitted in:\\n* short\\n* int\\n* long");

        List<String> typeStatementOutputs = datatypeOutputRepository.all();

        assertThat(typeStatementOutputs.size(), is(1));
        assertThat(typeStatementOutputs.get(0), is("-150 can be fitted in:\\n* short\\n* int\\n* long"));
    }

}
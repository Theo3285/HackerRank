package com.hackerrank;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SerieOutputRepositoryShould {

    @Test
    public void store_a_serie() {
        SerieOutputRepository serieOutputRepository = new SerieOutputRepository();
        serieOutputRepository.add("2");

        List<String> serieOutputs = serieOutputRepository.all();

        assertThat(serieOutputs.size(), is(1));
        assertThat(serieOutputs.get(0), is("2"));
    }
}
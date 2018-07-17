package com.hackerrank;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SerieShould {

    @Test
    public void generate_a_serie_with_a_simple_term() {
        Serie serie = new Serie(0, 2, 1);
        assertThat(serie.generate(), is("2"));
    }

    @Test
    public void generate_a_serie_with_two_terms() {
        Serie serie = new Serie(0, 2, 2);
        assertThat(serie.generate(), is("2 6"));
    }

    @Test
    public void generate_a_complex_serie() {
        Serie serie = new Serie(0, 2, 10);
        assertThat(serie.generate(), is("2 6 14 30 62 126 254 510 1022 2046"));
    }
}
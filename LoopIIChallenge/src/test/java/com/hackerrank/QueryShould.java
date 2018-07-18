package com.hackerrank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class QueryShould {

    @Mock
    private SerieOutputRepository serieOutputRepository;

    @Mock
    private SerieOutputPrinter serieOutputPrinter;

    @Mock
    private Serie serie;

    private List<Serie> series;
    private Query query;

    @Before
    public void initialise() {
        series = asList(serie);
        query = new Query(serieOutputRepository, serieOutputPrinter, series);
    }

    @Test
    public void generate_and_store_serie_output() {
        given(serie.generate()).willReturn("2");

        query.generate();

        verify(serieOutputRepository).add("2");
    }

    @Test
    public void print_serie_output() {
        List<String> serie_outputs = asList("2");
        given(serieOutputRepository.all()).willReturn(serie_outputs);

        query.print();

        verify(serieOutputPrinter).print(serie_outputs);
    }
}
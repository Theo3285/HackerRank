package com.hackerrank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoopChallengeFeature {

    @Mock
    private Console console;

    private SerieOutputRepository serieOutputRepository;
    private SerieOutputPrinter serieOutputPrinter;

    @Before
    public void initialise() {
        serieOutputRepository = new SerieOutputRepository();
        serieOutputPrinter = new SerieOutputPrinter(console);
    }

    @Test
    public void query_series_and_print_output() {
        List<Serie> series = asList(
                new Serie(0, 2, 10),
                new Serie(5, 3, 5));
        Query query = new Query(serieOutputRepository, serieOutputPrinter, series);

        query.generate();

        query.print();

        verify(console).printLine("2 6 14 30 62 126 254 510 1022 2046");
        verify(console).printLine("8 14 26 50 98");
    }
}

package com.hackerrank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SerieOutputPrinterShould {

    @Mock
    private Console console;

    @Test
    public void print_a_serie_output() {
        SerieOutputPrinter serieOutputPrinter = new SerieOutputPrinter(console);
        List<String> serie_outputs = asList("2");

        serieOutputPrinter.print(serie_outputs);

        verify(console).printLine("2");
    }

}
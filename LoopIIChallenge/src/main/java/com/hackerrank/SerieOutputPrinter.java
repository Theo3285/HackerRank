package com.hackerrank;

import java.util.List;

public class SerieOutputPrinter {
    private Console console;

    public SerieOutputPrinter(Console console) {
        this.console = console;
    }

    public void print(List<String> serie_outputs) {
        for (String serie : serie_outputs) {
            console.printLine(serie);
        }
    }
}

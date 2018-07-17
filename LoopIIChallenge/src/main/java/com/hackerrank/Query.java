package com.hackerrank;

import java.util.List;

public class Query {
    private SerieOutputRepository serieOutputRepository;
    private SerieOutputPrinter serieOutputPrinter;
    private List<Serie> series;

    public Query(SerieOutputRepository serieOutputRepository,
                 SerieOutputPrinter serieOutputPrinter,
                 List<Serie> series) {
        this.serieOutputRepository = serieOutputRepository;
        this.serieOutputPrinter = serieOutputPrinter;
        this.series = series;
    }

    public void generate() {
        for (Serie serie : series) {
            serieOutputRepository.add(serie.generate());
        }
    }

    public void print() {
        serieOutputPrinter.print(serieOutputRepository.all());
    }
}

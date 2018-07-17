package com.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private Console console;
    private SerieOutputRepository serieOutputRepository;
    private SerieOutputPrinter serieOutputPrinter;

    public Solution() {
        console = new Console();
        serieOutputRepository = new SerieOutputRepository();
        serieOutputPrinter = new SerieOutputPrinter(console);
    }

    public static void main(String... args) {
        Solution app = new Solution();
        app.run();
    }

    public void run() {
        List<Serie> series = new ArrayList<Serie>();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            series.add(new Serie(a, b, n));
        }
        in.close();

        Query query = new Query(serieOutputRepository, serieOutputPrinter, series);
        query.generate();
        query.print();
    }
}

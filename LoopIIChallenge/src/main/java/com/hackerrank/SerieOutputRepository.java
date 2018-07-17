package com.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class SerieOutputRepository {
    List<String> series = new ArrayList<String>();

    public List<String> all() {
        return series;
    }

    public void add(String serie) {
        series.add(serie);
    }
}

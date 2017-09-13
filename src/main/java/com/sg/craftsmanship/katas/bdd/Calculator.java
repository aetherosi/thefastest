package com.sg.craftsmanship.katas.bdd;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Double> result = new ArrayList<Double>();

    public void add(Double value) {
        result.add(value);
    }

    public double getResult() {
        return result.stream().mapToDouble(f -> f).sum();
    }

    public void substract(Double value) {
        result.add((double) -value);
    }

    public void clear() {
        result.removeAll(result);
    }
}

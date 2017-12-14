package com.irieosi.craftsmanship.katas.thefastest;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {


    private static DateTimeFormatter DISPLAY_FORMAT = DateTimeFormatter.ISO_LOCAL_TIME;

    public static void main(String[] args) {

    }

    public static ArrayList<LocalTime> generateResults() {
        return Stream.of("10:15:46", "03:59:08", "04:00:08", "03:59:09").map(result -> LocalTime.parse(result, DISPLAY_FORMAT)).collect(Collectors.toCollection(ArrayList::new));
    }

    public static LocalTime getSmallestResult(ArrayList<LocalTime> results) {
/*        Collections.sort(results);
        return results.get(0);*/
        return results.stream()
                .min(Comparator.comparingInt(result -> result.toSecondOfDay()))
                .get();
    }
}

package com.irieosi.craftsmanship.katas.thefastest;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {


    private static DateTimeFormatter DISPLAY_FORMAT = DateTimeFormatter.ISO_LOCAL_TIME;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> results = saveResults(in);

        ArrayList<LocalTime> times = parseResults(results);

        LocalTime fastestTime = getSmallestResult(times);

        System.out.println(fastestTime.format(DISPLAY_FORMAT));

    }

    public static ArrayList<LocalTime> parseResults(List<String> results) {
        return results.stream().map(result -> LocalTime.parse(result, DISPLAY_FORMAT)).collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<String> saveResults(Scanner in) {
        ArrayList<String> results = new ArrayList<>();

        int N = Integer.valueOf(in.next());
        for (int i = 0; i < N; i++) {
            String result = in.next();
            results.add(result);
        }
        return results;
    }

    public static LocalTime getSmallestResult(ArrayList<LocalTime> results) {
        return results.stream()
                .min(Comparator.comparingInt(result -> result.toSecondOfDay()))
                .get();
    }
}

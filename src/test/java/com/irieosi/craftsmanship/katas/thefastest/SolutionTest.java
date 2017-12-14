package com.irieosi.craftsmanship.katas.thefastest;


import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {
    private ArrayList<String> results;

    @Before
    public void init() {
        results = Stream.of("10:15:46", "03:59:08", "04:00:08", "03:59:09").collect(Collectors.toCollection(ArrayList::new));
    }

    @Test
    public void should_save_five_results() {
        String input = "5\n"+ "10:15:46\n"+ "03:59:08\n"+ "04:00:08\n"+ "03:59:09\n"+ "01:59:09\n";

        Scanner in = new Scanner(input);

        assertThat(Solution.saveResults(in)).hasSize(5);
    }

    @Test
    public void should_parse_four_results_into_times() {
        assertThat(Solution.parseResults(results)).hasSameClassAs(new ArrayList<LocalTime>());
        assertThat(Solution.parseResults(results)).hasSize(4);
    }


    @Test
    public void should_return_the_smallest_time() {
        ArrayList<LocalTime> times = Solution.parseResults(results);

        assertThat(Solution.getSmallestResult(times)).isEqualTo(LocalTime.of(3, 59, 8));
    }


}
package com.irieosi.craftsmanship.katas.thefastest;


import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;

public class SolutionTest {
    @Test
    public void should_return_four_results() {
        Assertions.assertThat(Solution.generateResults()).hasSize(4);
    }

    @Test
    public void should_return_the_smallest_time() {

        ArrayList<LocalTime> results = Solution.generateResults();

        Assertions.assertThat(Solution.getSmallestResult(results)).isEqualTo(LocalTime.of(3,59,8));
    }


}
package com.sg.craftsmanship.katas.bdd;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SolutionTest {

    private Dictionary dictionary;

    private String letters;

    @Before
    public void init() {
        dictionary = new Dictionary();
        letters = "hicquwh";
    }

    @Test
    public void main() throws Exception {
    }

    @Test
    public void should_genereate_a_list_of_two_words() {
        Assertions.assertThat(Solution.generateWords()).hasSize(2);
    }

    @Test
    public void should_initialize_dictionary_with_a_list_of_two_words() {
        dictionary.setWords(Solution.generateWords());
        Assertions.assertThat(dictionary.getWords()).hasSize(2);
    }

    @Test
    public void should_generate_a_map_of_26_pairs_with_a_letter_as_a_key_and_points_as_a_value() {
        Assertions.assertThat(Solution.generateLetters()).hasSize(26);
    }

    @Test
    public void should_find_all_the_possible_words_according_to_the_letters() {
        dictionary.setWords(Solution.generateWords());


        Assertions.assertThat(Solution.findAllPossibleWords(dictionary, letters)).hasSize(1);
        Assertions.assertThat(Solution.findAllPossibleWords(dictionary, letters).get(0)).isEqualTo("which");
    }

    @Test
    public void should_return_the_highest_valued_word() {
        Map<String, Integer> lettersMap = Solution.generateLetters();
        dictionary.setWords(Solution.generateWords());

        List<String> possibleWords = Solution.findAllPossibleWords(dictionary, letters);

        Assertions.assertThat(Solution.findHighestValuedWord(lettersMap, possibleWords)).isEqualTo("which - 16");

    }

}
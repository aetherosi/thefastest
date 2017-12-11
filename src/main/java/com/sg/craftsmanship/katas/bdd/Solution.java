package com.sg.craftsmanship.katas.bdd;

import javafx.util.Pair;

import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String W = in.nextLine();
        }
        String LETTERS = in.nextLine();
    }

    public static List<String> generateWords() {
        List<String> words = new ArrayList<>();
        words.add("which");
        words.add("quick");

        return words;
    }


    public static Map<String, Integer> generateLetters() {
        Map<String, Integer> letters = new HashMap<>();

        letters.put("e", 1);
        letters.put("a", 1);
        letters.put("i", 1);
        letters.put("o", 1);
        letters.put("n", 1);
        letters.put("r", 1);
        letters.put("t", 1);
        letters.put("l", 1);
        letters.put("s", 1);
        letters.put("u", 1);

        letters.put("d", 2);
        letters.put("g", 2);

        letters.put("b", 3);
        letters.put("c", 3);
        letters.put("m", 3);
        letters.put("p", 3);

        letters.put("f", 4);
        letters.put("h", 4);
        letters.put("v", 4);
        letters.put("w", 4);
        letters.put("y", 4);

        letters.put("k", 5);

        letters.put("j", 8);
        letters.put("x", 8);

        letters.put("q", 8);
        letters.put("z", 10);

        return letters;

    }

    public static List<String> findAllPossibleWords(Dictionary dictionary, String letters) {
        List<String> possibleWords = new ArrayList<>();

        for (String word : dictionary.getWords()) {
            String tab = letters;
            String modWord = word;
            for (char c : tab.toCharArray()) {
                if (! modWord.isEmpty()) {
                    String letter = "" + c;
                    if (modWord.contains(letter)) {
                        modWord = modWord.replaceFirst(letter, "");

                        if (modWord.isEmpty()){
                            possibleWords.add(word);
                        }
                    }
                }
            }
        }

        return possibleWords;
    }

    public static String findHighestValuedWord(Map<String, Integer> lettersMap, List<String> possibleWords) {
        String finalWord = "";
        int total = 0;

        for (String word : possibleWords) {
            int points = 0;
            for (char c : word.toCharArray()) {
                String letter = "" + c;
                points += lettersMap.get(letter);
            }
            if (points > total) {
                finalWord = word;
                total = points;
            }
        }

        return finalWord + " - " + total;
    }
}

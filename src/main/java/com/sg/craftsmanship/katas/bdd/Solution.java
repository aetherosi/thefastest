package com.sg.craftsmanship.katas.bdd;

import java.util.*;

public class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        Dictionary dictionary = new Dictionary();
        Map<String, Integer> lettersMap = generateLetters();

        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            words.add(in.nextLine());
        }

        dictionary.setWords(words);
        String letters = in.nextLine();

        List<String> allPossibleWords = findAllPossibleWords(dictionary, letters);
        System.out.println(findHighestValuedWord(lettersMap, allPossibleWords));

    }

    public static List<String> generateWords() {
        List<String> words = new ArrayList<>();
        words.add("which");
        words.add("quick");

        return words;
    }


    public static Map<String, Integer> generateLetters() {
        Map<String, Integer> lettersMap = new HashMap<>();

        lettersMap.put("e", 1);
        lettersMap.put("a", 1);
        lettersMap.put("i", 1);
        lettersMap.put("o", 1);
        lettersMap.put("n", 1);
        lettersMap.put("r", 1);
        lettersMap.put("t", 1);
        lettersMap.put("l", 1);
        lettersMap.put("s", 1);
        lettersMap.put("u", 1);

        lettersMap.put("d", 2);
        lettersMap.put("g", 2);

        lettersMap.put("b", 3);
        lettersMap.put("c", 3);
        lettersMap.put("m", 3);
        lettersMap.put("p", 3);

        lettersMap.put("f", 4);
        lettersMap.put("h", 4);
        lettersMap.put("v", 4);
        lettersMap.put("w", 4);
        lettersMap.put("y", 4);

        lettersMap.put("k", 5);

        lettersMap.put("j", 8);
        lettersMap.put("x", 8);

        lettersMap.put("q", 8);
        lettersMap.put("z", 10);

        return lettersMap;

    }

    public static List<String> findAllPossibleWords(Dictionary dictionary, String letters) {
        List<String> possibleWords = new ArrayList<>();

        for (String word : dictionary.getWords()) {
            String wordToPlay = word;
            for (char c : letters.toCharArray()) {
                if (!wordToPlay.isEmpty()) {
                    String letter = "" + c;
                    if (wordToPlay.contains(letter)) {
                        wordToPlay = wordToPlay.replaceFirst(letter, "");

                        if (wordToPlay.isEmpty()) {
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

        return finalWord;
    }

    public static class Dictionary {
        private List<String> words;

        public void setWords(List<String> words) {
            this.words = words;
        }

        public List<String> getWords() {
            return words;
        }
    }
}

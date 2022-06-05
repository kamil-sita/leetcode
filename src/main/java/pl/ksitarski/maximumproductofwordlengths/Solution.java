package pl.ksitarski.maximumproductofwordlengths;

import java.util.*;

class Solution {

    public int maxProduct(String[] words) {
        int maxLength = 0;

        int[] wordsUniqueLetters = toUniqueLetters(words);

        for (int i = 0; i < words.length; i++) {

            for (int j = i + 1; j < words.length; j++) {

                if ((wordsUniqueLetters[i] & wordsUniqueLetters[j]) == 0) {
                    int length = words[i].length() * words[j].length();
                    maxLength = Math.max(length, maxLength);
                }

            }

        }

        return maxLength;
    }

    private int[] toUniqueLetters(String[] words) {
        int[] uniqueLetters = new int[words.length];


        for (int i = 0; i < words.length; i++) {
            int l = 0;
            String word = words[i];

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                l |= (1 << (c - 'a'));
            }
            uniqueLetters[i] = l;
        }

        return uniqueLetters;
    }
}
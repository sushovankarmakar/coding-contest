package biweekly66;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/contest/biweekly-contest-66
 * https://leetcode.com/problems/count-common-words-with-one-occurrence/
 */

public class _2085_CountCommonWordsWithOneOccurrence {

  public int countWords(String[] words1, String[] words2) {

    Map<String, Integer> wordFreq1 = new HashMap<>();
    Map<String, Integer> wordFreq2 = new HashMap<>();

    for (String word : words1) {
      wordFreq1.put(word, wordFreq1.getOrDefault(word, 0) + 1);
    }

    for (String word : words2) {
      wordFreq2.put(word, wordFreq2.getOrDefault(word, 0) + 1);
    }

    int count = 0;

    for (String word : words1) {

      if (wordFreq1.containsKey(word) && wordFreq2.containsKey(word)) {
        if (wordFreq1.get(word) == 1 && wordFreq2.get(word) == 1) {
          count++;
        }
      }
    }

    return count;
  }

}

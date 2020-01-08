package ch10;

import java.util.*;

public class Qns10_2 {
  // O(nc + 26n) = O(nc), where c is num of characters and n is num of words
  public static List<List<String>> groupAnagrams(String[] strs) {
    String[] wordHash = new String[strs.length];
    for (int i = 0; i < strs.length; i++) { // O(n)
      wordHash[i] = hashWord(strs[i]); // O(c + 26)
    }
    HashMap<String,List<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      List<String> words = map.getOrDefault(wordHash[i], new ArrayList<String>());
      words.add(strs[i]);
      map.put(wordHash[i], words);
    }
    List<List<String>> out = new ArrayList<>();
    for (String k : map.keySet()) {
      out.add(map.get(k));
    }
    return out;
  }
  //        abcd        z
  // aaa => 300000000...0(26)
  //                ab....     z
  // aab aba baa => 21000000...0(26)
  // O (c + 26)
  private static String hashWord(String word) {
    int[] counts = new int[26];
    for (char c : word.toCharArray()) { // O(c)
      counts[(int)c-97]++;
    }
    StringBuilder sb = new StringBuilder();
    for (int i : counts) { // O(26)
      sb.append(Integer.toString(i));
    }
    return sb.toString();
  }
  public static void tests() {
    String[] words1 = {"aaa"};
    printHelper(words1, groupAnagrams(words1));

    String[] words2 = {"aba", "baa", "aab", "aac", "caa"};
    printHelper(words2, groupAnagrams(words2));

    String[] words3 = {"aba", "baa", "aab", "aac", "caa", "ill", "duh"};
    printHelper(words3, groupAnagrams(words3));
  }

  private static void printHelper(String[] words, List<List<String>> output) {
    StringJoiner wordJoiner = new StringJoiner(",", "[", "]");
    for (String w : words) {
      wordJoiner.add(w);
    }

    StringJoiner outJoiner = new StringJoiner(",", "[", "]");

    for (List<String> o : output) {
      StringJoiner inJoiner = new StringJoiner(",", "[", "]");
      for (String s : o) {
        inJoiner.add(s);
      }
      outJoiner.add(inJoiner.toString());
    }

    System.out.printf("%s: %s\n", wordJoiner.toString(),outJoiner.toString());
  }
}

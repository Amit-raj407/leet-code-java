package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    List<List<String>> groups(List<String> words) {
        HashMap<String, List<String>> groups = new HashMap<>();

        for(String word: words) {
            char[] charSet = word.toCharArray();
            Arrays.sort(charSet);
            String key = new String(charSet);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(groups.values());

    }
}

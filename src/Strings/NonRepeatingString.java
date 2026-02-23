package Strings;

import java.util.HashMap;

public class NonRepeatingString { 
   
    void checkNonRepeatingString(String s) {
        HashMap<Character, Integer> strMap = new HashMap<>();
        for(char ch: s.toCharArray()) {
            strMap.put(ch, strMap.getOrDefault(ch, 0) + 1);
        }

        char result = '#';

        for(char ch: s.toCharArray()) {
            if(strMap.get(ch) == 1) {
                result = ch;
                break;
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        String s = new String("AAmmiitt");

        NonRepeatingString nrs = new NonRepeatingString();

        nrs.checkNonRepeatingString(s);
    }
}

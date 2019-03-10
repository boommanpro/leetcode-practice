package hashTable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Leetcode290Test {


    @Test
    public void leetcode290Test(){
        
        //    Example 1:
        //    
        //    Input: pattern = "abba", str = "dog cat cat dog"
        //    Output: true
        //    Example 2:
        //    
        //    Input:pattern = "abba", str = "dog cat cat fish"
        //    Output: false
        //    Example 3:
        //    
        //    Input: pattern = "aaaa", str = "dog cat cat dog"
        //    Output: false
        //    Example 4:
        //    
        //    Input: pattern = "abba", str = "dog dog dog dog"
        //    Output: false

        //  dog cat cat fish
        //  abba


        boolean b = wordPattern("abba", "dog cat cat fish");
        System.out.println(String.format("result:%s", b));
    }


    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] wordArray = str.split(" ");
        if (chars.length != wordArray.length) {
            return false;
        }
        Map<String, Character> dictMap = new HashMap<>();
        Map<Character, String> characterStringMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Character character = dictMap.get(wordArray[i]);
            String word = characterStringMap.get(chars[i]);
            if (character != null&& character !=chars[i]) {
                return false;
            }
            if (word != null && !word.equals(wordArray[i]) ) {
                return false;
            }
            dictMap.put(wordArray[i], chars[i]);
            characterStringMap.put(chars[i], wordArray[i]);
        }
        return true;
    }
}

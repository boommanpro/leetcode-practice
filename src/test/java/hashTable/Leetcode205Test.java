package hashTable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode205Test {

    @Test
    public void leetcode205Test(){
        //isomorphic 同构

        //    Example 1:
        //
        //    Input: s = "egg", t = "add"
        //    Output: true
        //    Example 2:
        //
        //    Input: s = "foo", t = "bar"
        //    Output: false
        //    Example 3:
        //
        //    Input: s = "paper", t = "title"
        //    Output: true


        boolean isomorphic = isIsomorphic("ab", "aa");
        System.out.println(String.format("result:%s",isomorphic));
    }


    public boolean isIsomorphic(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if (sChars.length != tChars.length) {
            return false;
        }

        Map<Character, Character> sDict = new HashMap<>();
        Map<Character, Character> tDict = new HashMap<>();
        for (int i = 0; i < sChars.length; i++) {
            if (sDict.containsKey(s.charAt(i))||tDict.containsKey(t.charAt(i))) {
                if (!sDict.containsKey(s.charAt(i))) {
                    return false;
                }
                if (!tDict.containsKey(t.charAt(i))) {
                    return false;
                }
                if (sDict.get(s.charAt(i)) != t.charAt(i) || tDict.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            }else {
                sDict.put(s.charAt(i), t.charAt(i));
                tDict.put(t.charAt(i), s.charAt(i));
            }

        }
        return true;
    }




}

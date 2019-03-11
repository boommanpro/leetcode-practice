package hashTable;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode242Test {
    @Test
    public void leetcode242Test() {

        // Anagram  变位词

        //    Example 1:
        //
        //    Input: s = "anagram", t = "nagaram"
        //    Output: true
        //    Example 2:
        //
        //    Input: s = "rat", t = "car"
        //    Output: false

        boolean anagram = isAnagram("rat", "car");

        System.out.println(String.format("result:%s",anagram));
    }


    public boolean isAnagram(String s, String t) {

        //1.长度相等

        if (s.length() != t.length()) {
            return false;
        }
        int[] sArray = new int[26];
        int[] tArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
            tArray[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }
        return true;

    }

    //优化
    public boolean isAnagram2(String s, String t) {

        //1.长度相等

        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (table[i]!=0) {
                return false;
            }
        }
        return true;

    }

}

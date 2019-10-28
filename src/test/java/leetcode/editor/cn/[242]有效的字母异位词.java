package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
class SolutionTest242 {
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表
    public static
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean isAnagram(String s, String t) {
        //两个都为null 相等
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        //长度不等 false
        if (s.length() != t.length()) {
            return false;
        }
        //s==t true
        if (s.equals(t)) {
            return true;
        }
        //异位词 只是位置不同的单词
        Map<Character, Integer> dictS = new HashMap<>();
        Map<Character, Integer> dictT = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            dictS.put(s.charAt(i), dictS.getOrDefault(s.charAt(i), 0) + 1);
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : dictS.entrySet()) {
            if (!entry.getValue().equals(dictT.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isAnagram("anagram", "nagaram"));
            Assert.assertFalse(solution.isAnagram("rat", "car"));
        }
    }
}
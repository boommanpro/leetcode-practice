package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题01_04 {
//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 
//
// 回文串不一定是字典当中的单词。 
//
// 
//
// 示例1： 
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
// 
//
// 
// Related Topics 哈希表 字符串

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canPermutePalindrome(String s) {
            Map<Character, Integer> dict = new HashMap<>();
            for (char c : s.toCharArray()) {
                dict.put(c, dict.getOrDefault(c, 0) + 1);
            }
            boolean odd = false;
            for (Integer value : dict.values()) {
                if (value % 2 == 1) {
                    if (odd) {
                        return false;
                    }
                    odd = true;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.canPermutePalindrome("tactcoa"));
        }
    }
}
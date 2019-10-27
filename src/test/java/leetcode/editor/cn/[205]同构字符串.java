package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest205 {
//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表
    public static
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> dict = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!dict.containsKey(s.charAt(i))) {
                if (dict.containsValue(t.charAt(i))) {
                    return false;
                }
                dict.put(s.charAt(i), t.charAt(i));
            } else if (!dict.get(s.charAt(i)).equals(t.charAt(i))) {
                return false;
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
            Assert.assertTrue(solution.isIsomorphic("egg","add"));
            Assert.assertFalse(solution.isIsomorphic("foo","bar"));
            Assert.assertTrue(solution.isIsomorphic("paper","title"));
            Assert.assertFalse(solution.isIsomorphic("ab","aa"));
        }
    }
}
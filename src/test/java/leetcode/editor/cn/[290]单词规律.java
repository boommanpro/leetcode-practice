package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
class SolutionTest290 {
//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表
    public static
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }
        Map<Character, String> patternDict = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (patternDict.containsKey(pattern.charAt(i))) {
                if (!split[i].equals(patternDict.get(pattern.charAt(i)))) {
                    return false;
                }
            }else{
                if (patternDict.containsValue(split[i])) {
                    return false;
                }
                patternDict.put(pattern.charAt(i), split[i]);
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
            Assert.assertTrue(solution.wordPattern("abba","dog cat cat dog"));
            Assert.assertFalse(solution.wordPattern("abba","dog cat cat fish"));
            Assert.assertFalse(solution.wordPattern("aaaa","dog cat cat dog"));
            Assert.assertFalse(solution.wordPattern("abba","dog dog dog dog"));
        }
    }
}
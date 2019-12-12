package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;
class SolutionTest557 {
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 示例 1: 
//
// 
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
// 
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// Related Topics 字符串
    public static
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(reverse(s.substring(start, i))).append(' ');
                start = i+1;
            }
        }

            sb.append(reverse(s.substring(start)));

        return sb.toString();
    }

    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("s'teL ekat edoCteeL tsetnoc", solution.reverseWords("Let's take LeetCode contest"));
            Assert.assertEquals("", solution.reverseWords(""));
            Assert.assertEquals(" ", solution.reverseWords(" "));

        }
    }
}
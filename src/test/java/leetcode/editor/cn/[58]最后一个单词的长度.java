package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest58 {
//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 215 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLastWord(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            int r = s.length() - 1;
            while (r >= 0 && s.charAt(r) == ' ') {
                r--;
            }
            if (r == -1) {
                return 0;
            }
            int count = 0;
            for (int i = r; i >= 0; i--) {
                if (s.charAt(i) == ' ') {
                    return count;
                }
                count++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(0, solution.lengthOfLastWord(""));
            Assert.assertEquals(1, solution.lengthOfLastWord("a"));
            Assert.assertEquals(0, solution.lengthOfLastWord("       "));
            Assert.assertEquals(2, solution.lengthOfLastWord("da       "));
            Assert.assertEquals(5, solution.lengthOfLastWord("Hello World"));
            Assert.assertEquals(1, solution.lengthOfLastWord("Hello s s Worldabcs s"));
            Assert.assertEquals(1, solution.lengthOfLastWord("Hello s s Worldabcs s   "));
        }
    }
}
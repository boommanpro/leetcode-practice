package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest面试题17_11 {
//有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词
//不同，你能对此优化吗? 
//
// 示例： 
//
// 
//输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
// Related Topics 数组 字符串 👍 37 👎 0

    public static
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        Integer p1 = null;
        Integer p2 = null;
        int n = words.length + 1;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                p1 = i;
            } else if (word2.equals(words[i])) {
                p2 = i;
            }
            if (p1 != null && p2 != null) {
                n = Math.min(n, Math.abs(p2 - p1));
            }
        }
        return n == words.length + 1 ? -1 : n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student"));
        }
        
    }
}
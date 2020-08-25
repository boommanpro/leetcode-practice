package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest17 {
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 844 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        char[][] numberPath = new char[][]{
                //0
                {},
                //1
                {},
                //2
                {'a', 'b', 'c'},
                //3
                {'d', 'e', 'f'},
                //4
                {'g', 'h', 'i'},
                //5
                {'j', 'k', 'l'},
                //6
                {'m', 'n', 'o'},
                //7
                {'p', 'q', 'r', 's'},
                //8
                {'t', 'u', 'v'},
                //9
                {'w', 'x', 'y', 'z'}

        };

        List<String> result;

        public List<String> letterCombinations(String digits) {
            result = new ArrayList<>();
            if (digits == null || digits.isEmpty()) {
                return result;
            }
            int n = digits.length();
            char[] path = new char[n];
            dfs(digits.toCharArray(), path, 0, n);
            return result;
        }

        private void dfs(char[] digitsArray, char[] path, int start, int n) {
            if (start == n) {
                result.add(new String(path));
                return;
            }
            int number = digitsArray[start] - '0';
            char[] selectPath = numberPath[number];
            for (char curr : selectPath) {
                path[start] = curr;
                dfs(digitsArray, path, start + 1, n);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[ad, ae, af, bd, be, bf, cd, ce, cf]", solution.letterCombinations("23").toString());
            Assert.assertEquals("[]", solution.letterCombinations("").toString());
        }
    }
}
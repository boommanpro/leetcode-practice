package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest784 {
//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 回溯算法 
// 👍 199 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result;

        public List<String> letterCasePermutation(String S) {
            result = new ArrayList<>();
            if (S == null || S.isEmpty()) {
                return result;
            }
            dfs(S, new StringBuilder(), 0, S.length());
            return result;
        }

        private void dfs(String str, StringBuilder path, int start, int len) {
            if (start == len) {
                result.add(path.toString());
                return;
            }
            char curr = str.charAt(start);
            if (Character.isDigit(curr)) {
                path.append(curr);
                dfs(str, path, start + 1, len);
            } else {
                StringBuilder low = new StringBuilder(path);
                low.append(Character.toLowerCase(curr));
                dfs(str, low, start + 1, len);
                StringBuilder upp = new StringBuilder(path);
                upp.append(Character.toUpperCase(curr));
                dfs(str, upp, start + 1, len);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[12345]", solution.letterCasePermutation("12345").toString());
            Assert.assertEquals("[a1b2, a1B2, A1b2, A1B2]", solution.letterCasePermutation("a1b2").toString());
        }
    }
}
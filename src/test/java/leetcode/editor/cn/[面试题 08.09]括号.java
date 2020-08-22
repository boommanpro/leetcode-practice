package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest面试题_08_09 {
//括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。 
//
// 说明：解集不能包含重复的子集。 
//
// 例如，给出 n = 3，生成结果为： 
//
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法 
// 👍 30 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> result;

        public List<String> generateParenthesis(int n) {
            result = new ArrayList<>();
            dfs(0, 0, n, "");
            return result;
        }

        private void dfs(int l, int r, int n, String path) {
            if (l == n && r == n) {
                result.add(path);
                return;
            }
            if (l + 1 <= n) {
                dfs(l + 1, r, n, path + "(");
            }
            if (r + 1 <= l) {
                dfs(l, r + 1, n, path + ")");
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[((())), (()()), (())(), ()(()), ()()()]", solution.generateParenthesis(3).toString());
        }
    }
}
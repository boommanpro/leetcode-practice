package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionTest301 {
//删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
//
// 说明: 输入可能包含了除 ( 和 ) 以外的字符。
//
// 示例 1:
//
// 输入: "()())()"
//输出: ["()()()", "(())()"]
//
//
// 示例 2:
//
// 输入: "(a)())()"
//输出: ["(a)()()", "(a())()"]
//
//
// 示例 3:
//
// 输入: ")("
//输出: [""]
// Related Topics 深度优先搜索 广度优先搜索
// 👍 363 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> removeInvalidParentheses(String s) {
            int l = 0;
            int r = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    l++;
                } else if (c == ')') {
                    if (l > 0) {
                        l--;
                    } else {
                        r++;
                    }
                }
            }
            Set<String> set = new HashSet<>();
            dfs(s, "", 0, set, 0, l, r);
            return new ArrayList<>(set);
        }

        private void dfs(String s, String path, int p, Set<String> set, int cnt, int l, int r) {
            if (cnt < 0) {
                return;
            }
            if (p == s.length()) {
                if (cnt == 0) {
                    set.add(path);
                }
            }
            char c = s.charAt(p);
            switch (c) {
                case '(':
                    if (l > 0) {
                        dfs(s, path, p + 1, set, cnt, l - 1, r);
                    }
                    dfs(s, path + c, p + 1, set, cnt + 1, l, r);
                    break;
                case ')':
                    if (r > 0) {
                        dfs(s, path, p + 1, set, cnt, l, r - 1);
                    }
                    dfs(s, path + c, p + 1, set, cnt - 1, l, r);
                    break;
                default:
                    dfs(s, path + c, p + 1, set, cnt, l, r);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[()()(), (())()]", solution.removeInvalidParentheses("()())()").toString());
            Assert.assertEquals("[(a)()(), (a())()]", solution.removeInvalidParentheses("(a)())()").toString());
            Assert.assertEquals("[]", solution.removeInvalidParentheses(")(").toString());
        }
    }
}
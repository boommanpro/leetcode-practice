package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        HashSet<String> set;

        public List<String> removeInvalidParentheses(String s) {
            set = new HashSet<>();

            int r = 0, l = 0;
            // 统计该删除的左右括号的数量
            for (char c : s.toCharArray()) {
                if (c == '(') l++;
                else if (c == ')') {
                    if (l == 0) r++;
                    else {
                        l--;
                    }
                }
            }
            dfs(s, 0, "", 0, l, r);
            return new ArrayList<>(set);
        }

        // s: 就是这个需要遍历的原始字符串
        // u：遍历字符串的时候需要使用的索引
        // path：一种结果
        // cnt：统计左右括号的和
        // l：需要删除的左括号的数量
        // r：需要删除的右括号的数量
        public void dfs(String s, int u, String path, int cnt, int l, int r) {
            // 如果括号和小于零，那就是一个非法序列
            if (cnt < 0) return;
            if (s.length() == u) {
                // 遍历到了最后 如果括号和为0，说明是个合法序列
                if (cnt == 0) {
                    set.add(path);
                }
                return;
            }

            // 如果不是括号，就直接添加到当前序列后面
            if (s.charAt(u) != '(' && s.charAt(u) != ')') {
                dfs(s, u + 1, path + s.charAt(u), cnt, l, r);
            } else {
                if (s.charAt(u) == '(') {
                    // 如果有需要删除的左括号，那就忽略这个括号，同时需要删除的左括号数量减一
                    if (l > 0) {
                        dfs(s, u + 1, path, cnt, l - 1, r);
                    }
                    // 先不删这个左括号，括号和加一
                    dfs(s, u + 1, path + '(', cnt + 1, l, r);
                } else {
                    // 同上
                    if (r > 0) {
                        dfs(s, u + 1, path, cnt, l, r - 1);
                    }
                    dfs(s, u + 1, path + ')', cnt - 1, l, r);
                }
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
//            Assert.assertEquals("[(a)()(), (a())()]", solution.removeInvalidParentheses("(a)())()").toString());
//            Assert.assertEquals("[]", solution.removeInvalidParentheses(")(").toString());
        }
    }
}
package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest22 {
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> generateParenthesis0(int n) {
            List<String> ans = new ArrayList<>();
            char[] current = new char[2 * n];
            generatorAll(ans, current, 0);
            return ans;
        }

        private void generatorAll(List<String> ans, char[] current, int start) {
            if (start == current.length) {
                if (isValid(current)) {
                    ans.add(new String(current));
                }
                return;
            }
            current[start] = '(';
            generatorAll(ans, current, start + 1);
            current[start] = ')';
            generatorAll(ans, current, start + 1);
        }

        private boolean isValid(char[] current) {
            int balance = 0;
            for (char c : current) {
                if (c == '(') {
                    balance++;
                }else {
                    balance--;
                }
                if (balance < 0) {
                    return false;
                }
            }
            return balance == 0;
        }

        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            char[] current = new char[2 * n];
            backTracking(ans, current, 0, 0, 0, n);
            return ans;
        }

        private void backTracking(List<String> ans, char[] current, int curr, int open, int close, int max) {
            if (curr == 2 * max) {
                ans.add(new String(current));
                return;
            }
            if (open < max) {
                current[curr] = '(';
                backTracking(ans, current, curr + 1, open + 1, close, max);
            }
            if (close < open) {
                current[curr] = ')';
                backTracking(ans, current, curr + 1, open, close + 1, max);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            System.out.println(solution.generateParenthesis0(1));
            System.out.println(solution.generateParenthesis0(2));
            System.out.println(solution.generateParenthesis0(3));
            System.out.println(solution.generateParenthesis0(4));
        }
    }
}
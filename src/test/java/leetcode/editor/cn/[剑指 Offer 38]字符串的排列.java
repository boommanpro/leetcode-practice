package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionTest剑指Offer_38 {
//输入一个字符串，打印出该字符串中字符的所有排列。
//
//
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
//
//
// 示例:
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
//
//
//
//
// 限制：
//
// 1 <= s 的长度 <= 8
// Related Topics 回溯算法
// 👍 88 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int count;

        List<String> result;

        public String[] permutation(String s) {
            if (s == null || s.isEmpty()) {
                return new String[0];
            }
            count = 0;
            int n = s.length();
            result = new ArrayList<>();

            char[] selectPath = s.toCharArray();
            Arrays.sort(selectPath);
            char[] path = s.toCharArray();

            dfs(selectPath, path, 0, n);
            return result.toArray(new String[]{});
        }

        private void dfs(char[] selectPath, char[] path, int start, int n) {
            if (start == n) {
                result.add(new String(path));
                return;
            }
            Set<Character> visited = new HashSet<>();
            for (int i = start; i < n; i++) {
                if (visited.contains(selectPath[i])) {
                    continue;
                }
                visited.add(selectPath[i]);
                path[start] = selectPath[i];
                swap(selectPath, start, i);
                dfs(selectPath, path, start + 1, n);
                swap(selectPath, start, i);
            }
        }

        private void swap(char[] selectPath, int start, int i) {
            char temp = selectPath[start];
            selectPath[start] = selectPath[i];
            selectPath[i] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[abc, acb, bac, bca, cba, cab]", Arrays.toString(solution.permutation("abc")));
            Assert.assertEquals("[aab, aba, baa]", Arrays.toString(solution.permutation("aab")));
        }
    }
}
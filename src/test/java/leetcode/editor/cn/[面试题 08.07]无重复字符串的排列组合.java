package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionTest面试题_08_07 {
//无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。 
//
// 示例1: 
//
// 
// 输入：S = "qwe"
// 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
// 
//
// 示例2: 
//
// 
// 输入：S = "ab"
// 输出：["ab", "ba"]
// 
//
// 提示: 
//
// 
// 字符都是英文字母。 
// 字符串长度在[1, 9]之间。 
// 
// Related Topics 回溯算法 
// 👍 22 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result;

        public String[] permutation(String S) {
            if (S == null || S.isEmpty()) {
                return new String[]{};
            }
            int n = S.length();
            result = new ArrayList<>();
            char[] selectPath = S.toCharArray();
            dfs(selectPath, new StringBuilder(), 0, n);
            return result.toArray(new String[]{});
        }

        private void dfs(char[] selectPath, StringBuilder path, int start, int n) {
            if (start == n) {
                result.add(path.toString());
                return;
            }
            for (int i = start; i < n; i++) {
                char curr = selectPath[i];
                path.append(curr);
                swap(selectPath, i, start);
                dfs(selectPath, path, start + 1, n);
                swap(selectPath, i, start);
                int r = path.length();
                int l = r - 1;
                path.delete(l, r);
            }
        }

        private void swap(char[] selectPath, int i, int start) {
            char temp = selectPath[i];
            selectPath[i] = selectPath[start];
            selectPath[start] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[qwe, qew, wqe, weq, ewq, eqw]", Arrays.toString(solution.permutation("qwe")));
            Assert.assertEquals("[ab, ba]", Arrays.toString(solution.permutation("ab")));

        }
    }
}
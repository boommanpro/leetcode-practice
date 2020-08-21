package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionTest面试题_08_08 {
//有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。 
//
// 示例1: 
//
//  输入：S = "qqe"
// 输出：["eqq","qeq","qqe"]
// 
//
// 示例2: 
//
//  输入：S = "ab"
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
            result = new ArrayList<>();
            if (S == null || S.isEmpty()) {
                return new String[]{};
            }
            char[] selectPath = S.toCharArray();
            int n = selectPath.length;
            Arrays.sort(selectPath);
            dfs(selectPath, new StringBuilder(), 0, n);
            return result.toArray(new String[]{});
        }

        private void dfs(char[] selectPath, StringBuilder path, int start, int n) {
            if (start == n) {
                result.add(path.toString());
                return;
            }
            Set<Character> visited = new HashSet<>();
            for (int i = start; i < n; i++) {
                char curr = selectPath[i];
                if (visited.contains(curr)) {
                    continue;
                }
                visited.add(curr);
                path.append(curr);
                swap(selectPath, start, i);
                dfs(selectPath, path, start + 1, n);
                swap(selectPath, start, i);
                int len = path.length();
                path.delete(len - 1, len);

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
            Assert.assertEquals("[eqq, qeq, qqe]", Arrays.toString(solution.permutation("qqe")));
            Assert.assertEquals("[ab, ba]", Arrays.toString(solution.permutation("ab")));
        }
    }
}
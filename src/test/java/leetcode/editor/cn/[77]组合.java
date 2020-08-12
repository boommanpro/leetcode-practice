package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest77 {
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 327 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<Integer> selectPath = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                selectPath.add(i);
            }
            List<List<Integer>> result = new ArrayList<>();
            backtracking(selectPath, new ArrayList<>(), k, result, 0);
            return result;
        }

        private void backtracking(List<Integer> selectPath, List<Integer> path, int k, List<List<Integer>> result, int start) {
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
                return;
            }
            int n = selectPath.size();
            for (int i = start; i < n; i++) {
                path.add(selectPath.get(i));
                backtracking(selectPath, path, k, result, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]", solution.combine(4, 2).toString());
        }
    }
}
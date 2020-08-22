package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


class SolutionTest216 {
//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 151 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result;

        public List<List<Integer>> combinationSum3(int k, int n) {
            result = new ArrayList<>();
            if (n < 0 || k <= 0) {
                return result;
            }
            int[] selectPath = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
            //k个数的和为n
            dfs(selectPath, new ArrayList<>(), 0, 0, k, n);
            //不允许重复数字
            return result;
        }

        private void dfs(int[] selectPath, List<Integer> path, int p, int sum, int k, int n) {
            if (sum > n) {
                return;
            }
            if (path.size() == k) {
                if (sum == n) {
                    result.add(new ArrayList<>(path));
                }
                return;
            }
            for (int i = p; i < 9; i++) {
                int value = selectPath[i];
                swap(selectPath, p, i);
                path.add(value);
                dfs(selectPath, path, i + 1, sum + value, k, n);
                swap(selectPath, p, i);
                path.remove(path.size() - 1);
            }
        }

        private void swap(int[] selectPath, int p, int i) {
            int temp = selectPath[p];
            selectPath[p] = selectPath[i];
            selectPath[i] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[1, 2, 4]]", solution.combinationSum3(3, 7).toString());
            Assert.assertEquals("[[1, 2, 6], [1, 3, 5], [2, 3, 4]]", solution.combinationSum3(3, 9).toString());
            Assert.assertEquals("[]", solution.combinationSum3(2, 18).toString());
        }
    }
}
package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionTest40 {
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 327 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, target, new ArrayList<>(), result, 0);
            return result;
        }

        private void dfs(int[] selectPath, int target, List<Integer> path, List<List<Integer>> result, int start) {
            if (target == 0) {
                result.add(new ArrayList<>(path));
                return;
            }
            int n = selectPath.length;
            for (int i = start; i < n; i++) {
                // 大剪枝
                if (selectPath[i] > target) {
                    continue;
                }
                // 小剪枝
                if (i > start && selectPath[i] == selectPath[i - 1]) {
                    continue;
                }
                path.add(selectPath[i]);
                dfs(selectPath, target - selectPath[i], path, result, i + 1);
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
            Assert.assertEquals("[[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]", solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8).toString());
            Assert.assertEquals("[[1, 2, 2], [5]]", solution.combinationSum2(new int[]{2, 5, 2, 1,}, 5).toString());
        }
    }
}
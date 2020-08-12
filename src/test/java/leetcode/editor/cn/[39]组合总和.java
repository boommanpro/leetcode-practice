package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest39 {
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 804 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            dfs(candidates, target, new ArrayList<>(), result, 0);
            return result;
        }

        private void dfs(int[] selectPath, int target, List<Integer> path, List<List<Integer>> result, int start) {
            if (target == 0) {
                //因为java是引用传递
                result.add(new ArrayList<>(path));
                return;
            }

            int n = selectPath.length;
            //为了去重 必须使用start  详情可以自己画树形结构
            for (int i = start; i < n; i++) {
                if (selectPath[i] > target) {
                    continue;
                }
                path.add(selectPath[i]);
                dfs(selectPath, target - selectPath[i], path, result, i);
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
            Assert.assertEquals("[[2, 2, 3], [7]]",solution.combinationSum(new int[]{2,3,6,7},7).toString());
            Assert.assertEquals("[[2, 2, 2, 2], [2, 3, 3], [3, 5]]",solution.combinationSum(new int[]{2,3,5},8).toString());
        }
    }
}
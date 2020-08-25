package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionTest491 {
//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。 
//
// 示例: 
//
// 
//输入: [4, 6, 7, 7]
//输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7
//]] 
//
// 说明: 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索 
// 👍 119 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> result;
        //这里递增是>=的情况就算

        public List<List<Integer>> findSubsequences(int[] nums) {
            result = new ArrayList<>();
            dfs(nums, 0, new ArrayList<>(), Integer.MIN_VALUE);
            return result;
        }

        private void dfs(int[] selectPath, int start, List<Integer> path, int pre) {
            if (path.size() >= 2) {
                result.add(new ArrayList<>(path));
            }
            Set<Integer> visited = new HashSet<>();
            for (int i = start; i < selectPath.length; i++) {
                int curr = selectPath[i];
                if ((path.size() == 0 || curr >= pre) && !visited.contains(curr)) {
                    visited.add(curr);
                    path.add(curr);
                    dfs(selectPath, i + 1, path, curr);
                    path.remove(path.size() - 1);
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
            Assert.assertEquals("", solution.findSubsequences(new int[]{4, 6, 7, 7}).toString());
        }
    }
}
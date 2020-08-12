package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class SolutionTest47 {
//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 371 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            backtracking(nums, new ArrayList<>(), result, 0);
            return result;
        }

        private void backtracking(int[] nums, List<Integer> path, List<List<Integer>> result, int start) {
            int n = nums.length;
            if (start == n) {
                result.add(new ArrayList<>(path));
                return;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = start; i < n; i++) {
                // 与无重复数字全排列的唯一不同之处
                if (set.contains(nums[i])) {
                    continue;
                }
                set.add(nums[i]);
                path.add(nums[i]);
                swap(nums, path.size() - 1, i);
                backtracking(nums, path, result, start + 1);
                path.remove(path.size() - 1);
                swap(nums, path.size(), i);
            }

        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[1, 1, 2], [1, 2, 1], [2, 1, 1]]", solution.permuteUnique(new int[]{1, 1, 2}).toString());
            Assert.assertEquals("[[0, 0, 0, 1, 9], [0, 0, 0, 9, 1], [0, 0, 1, 0, 9], [0, 0, 1, 9, 0], [0, 0, 9, 1, 0], [0, 0, 9, 0, 1], [0, 1, 0, 0, 9], [0, 1, 0, 9, 0], [0, 1, 9, 0, 0], [0, 9, 0, 1, 0], [0, 9, 0, 0, 1], [0, 9, 1, 0, 0], [1, 0, 0, 0, 9], [1, 0, 0, 9, 0], [1, 0, 9, 0, 0], [1, 9, 0, 0, 0], [9, 0, 0, 1, 0], [9, 0, 0, 0, 1], [9, 0, 1, 0, 0], [9, 1, 0, 0, 0]]\n", solution.permuteUnique(new int[]{0, 1, 0, 0, 9}).toString());
        }
    }
}
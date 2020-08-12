package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest46 {
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 831 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backtracking(nums, new ArrayList<>(), result, 0);
            return result;
        }

        private void backtracking(int[] selectPath, List<Integer> path, List<List<Integer>> result, int start) {
            int n = selectPath.length;
            if (start == n) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i < n; i++) {
                path.add(selectPath[i]);
                //分割成两部分 已经选择和待选择部分    核心是全排列的总共有 N!个
                swap(selectPath, path.size() - 1, i);
                backtracking(selectPath, path, result, start + 1);
                path.remove(path.size() - 1);
                swap(selectPath, path.size(), i);
            }


        }


        private void swap(int[] selectPath, int i, int j) {
            int temp = selectPath[i];
            selectPath[i] = selectPath[j];
            selectPath[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]", solution.permute(new int[]{1, 2, 3}).toString());
        }
    }
}
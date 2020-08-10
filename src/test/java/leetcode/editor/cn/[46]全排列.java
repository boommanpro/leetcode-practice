package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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

        public void backtrack(int n,
                              ArrayList<Integer> output,
                              List<List<Integer>> res,
                              int first) {
            // 所有数都填完了
            if (first == n)
                res.add(new ArrayList<>(output));
            for (int i = first; i < n; i++) {
                // 动态维护数组
                Collections.swap(output, first, i);
                // 继续递归填下一个数
                backtrack(n, output, res, first + 1);
                // 撤销操作
                Collections.swap(output, first, i);
            }
        }

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new LinkedList<>();
            ArrayList<Integer> output = new ArrayList<>();
            for (int num : nums)
                output.add(num);

            int n = nums.length;
            backtrack(n, output, res, 0);
            return res;
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
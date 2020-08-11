package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest78 {
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 694 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            //置放空集
            result.add(new ArrayList<>());
            for (int num : nums) {
                List<List<Integer>> newSubsets = new ArrayList<>();
                for (List<Integer> curr : result) {
                    newSubsets.add(new ArrayList<Integer>(curr) {{
                        add(num);
                    }});
                }
                result.addAll(newSubsets);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]", solution.subsets(new int[]{1, 2, 3}).toString());
        }
    }
}
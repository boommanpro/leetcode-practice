package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest41 {
//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 
//
// 提示： 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。 
// Related Topics 数组

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int l = 1;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= 0 || nums[i] < l) {
                    continue;
                }
                if (nums[i] != l) {
                    return l;
                }
                l++;
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.firstMissingPositive(new int[]{1, 2, 0}));
            Assert.assertEquals(2, solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
            Assert.assertEquals(1, solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
            Assert.assertEquals(3, solution.firstMissingPositive(new int[]{0, 2, 2, 1, 1}));
        }
    }
}
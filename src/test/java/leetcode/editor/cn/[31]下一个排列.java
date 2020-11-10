package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest31 {
//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 783 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            int[] input1 = {1, 2, 3};
            int[] input2 = {3, 2, 1};
            int[] input3 = {1, 1, 5};
            int[] input4 = {1, 2, 3, 5, 4, 6, 1, 1, 2, 2, 4, 5, 2, 1};
            solution.nextPermutation(input1);
            solution.nextPermutation(input2);
            solution.nextPermutation(input3);
            solution.nextPermutation(input4);
            Assert.assertEquals("[1, 3, 2]", Arrays.toString(input1));
            Assert.assertEquals("[1, 2, 3]", Arrays.toString(input2));
            Assert.assertEquals("[1, 5, 1]", Arrays.toString(input3));
            Assert.assertEquals("[1, 2, 3, 5, 4, 6, 1, 1, 2, 2, 5, 1, 2, 4]", Arrays.toString(input4));
        }
    }
}
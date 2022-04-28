package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest905 {
//给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。 
//
// 返回满足此条件的 任一数组 作为答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,1,2,4]
//输出：[2,4,3,1]
//解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// 0 <= nums[i] <= 5000 
// 
// Related Topics 数组 双指针 排序 👍 275 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int i = 0;
            int j = nums.length - 1;
            while (i <= j) {
                if (nums[i] % 2 == 1 && nums[j] % 2 == 0) {
                    swap(nums, i, j);
                    i++;
                    j--;
                }
                if (nums[i] % 2 == 0) {
                    i++;
                }
                if (nums[j] % 2 == 1) {
                    j--;
                }
            }
            return nums;
        }

        private void swap(int[] nums, int i, int j) {
            int v = nums[i];
            nums[i] = nums[j];
            nums[j] = v;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[4, 2, 1, 3]", Arrays.toString(solution.sortArrayByParity(new int[]{3, 1, 2, 4})));
            Assert.assertEquals("[0]", Arrays.toString(solution.sortArrayByParity(new int[]{0})));
        }

    }
}
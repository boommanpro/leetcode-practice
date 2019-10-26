package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest209 {
    //给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
//
// 示例: 
//
// 输入: s = 7, nums = [2,3,1,2,4,3]
//输出: 2
//解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
// 
//
// 进阶: 
//
// 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// Related Topics 数组 双指针 二分查找
    public static


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int l = 0, r = 0;
            int sum=0;
            int[] ans = new int[]{-1, 0, 0};
            while (r < nums.length) {
                sum += nums[r];
                while (sum >= s) {
                    //记录数据
                    if (ans[0] == -1 || r - l + 1 < ans[0]) {
                        ans[0] = r - l + 1;
                        ans[1] = l;
                        ans[2] = r;
                    }
                    sum -= nums[l];
                    l++;
                }
                r++;
            }



            return ans[0] == -1 ? 0 : ans[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
            Assert.assertEquals(0, solution.minSubArrayLen(100, new int[]{2, 3, 1, 2, 4, 3}));
            Assert.assertEquals(0, solution.minSubArrayLen(100, new int[]{}));
        }
    }
}
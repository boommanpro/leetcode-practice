package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest719 {
//数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。 
//
// 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。
//返回 所有数对距离中 第 k 小的数对距离。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,1], k = 1
//输出：0
//解释：数对和对应的距离如下：
//(1,3) -> 2
//(1,1) -> 0
//(3,1) -> 2
//距离第 1 小的数对是 (1,1) ，距离为 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,6,1], k = 3
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 2 <= n <= 10⁴ 
// 0 <= nums[i] <= 10⁶ 
// 1 <= k <= n * (n - 1) / 2 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 351 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;
            int l = 0;
            int r = nums[n - 1] - nums[0];
            while (l <= r) {
                int mid = ((r - l) >> 1) + l;
                if (count(nums, mid) >= k) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        private int count(int[] nums, int mid) {
            int count = 0;
            for (int l = 0, r = 0; r < nums.length; r++) {
                while (r >= l && nums[r] - nums[l] > mid) {
                    l++;
                }
                count += r - l;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(0, solution.smallestDistancePair(new int[]{1, 3, 1}, 1));
        }

    }
}
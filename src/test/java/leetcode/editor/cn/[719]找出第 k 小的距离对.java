package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest719 {
//给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。 
//
// 示例 1: 
//
// 
//输入：
//nums = [1,3,1]
//k = 1
//输出：0 
//解释：
//所有数对如下：
//(1,3) -> 2
//(1,1) -> 0
//(3,1) -> 2
//因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
// 
//
// 提示: 
//
// 
// 2 <= len(nums) <= 10000. 
// 0 <= nums[i] < 1000000. 
// 1 <= k <= len(nums) * (len(nums) - 1) / 2. 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 244 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);

            int lo = 0;
            int hi = nums[nums.length - 1] - nums[0];
            while (lo < hi) {
                int mi = (lo + hi) / 2;
                if (check(nums, mi, k)) {
                    hi = mi;
                } else {
                    lo = mi + 1;
                }
            }
            return lo;
        }

        public boolean check(int[] nums, int x, int k) {
            int cnt = 0;
            for (int r = 0, l = 0; r < nums.length; r++) {
                while (nums[r] - nums[l] > x) {
                    l++;
                }
                cnt += r - l;
            }
            return cnt >= k;
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
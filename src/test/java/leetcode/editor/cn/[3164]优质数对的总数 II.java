package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

class SolutionTest3164 {
//给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
//
// 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <=
// m - 1）。
//
// 返回 优质数对 的总数。
//
//
//
// 示例 1：
//
//
// 输入：nums1 = [1,3,4], nums2 = [1,3,4], k = 1
//
//
// 输出：5
//
// 解释：
//
// 5个优质数对分别是 (0, 0), (1, 0), (1, 1), (2, 0), 和 (2, 2)。
//
// 示例 2：
//
//
// 输入：nums1 = [1,2,4,12], nums2 = [2,4], k = 3
//
//
// 输出：2
//
// 解释：
//
// 2个优质数对分别是 (3, 0) 和 (3, 1)。
//
//
//
// 提示：
//
//
// 1 <= n, m <= 10⁵
// 1 <= nums1[i], nums2[j] <= 10⁶
// 1 <= k <= 10³
//
//
// Related Topics数组 | 哈希表
//
// 👍 41, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long numberOfPairs(int[] nums1, int[] nums2, int k) {
            Map<Integer, Integer> count1 = new HashMap<>();
            Map<Integer, Integer> count2 = new HashMap<>();
            int max1 = nums1[0];
            for (int i : nums1) {
                max1 = Math.max(i, max1);
                count1.put(i, count1.getOrDefault(i, 0) + 1);
            }
            for (int i : nums2) {
                count2.put(i, count2.getOrDefault(i, 0) + 1);
            }
            long res = 0;
            for (Map.Entry<Integer, Integer> entry : count2.entrySet()) {
                int a = entry.getKey();
                for (int b = a * k; b <= max1; b += a * k) {
                    if (count1.containsKey(b)) {
                        res += (long) entry.getValue() * count1.get(b);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final SolutionTest3162.Solution solution = new SolutionTest3162.Solution();

        @Test
        public void defaultSolutionTest() {
            SolutionTest3162.Solution solution = new SolutionTest3162.Solution();
        }

        @Test
        public void testExample1() {
            int[] nums1 = {1, 3, 4};
            int[] nums2 = {1, 3, 4};
            int k = 1;
            assertEquals("Should be 5 for example 1", 5, solution.numberOfPairs(nums1, nums2, k));
        }

        @Test
        public void testExample2() {
            int[] nums1 = {1, 2, 4, 12};
            int[] nums2 = {2, 4};
            int k = 3;
            assertEquals("Should be 2 for example 2", 2, solution.numberOfPairs(nums1, nums2, k));
        }
    }
}

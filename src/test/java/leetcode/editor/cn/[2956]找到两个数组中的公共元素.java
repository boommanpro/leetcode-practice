package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;

class SolutionTest2956 {
//给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们分别含有 n 和 m 个元素。请你计算以下两个数值：
//
//
// answer1：使得 nums1[i] 在 nums2 中出现的下标 i 的数量。
// answer2：使得 nums2[i] 在 nums1 中出现的下标 i 的数量。
//
//
// 返回 [answer1, answer2]。
//
//
//
// 示例 1：
//
//
// 输入：nums1 = [2,3,2], nums2 = [1,2]
//
//
// 输出：[2,1]
//
// 解释：
//
//
//
// 示例 2：
//
//
// 输入：nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]
//
//
// 输出：[3,4]
//
// 解释：
//
// nums1 中下标在 1，2，3 的元素在 nums2 中也存在。所以 answer1 为 3。
//
// nums2 中下标在 0，1，3，4 的元素在 nums1 中也存在。所以 answer2 为 4。
//
// 示例 3：
//
//
// 输入：nums1 = [3,4,2,3], nums2 = [1,5]
//
//
// 输出：[0,0]
//
// 解释：
//
// nums1 和 nums2 中没有相同的数字，所以答案是 [0,0]。
//
//
//
// 提示：
//
//
// n == nums1.length
// m == nums2.length
// 1 <= n, m <= 100
// 1 <= nums1[i], nums2[i] <= 100
//
//
// Related Topics数组 | 哈希表
//
// 👍 30, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findIntersectionValues(int[] nums1, int[] nums2) {
            Map<Integer, Long> map1 = Arrays.stream(nums1).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<Integer, Long> map2 = Arrays.stream(nums2).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            int[] ans = new int[2];
            for (int i : nums1) {
                if (map2.containsKey(i)) {
                    ans[0]++;
                }
            }
            for (int i : nums2) {
                if (map1.containsKey(i)) {
                    ans[1]++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {
        private final Solution solution = new Solution();

        @Test
        public void testExample1() {
            int[] nums1 = {2, 3, 2};
            int[] nums2 = {1, 2};
            assertArrayEquals(new int[]{2, 1}, solution.findIntersectionValues(nums1, nums2));
        }

        @Test
        public void testExample2() {
            int[] nums1 = {4, 3, 2, 3, 1};
            int[] nums2 = {2, 2, 5, 2, 3, 6};
            assertArrayEquals(new int[]{3, 4}, solution.findIntersectionValues(nums1, nums2));
        }

        @Test
        public void testExample3() {
            int[] nums1 = {3, 4, 2, 3};
            int[] nums2 = {1, 5};
            assertArrayEquals(new int[]{0, 0}, solution.findIntersectionValues(nums1, nums2));
        }

    }
}

package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SolutionTest4 {
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
//
// 你可以假设 nums1 和 nums2 不会同时为空。
//
//
//
// 示例 1:
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
//
//
// 示例 2:
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
//
// Related Topics 数组 二分查找 分治算法

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums1) {
                list.add(num);
            }
            for (int num : nums2) {
                list.add(num);
            }
            Collections.sort(list);
            if (list.size() % 2 == 1) {
                return list.get(list.size() / 2);
            }
            int l = list.size() / 2;
            return ((double)(list.get(l)+list.get(l-1)))/2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2.0d, solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 0.0d);
            Assert.assertEquals(2.5d, solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0.0d);
        }
    }
}
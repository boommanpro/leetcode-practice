package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest88 {

    //给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (nums2 == null || nums2.length == 0) {
                return;
            }
            int i = m - 1;
            int j = n - 1;
            int curr = nums1.length - 1;
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[curr] = nums1[i];
                    i--;
                } else {
                    nums1[curr] = nums2[j];
                    j--;
                }
                curr--;
            }
            while (i >= 0) {
                nums1[curr] = nums1[i];
                i--;
                curr--;
            }
            while (j >= 0) {
                nums1[curr] = nums2[j];
                j--;
                curr--;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            int[] result1 = new int[]{1, 2, 2, 3, 5, 6};
            int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
            solution.merge(nums1, 3, new int[]{2, 5, 6}, 3);
            Assert.assertArrayEquals(result1, nums1);
        }
    }
}
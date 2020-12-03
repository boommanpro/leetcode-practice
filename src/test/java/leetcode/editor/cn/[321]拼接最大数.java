package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest321 {
//给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接
//成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。 
//
// 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。 
//
// 说明: 请尽可能地优化你算法的时间和空间复杂度。 
//
// 示例 1: 
//
// 输入:
//nums1 = [3, 4, 6, 5]
//nums2 = [9, 1, 2, 5, 8, 3]
//k = 5
//输出:
//[9, 8, 6, 5, 3] 
//
// 示例 2: 
//
// 输入:
//nums1 = [6, 7]
//nums2 = [6, 0, 4]
//k = 5
//输出:
//[6, 7, 6, 0, 4] 
//
// 示例 3: 
//
// 输入:
//nums1 = [3, 9]
//nums2 = [8, 9]
//k = 3
//输出:
//[9, 8, 9] 
// Related Topics 贪心算法 动态规划 
// 👍 239 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int n = nums2.length;
            int x = Math.max(0, k - n);
            int y = k - x;
            int[] ans = new int[k];
            int[] temp = new int[k];
            while (x <=nums1.length && y >= 0) {
                int[] sequence1 = getSequence(nums1, x);
                int[] sequence2 = getSequence(nums2, y);
                merge(temp, sequence1, sequence2);
                if (compare(temp, ans)) {
                    System.arraycopy(temp, 0, ans, 0, k);
                }
                x++;
                y--;
            }
            return ans;
        }

        private boolean compare(int[] nums1, int[] nums2) {
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i] == nums2[i]) {
                    continue;
                }
                return nums1[i] > nums2[i];
            }
            return false;
        }

        private void merge(int[] temp, int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int i = 0;
            int len2 = nums2.length;
            int j = 0;
            int p = 0;
            while (p < temp.length) {
                if (i < len1 && j < len2) {
                    if (nums1[i] == nums2[j]) {
                        if (compare(nums1, i, nums2, j)) {
                            temp[p] = nums1[i];
                            i++;
                        } else {
                            temp[p] = nums2[j];
                            j++;
                        }
                    } else if (nums1[i] > nums2[j]) {
                        temp[p] = nums1[i];
                        i++;
                    } else {
                        temp[p] = nums2[j];
                        j++;
                    }
                } else if (i < len1) {
                    temp[p] = nums1[i];
                    i++;
                } else {
                    temp[p] = nums2[j];
                    j++;
                }
                p++;
            }
        }

        private boolean compare(int[] nums1, int i, int[] nums2, int j) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            while (i < len1 || j < len2) {
                if (i < len1 && j < len2) {
                    if (nums1[i] == nums2[j]) {
                        i++;
                        j++;
                        continue;
                    } else {
                        return nums1[i] > nums2[j];
                    }

                }
                return i < len1;
            }
            return true;
        }

        private int[] getSequence(int[] nums, int x) {
            int len = nums.length;
            int top = -1;
            int[] ans = new int[x];
            int remain = len - x;
            for (int num : nums) {
                while (top >= 0 && ans[top] < num && remain > 0) {
                    top--;
                    remain--;
                }
                if (top < x - 1) {
                    ans[++top] = num;
                } else {
                    remain--;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[9, 8, 6, 5, 3]", Arrays.toString(solution.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
            Assert.assertEquals("[6, 7, 6, 0, 4]", Arrays.toString(solution.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)));
            Assert.assertEquals("[9, 8, 9]", Arrays.toString(solution.maxNumber(new int[]{3, 9}, new int[]{8, 9}, 3)));
        }
    }
}
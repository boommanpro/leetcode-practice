package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SolutionTest480 {
//中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。 
//
// 例如： 
//
// 
// [2,3,4]，中位数是 3 
// [2,3]，中位数是 (2 + 3) / 2 = 2.5 
// 
//
// 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗
//口中元素的中位数，并输出由它们组成的数组。 
//
// 
//
// 示例： 
//
// 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。 
//
// 窗口位置                      中位数
//---------------               -----
//[1  3  -1] -3  5  3  6  7       1
// 1 [3  -1  -3] 5  3  6  7      -1
// 1  3 [-1  -3  5] 3  6  7      -1
// 1  3  -1 [-3  5  3] 6  7       3
// 1  3  -1  -3 [5  3  6] 7       5
// 1  3  -1  -3  5 [3  6  7]      6
// 
//
// 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。 
//
// 
//
// 提示： 
//
// 
// 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。 
// 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。 
// 
// Related Topics Sliding Window 
// 👍 150 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            int n = len - k + 1;
            double[] ans = new double[n];

            for (int i = 0; i < n; i++) {
                // i -> i+k-1  范围
                ans[i] = median(nums, i, k);
            }
            return ans;
        }

        private double median(int[] nums, int l, int k) {
            List<Integer> all = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                all.add(nums[l + i]);
            }
            Collections.sort(all);
            if ((k & 1) == 1) {
                return all.get(k / 2);
            }
            return ((long) all.get(k / 2 - 1) + all.get(k / 2)) / 2.0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[1.0, -1.0, -1.0, 3.0, 5.0, 6.0]", Arrays.toString(solution.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
            Assert.assertEquals("[2.147483647E9]", Arrays.toString(solution.medianSlidingWindow(new int[]{2147483647, 2147483647}, 2)));
        }
    }
}
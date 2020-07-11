package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest315 {
//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num
//s[i] 的元素的数量。 
//
// 示例: 
//
// 输入: [5,2,6,1]
//输出: [2,1,1,0] 
//解释:
//5 的右侧有 2 个更小的元素 (2 和 1).
//2 的右侧仅有 1 个更小的元素 (1).
//6 的右侧有 1 个更小的元素 (1).
//1 的右侧有 0 个更小的元素.
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 304 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] index;

        private int[] helper;

        private int[] count;

        public List<Integer> countSmaller(int[] nums) {
            List<Integer> res = new ArrayList<>(nums.length);

            index = new int[nums.length];
            helper = new int[nums.length];
            count = new int[nums.length];
            for (int i = 0; i < index.length; i++) {
                index[i] = i;
            }

            merge(nums, 0, nums.length - 1);

            for (int i = 0; i < count.length; i++) {
                res.add(i, count[i]);
            }
            return res;
        }

        private void merge(int[] nums, int s, int e) {
            if (s == e || s > e) return;
            int mid = (s + e) >> 1;

            if (s < mid) {
                merge(nums, s, mid);
            }

            if (mid + 1 < e) {
                merge(nums, mid + 1, e);
            }

            int i = s, j = mid + 1;
            int hi = s;
            while (i <= mid && j <= e) {
                if (nums[index[i]] <= nums[index[j]]) {
                    // 右侧出
                    helper[hi++] = index[j++];
                } else {
                    // 左侧出 计数
                    count[index[i]] += e - j + 1;
                    helper[hi++] = index[i++];
                }
            }

            while (i <= mid) {
                //左侧出
                helper[hi++] = index[i++];
            }

            while (j <= e) {
                // 右侧出
                helper[hi++] = index[j++];
            }

            for (int k = s; k <= e; k++) {
                index[k] = helper[k];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[2, 1, 1, 0]", solution.countSmaller(new int[]{5, 2, 6, 1}).toString());
        }
    }
}
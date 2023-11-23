package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest2407 {
//给你一个整数数组 nums 和一个整数 k 。
//
// 找到 nums 中满足以下要求的最长子序列：
//
//
// 子序列 严格递增
// 子序列中相邻元素的差值 不超过 k 。
//
//
// 请你返回满足上述要求的 最长子序列 的长度。
//
// 子序列 是从一个数组中删除部分元素后，剩余元素不改变顺序得到的数组。
//
//
//
// 示例 1：
//
// 输入：nums = [4,2,1,4,3,4,5,8,15], k = 3
//输出：5
//解释：
//满足要求的最长子序列是 [1,3,4,5,8] 。
//子序列长度为 5 ，所以我们返回 5 。
//注意子序列 [1,3,4,5,8,15] 不满足要求，因为 15 - 8 = 7 大于 3 。
//
//
// 示例 2：
//
// 输入：nums = [7,4,5,1,8,12,4,7], k = 5
//输出：4
//解释：
//满足要求的最长子序列是 [4,5,8,12] 。
//子序列长度为 4 ，所以我们返回 4 。
//
//
// 示例 3：
//
// 输入：nums = [1,5], k = 1
//输出：1
//解释：
//满足要求的最长子序列是 [1] 。
//子序列长度为 1 ，所以我们返回 1 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i], k <= 10⁵
//
//
// Related Topics树状数组 | 线段树 | 队列 | 数组 | 分治 | 动态规划 | 单调队列
//
// 👍 71, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lengthOfLIS(int[] nums, int k) {
            int max = nums[0];
            for (int num : nums) {
                max = Math.max(max, num);
            }
            int ans = 0;
            SegmentTree segmentTree = new SegmentTree(new int[max + 2]);
            for (int num : nums) {
                num++;
                int len = segmentTree.query(Math.max(num - k, 0), num - 1);
                segmentTree.update(num, len + 1);
                ans = Math.max(ans, len + 1);
            }
            return ans;
        }

        public static class SegmentTree {
            int[] data;
            int[] tree;

            public SegmentTree(int[] arr) {
                int n = arr.length;
                data = new int[n];
                System.arraycopy(arr, 0, data, 0, n);
                tree = new int[4 * n];
            }

            public int query(int l, int r) {
                return query(0, 0, data.length - 1, l, r);
            }

            private int query(int treeIdx, int l, int r, int queryL, int queryR) {
                if (l == queryL && r == queryR) {
                    return tree[treeIdx];
                }
                int mid = ((r - l) >> 1) + l;
                int left = treeIdx * 2 + 1;
                int right = treeIdx * 2 + 2;
                if (queryL >= mid + 1) {
                    return query(right, mid + 1, r, queryL, queryR);
                } else if (queryR <= mid) {
                    return query(left, l, mid, queryL, queryR);
                }

                int leftResult = query(left, l, mid, queryL, mid);
                int rightResult = query(right, mid + 1, r, mid + 1, queryR);
                return Math.max(leftResult, rightResult);
            }

            public void update(int idx, int v) {
                data[idx] = v;
                update(0, 0, data.length - 1, idx, v);
            }

            private void update(int treeIdx, int l, int r, int idx, int v) {
                if (l == r) {
                    tree[treeIdx] = v;
                    return;
                }
                int mid = ((r - l) >> 1) + l;
                int left = treeIdx * 2 + 1;
                int right = treeIdx * 2 + 2;
                if (idx >= mid + 1) {
                    update(right, mid + 1, r, idx, v);
                } else {
                    update(left, l, mid, idx, v);
                }
                tree[treeIdx] = Math.max(tree[left], tree[right]);
            }
        }


    }

//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(5, solution.lengthOfLIS(new int[]{4, 2, 1, 4, 3, 4, 5, 8, 15}, 3));
            Assert.assertEquals(5, solution.lengthOfLIS(new int[]{4, 2, 1, 4, 3, 4, 5, 8, 15}, 3));
            Assert.assertEquals(1, solution.lengthOfLIS(new int[]{1, 5}, 1));
        }

    }
}

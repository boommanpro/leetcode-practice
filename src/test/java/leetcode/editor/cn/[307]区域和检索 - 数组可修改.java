package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest307 {
//给你一个数组 nums ，请你完成两类查询。
//
//
// 其中一类查询要求 更新 数组 nums 下标对应的值
// 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
//
//
// 实现 NumArray 类：
//
//
// NumArray(int[] nums) 用整数数组 nums 初始化对象
// void update(int index, int val) 将 nums[index] 的值 更新 为 val
// int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元
//素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
//
//
//
//
// 示例 1：
//
//
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 10⁴
// -100 <= nums[i] <= 100
// 0 <= index < nums.length
// -100 <= val <= 100
// 0 <= left <= right < nums.length
// 调用 update 和 sumRange 方法次数不大于 3 * 10⁴
//
//
// Related Topics设计 | 树状数组 | 线段树 | 数组
//
// 👍 681, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {

        private SegmentTree segmentTree;

        public NumArray(int[] nums) {
            segmentTree = new SegmentTree(nums);

        }

        public void update(int index, int val) {
            segmentTree.update(index, val);
        }

        public int sumRange(int left, int right) {
            return segmentTree.query(left, right);
        }

        /**
         * SegmentTree 模板
         */

        class SegmentTree {
            int[] tree;
            int[] nums;

            public SegmentTree(int[] nums) {
                this.nums = nums;
                int n = nums.length;
                int height = (int) Math.ceil(Math.log(n) / Math.log(2));
                int maxSize = 2 * (int) Math.pow(2, height) - 1;
                tree = new int[maxSize];
                buildTree(0, 0, n - 1);
            }

            private int buildTree(int node, int start, int end) {
                if (start == end) {
                    tree[node] = nums[start];
                    return tree[node];
                }

                int mid = start + (end - start) / 2;
                tree[node] = buildTree(2 * node + 1, start, mid) +
                        buildTree(2 * node + 2, mid + 1, end);
                return tree[node];
            }

            public int query(int queryStart, int queryEnd) {
                return queryHelper(0, 0, nums.length - 1, queryStart, queryEnd);
            }

            private int queryHelper(int node, int start, int end, int queryStart, int queryEnd) {
                if (queryStart <= start && queryEnd >= end) {
                    return tree[node];
                }

                if (queryStart > end || queryEnd < start) {
                    return 0;
                }

                int mid = start + (end - start) / 2;
                return queryHelper(2 * node + 1, start, mid, queryStart, queryEnd) +
                        queryHelper(2 * node + 2, mid + 1, end, queryStart, queryEnd);
            }

            public void update(int index, int newValue) {
                int diff = newValue - nums[index];
                nums[index] = newValue;
                updateHelper(0, 0, nums.length - 1, index, diff);
            }

            private void updateHelper(int node, int start, int end, int index, int diff) {
                if (index < start || index > end) {
                    return;
                }

                tree[node] += diff;

                if (start != end) {
                    int mid = start + (end - start) / 2;
                    updateHelper(2 * node + 1, start, mid, index, diff);
                    updateHelper(2 * node + 2, mid + 1, end, index, diff);
                }
            }
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(index,val);
     * int param_2 = obj.sumRange(left,right);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {

            NumArray numArray = new NumArray(new int[]{1, 3, 5});
            Assert.assertEquals(9, numArray.sumRange(0, 2));
        }

    }
}

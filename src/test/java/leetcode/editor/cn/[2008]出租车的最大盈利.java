package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

class SolutionTest2008 {
//你驾驶出租车行驶在一条有 n 个地点的路上。这 n 个地点从近到远编号为 1 到 n ，你想要从 1 开到 n ，通过接乘客订单盈利。你只能沿着编号递增的方
//向前进，不能改变方向。
//
// 乘客信息用一个下标从 0 开始的二维数组 rides 表示，其中 rides[i] = [starti, endi, tipi] 表示第 i 位乘客需要从
//地点 starti 前往 endi ，愿意支付 tipi 元的小费。
//
// 每一位 你选择接单的乘客 i ，你可以 盈利 endi - starti + tipi 元。你同时 最多 只能接一个订单。
//
// 给你 n 和 rides ，请你返回在最优接单方案下，你能盈利 最多 多少元。
//
// 注意：你可以在一个地点放下一位乘客，并在同一个地点接上另一位乘客。
//
//
//
// 示例 1：
//
// 输入：n = 5, rides = [[2,5,4],[1,5,1]]
//输出：7
//解释：我们可以接乘客 0 的订单，获得 5 - 2 + 4 = 7 元。
//
//
// 示例 2：
//
// 输入：n = 20, rides = [[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]
//
//输出：20
//解释：我们可以接以下乘客的订单：
//- 将乘客 1 从地点 3 送往地点 10 ，获得 10 - 3 + 2 = 9 元。
//- 将乘客 2 从地点 10 送往地点 12 ，获得 12 - 10 + 3 = 5 元。
//- 将乘客 5 从地点 13 送往地点 18 ，获得 18 - 13 + 1 = 6 元。
//我们总共获得 9 + 5 + 6 = 20 元。
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁵
// 1 <= rides.length <= 3 * 10⁴
// rides[i].length == 3
// 1 <= starti < endi <= n
// 1 <= tipi <= 10⁵
//
//
// Related Topics数组 | 二分查找 | 动态规划 | 排序
//
// 👍 89, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides,(a,b)->{
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for (int[] ride : rides) {
            ride[2] = ride[1] - ride[0] + ride[2];
        }
        SegmentTree segmentTree = new SegmentTree(new long[n + 1]);

        for (int[] ride : rides) {
            int end = ride[1];
            int start = ride[0];
            int c = ride[2];
            long preMax = segmentTree.queryMax(0, end);
            long pre = segmentTree.queryMax(0, start);
            segmentTree.update(end, Math.max(pre + c, preMax));
        }
        return segmentTree.queryMax(0, n);
    }


        public class SegmentTree {
            long[] data;
            long[] maxTree;
            long[] minTree;
            long[] sumTree;

            public SegmentTree(long[] arr) {
                int n = arr.length;
                data = new long[n];
                System.arraycopy(arr, 0, data, 0, n);
                maxTree = new long[4 * n];
                minTree = new long[4 * n];
                sumTree = new long[4 * n];
                build(0, 0, n - 1);
            }


            private void build(int treeIdx, int l, int r) {
                if (l == r) {
                    maxTree[treeIdx] = data[l];
                    minTree[treeIdx] = data[l];
                    sumTree[treeIdx] = data[l];
                    return;
                }
                int mid = ((r - l) >> 1) + l;
                int left = treeIdx * 2 + 1;
                int right = treeIdx * 2 + 2;
                build(left, l, mid);
                build(right, mid + 1, r);
                maxTree[treeIdx] = Math.max(maxTree[left], maxTree[right]);
                minTree[treeIdx] = Math.min(minTree[left], minTree[right]);
                sumTree[treeIdx] = sumTree[left] + sumTree[right];
            }


            public long queryMax(int l, int r) {
                return queryMax(0, 0, data.length - 1, l, r);
            }

            private long queryMax(int treeIdx, int l, int r, int queryL, int queryR) {
                if (l == queryL && r == queryR) {
                    return maxTree[treeIdx];
                }
                int mid = ((r - l) >> 1) + l;
                int left = treeIdx * 2 + 1;
                int right = treeIdx * 2 + 2;
                if (queryL >= mid + 1) {
                    return queryMax(right, mid + 1, r, queryL, queryR);
                } else if (queryR <= mid) {
                    return queryMax(left, l, mid, queryL, queryR);
                }

                long leftResult = queryMax(left, l, mid, queryL, mid);
                long rightResult = queryMax(right, mid + 1, r, mid + 1, queryR);
                return Math.max(leftResult, rightResult);
            }

            public long queryMin(int l, int r) {
                return queryMin(0, 0, data.length - 1, l, r);
            }

            private long queryMin(int treeIdx, int l, int r, int queryL, int queryR) {
                if (l == queryL && r == queryR) {
                    return minTree[treeIdx];
                }
                int mid = ((r - l) >> 1) + l;
                int left = treeIdx * 2 + 1;
                int right = treeIdx * 2 + 2;
                if (queryL >= mid + 1) {
                    return queryMin(right, mid + 1, r, queryL, queryR);
                } else if (queryR <= mid) {
                    return queryMin(left, l, mid, queryL, queryR);
                }

                long leftResult = queryMin(left, l, mid, queryL, mid);
                long rightResult = queryMin(right, mid + 1, r, mid + 1, queryR);
                return Math.min(leftResult, rightResult);
            }

            public long querySum(int l, int r) {
                return querySum(0, 0, data.length - 1, l, r);
            }

            private long querySum(int treeIdx, int l, int r, int queryL, int queryR) {
                if (l == queryL && r == queryR) {
                    return sumTree[treeIdx];
                }
                int mid = ((r - l) >> 1) + l;
                int left = treeIdx * 2 + 1;
                int right = treeIdx * 2 + 2;
                if (queryL >= mid + 1) {
                    return querySum(right, mid + 1, r, queryL, queryR);
                } else if (queryR <= mid) {
                    return querySum(left, l, mid, queryL, queryR);
                }

                long leftResult = querySum(left, l, mid, queryL, mid);
                long rightResult = querySum(right, mid + 1, r, mid + 1, queryR);
                return leftResult + rightResult;
            }

            public void update(int idx, long v) {
                data[idx] = v;
                update(0, 0, data.length - 1, idx, v);
            }

            private void update(int treeIdx, int l, int r, int idx, long v) {
                if (l == r) {
                    maxTree[treeIdx] = v;
                    minTree[treeIdx] = v;
                    sumTree[treeIdx] = v;
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
                maxTree[treeIdx] = Math.max(maxTree[left], maxTree[right]);
                minTree[treeIdx] = Math.min(minTree[left], minTree[right]);
                sumTree[treeIdx] = sumTree[left] + sumTree[right];
            }
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(7, solution.maxTaxiEarnings(5, new int[][]{
                    {2, 5, 4},
                    {1, 5, 1}
            }));
            Assert.assertEquals(20, solution.maxTaxiEarnings(20, new int[][]{
                    {1, 6, 1},
                    {3, 10, 2},
                    {10, 12, 3},
                    {11, 12, 2},
                    {12, 15, 2},
                    {13, 18, 1}
            }));
        }

    }
}

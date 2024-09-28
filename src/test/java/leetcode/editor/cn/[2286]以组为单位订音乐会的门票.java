package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

class SolutionTest2286 {
//一个音乐会总共有 n 排座位，编号从 0 到 n - 1 ，每一排有 m 个座椅，编号为 0 到 m - 1 。你需要设计一个买票系统，针对以下情况进行座位
//安排：
//
//
// 同一组的 k 位观众坐在 同一排座位，且座位连续 。
// k 位观众中 每一位 都有座位坐，但他们 不一定 坐在一起。
//
//
// 由于观众非常挑剔，所以：
//
//
// 只有当一个组里所有成员座位的排数都 小于等于 maxRow ，这个组才能订座位。每一组的 maxRow 可能 不同 。
// 如果有多排座位可以选择，优先选择 最小 的排数。如果同一排中有多个座位可以坐，优先选择号码 最小 的。
//
//
// 请你实现 BookMyShow 类：
//
//
// BookMyShow(int n, int m) ，初始化对象，n 是排数，m 是每一排的座位数。
// int[] gather(int k, int maxRow) 返回长度为 2 的数组，表示 k 个成员中 第一个座位 的排数和座位编号，这 k 位成员必
//须坐在 同一排座位，且座位连续 。换言之，返回最小可能的 r 和 c 满足第 r 排中 [c, c + k - 1] 的座位都是空的，且 r <=
//maxRow 。如果 无法 安排座位，返回 [] 。
// boolean scatter(int k, int maxRow) 如果组里所有 k 个成员 不一定 要坐在一起的前提下，都能在第 0 排到第
//maxRow 排之间找到座位，那么请返回 true 。这种情况下，每个成员都优先找排数 最小 ，然后是座位编号最小的座位。如果不能安排所有 k 个成员的座位，请返回
//false 。
//
//
//
//
// 示例 1：
//
//
//输入：
//["BookMyShow", "gather", "gather", "scatter", "scatter"]
//[[2, 5], [4, 0], [2, 0], [5, 1], [5, 1]]
//输出：
//[null, [0, 0], [], true, false]
//
//解释：
//BookMyShow bms = new BookMyShow(2, 5); // 总共有 2 排，每排 5 个座位。
//bms.gather(4, 0); // 返回 [0, 0]
//                  // 这一组安排第 0 排 [0, 3] 的座位。
//bms.gather(2, 0); // 返回 []
//                  // 第 0 排只剩下 1 个座位。
//                  // 所以无法安排 2 个连续座位。
//bms.scatter(5, 1); // 返回 True
//                   // 这一组安排第 0 排第 4 个座位和第 1 排 [0, 3] 的座位。
//bms.scatter(5, 1); // 返回 False
//                   // 总共只剩下 1 个座位。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 5 * 10⁴
// 1 <= m, k <= 10⁹
// 0 <= maxRow <= n - 1
// gather 和 scatter 总 调用次数不超过 5 * 10⁴ 次。
//
//
// Related Topics设计 | 树状数组 | 线段树 | 二分查找
//
// 👍 59, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class BookMyShow {
        private final SegmentTree segmentTree;

        private final int n;
        private final int m;

        public BookMyShow(int n, int m) {
            long[] v = new long[n];
            Arrays.fill(v, m);
            segmentTree = new SegmentTree(v);
            this.m = m;
            this.n = n;
        }

        public int[] gather(int k, int maxRow) {
            int res = segmentTree.queryMinPosition(0, maxRow, k);
            if (res == -1) {
                return new int[]{};
            }
            long v = segmentTree.getPositionData(res);
            segmentTree.update(res, v - k);
            return new int[]{res, (int) (m - v)};
        }

        public boolean scatter(int k, int maxRow) {
            if (!(segmentTree.querySum(0, maxRow) >= k)) {
                return false;
            }
            while (k > 0) {
                int p = segmentTree.queryMinPosition(0, maxRow, 1);
                long cnt = segmentTree.getPositionData(p);
                long minus = Math.min(k, cnt);
                k -= minus;
                segmentTree.update(p, cnt - minus);
            }
            return true;
        }

        public static class SegmentTree {
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

            public SegmentTree(int[] arr) {
                int n = arr.length;
                data = new long[n];
                for (int i = 0; i < n; i++) {
                    data[i] = arr[i];
                }
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

            public long get(int idx) {
                return data[idx];
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

            public int queryMinPosition(int l, int r, long v) {
                if (queryMax(l, r) < v) {
                    return -1;
                }
                while (l < r) {
                    int mid = ((r - l) >> 1) + l;
                    if (queryMax(l, mid) >= v) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                return l;
            }

            public long getPositionData(int p) {
                return data[p];
            }
        }

    }

    /**
     * Your BookMyShow object will be instantiated and called as such:
     * BookMyShow obj = new BookMyShow(n, m);
     * int[] param_1 = obj.gather(k,maxRow);
     * boolean param_2 = obj.scatter(k,maxRow);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void testExample1() {
            BookMyShow bookMyShow = new BookMyShow(2, 5); // 总共有 2 排，每排 5 个座位。

            // 第一次调用 gather
            int[] result1 = bookMyShow.gather(4, 0); // 返回 [0, 0]
            assertEquals("[0, 0]", Arrays.toString(result1));

            // 第二次调用 gather
            int[] result2 = bookMyShow.gather(2, 0); // 返回 []
            assertEquals("[]", Arrays.toString(result2));

            // 第一次调用 scatter
            boolean result3 = bookMyShow.scatter(5, 1); // 返回 true
            assertTrue(result3);

            // 第二次调用 scatter
            boolean result4 = bookMyShow.scatter(5, 1); // 返回 false
            assertFalse(result4);
        }


        @Test
        public void testBookMyShow() {
            BookMyShow bookMyShow = new BookMyShow(18, 48); // 初始化一个场地

            // 测试用例1: 散开预订 [24, 13]
            boolean result1 = bookMyShow.scatter(24, 13);
            assertEquals(true, result1);

            // 测试用例2: 散开预订 [12, 5]
            boolean result2 = bookMyShow.scatter(12, 5);
            assertEquals(true, result2);

            // 测试用例3: 聚集预订 [12, 5]
            int[] result3 = bookMyShow.gather(12, 5);
            assertEquals("[0, 36]", Arrays.toString(result3));

            // 测试用例4: 散开预订 [3, 12]
            boolean result4 = bookMyShow.scatter(3, 12);
            assertEquals(true, result4);

            // 测试用例5: 聚集预订 [36, 13]
            int[] result5 = bookMyShow.gather(36, 13);
            assertEquals("[1, 3]", Arrays.toString(result5));

            // 测试用例6: 散开预订 [25, 6]
            boolean result6 = bookMyShow.scatter(25, 6);
            assertEquals(true, result6);

            // 测试用例7: 散开预订 [32, 14]
            boolean result7 = bookMyShow.scatter(32, 14);
            assertEquals(true, result7);

            // 测试用例8: 聚集预订 [29, 6]
            int[] result8 = bookMyShow.gather(29, 6);
            assertEquals("[3, 0]", Arrays.toString(result8));

            // 测试用例9: 聚集预订 [3, 11]
            int[] result9 = bookMyShow.gather(3, 11);
            assertEquals("[3, 29]", Arrays.toString(result9));

            // 测试用例10: 散开预订 [30, 0]
            boolean result10 = bookMyShow.scatter(30, 0);
            assertEquals(false, result10);

            // 测试用例11: 聚集预订 [45, 15]
            int[] result11 = bookMyShow.gather(45, 15);
            assertEquals("[4, 0]", Arrays.toString(result11));

            // 测试用例12: 聚集预订 [23, 17]
            int[] result12 = bookMyShow.gather(23, 17);
            assertEquals("[5, 0]", Arrays.toString(result12));

            // 测试用例13: 聚集预订 [23, 2]
            int[] result13 = bookMyShow.gather(23, 2);
            assertEquals("[]", Arrays.toString(result13));

            // 测试用例14: 散开预订 [41, 10]
            boolean result14 = bookMyShow.scatter(41, 10);
            assertEquals(true, result14);

            // 测试用例15: 散开预订 [40, 6]
            boolean result15 = bookMyShow.scatter(40, 6);
            assertEquals(true, result15);
        }


    }
}

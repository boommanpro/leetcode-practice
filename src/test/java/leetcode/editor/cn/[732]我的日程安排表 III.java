package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest732 {
//当 k 个日程存在一些非空交集时（即, k 个日程包含了一些相同时间），就会产生 k 次预订。
//
// 给你一些日程安排 [startTime, endTime) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。
//
//
// 实现一个 MyCalendarThree 类来存放你的日程安排，你可以一直添加新的日程安排。
//
//
// MyCalendarThree() 初始化对象。
// int book(int startTime, int endTime) 返回一个整数 k ，表示日历中存在的 k 次预订的最大值。
//
//
//
//
// 示例：
//
//
//输入：
//["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
//[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
//输出：
//[null, 1, 1, 2, 3, 3, 3]
//
//解释：
//MyCalendarThree myCalendarThree = new MyCalendarThree();
//myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
//myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
//myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是
// 2 次预订。
//myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
//myCalendarThree.book(5, 10); // 返回 3
//myCalendarThree.book(25, 55); // 返回 3
//
//
//
//
// 提示：
//
//
// 0 <= startTime < endTime <= 10⁹
// 每个测试用例，调用 book 函数最多不超过 400次
//
//
// Related Topics设计 | 线段树 | 二分查找 | 有序集合 | 前缀和
//
// 👍 247, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendarThree {

        private SegmentTreeDynamic segmentTreeDynamic;

        public MyCalendarThree() {
            segmentTreeDynamic = new SegmentTreeDynamic((int) (1e9));
        }

        public int book(int startTime, int endTime) {
            segmentTreeDynamic.update(segmentTreeDynamic.root, 0, (int) 1e9, startTime, endTime - 1, 1);
            return (int) segmentTreeDynamic.root.max;
        }

        public class SegmentTreeDynamic {

            public class Node {
                private Node left, right;
                private long sum = 0, min = 0, max = 0, val, add;
            }

            private final int N;
            private final Node root;


            public SegmentTreeDynamic(int max) {
                N = max;
                root = new Node();
            }

            public void update(Node node, int start, int end, int l, int r, long add) {
                if (l <= start && end <= r) {
                    node.sum += (end - start + 1) * add;
                    node.max += add;
                    node.min += add;
                    node.val = add;
                    node.add += add;
                    return;
                }
                int mid = (start + end) >> 1;
                pushDown(node, mid - start + 1, end - mid);
                if (l <= mid) {
                    update(node.left, start, mid, l, r, add);
                }
                if (r > mid) {
                    update(node.right, mid + 1, end, l, r, add);
                }
                pushUp(node);
            }

            public long querySum(Node node, int start, int end, int l, int r) {
                if (l <= start && end <= r) {
                    return node.sum;
                }
                int mid = (start + end) >> 1;
                long ans = 0;
                pushDown(node, mid - start + 1, end - mid);
                if (l <= mid) {
                    ans += querySum(node.left, start, mid, l, r);
                }
                if (r > mid) {
                    ans += querySum(node.right, mid + 1, end, l, r);
                }
                return ans;
            }

            public long queryMin(Node node, int start, int end, int l, int r) {
                if (l <= start && end <= r) {
                    return node.min;
                }
                int mid = (start + end) >> 1, ans = 0;
                pushDown(node, mid - start + 1, end - mid);
                long left = Long.MAX_VALUE, right = Long.MAX_VALUE;
                if (l <= mid) {
                    left = queryMin(node.left, start, mid, l, r);
                }
                if (r > mid) {
                    right = queryMin(node.right, mid + 1, end, l, r);
                }
                return Math.min(left, right);
            }

            public long queryMax(Node node, int start, int end, int l, int r) {
                if (l <= start && end <= r) {
                    return node.min;
                }
                int mid = (start + end) >> 1;
                pushDown(node, mid - start + 1, end - mid);
                long left = Long.MIN_VALUE, right = Long.MIN_VALUE;
                if (l <= mid) {
                    left = queryMax(node.left, start, mid, l, r);
                }
                if (r > mid) {
                    right = queryMax(node.right, mid + 1, end, l, r);
                }
                return Math.max(left, right);
            }


            private void pushUp(Node node) {
                node.sum = node.left.sum + node.right.sum;
                node.min = Math.min(node.left.min, node.right.min);
                node.max = Math.max(node.left.max, node.right.max);
            }

            private void pushDown(Node node, int leftNum, int rightNum) {
                if (node.left == null) {
                    node.left = new Node();
                }
                if (node.right == null) {
                    node.right = new Node();
                }
                if (node.add == 0) {
                    return;
                }
                node.left.sum += node.add * leftNum;
                node.left.max += node.add;
                node.left.min += node.add;
                node.right.sum += node.add * rightNum;
                node.right.max += node.add;
                node.right.min += node.add;
                // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
                node.left.add += node.add;
                node.right.add += node.add;
                node.add = 0;
            }


            public long queryMax(int l, int r) {
                return queryMax(root, 0, N, l, r);
            }

            public long queryMin(int l, int r) {
                return queryMin(root, 0, N, l, r);
            }


            public long querySum(int l, int r) {
                return querySum(root, 0, N, l, r);
            }


            public void update(int idx, long v) {
                update(root, 0, N, idx, idx, v);
            }

            public long get(int idx) {
                return querySum(root, 0, N, idx, idx);
            }

        }


    }

    /**
     * Your MyCalendarThree object will be instantiated and called as such:
     * MyCalendarThree obj = new MyCalendarThree();
     * int param_1 = obj.book(startTime,endTime);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {
        @Test
        public void testComplexScenario() {
            MyCalendarThree myCalendarThree = new MyCalendarThree();
            assertEquals(1, myCalendarThree.book(10, 20));
            assertEquals(1, myCalendarThree.book(50, 60));
            assertEquals(2, myCalendarThree.book(10, 40));
            assertEquals(3, myCalendarThree.book(5, 15));
            assertEquals(3, myCalendarThree.book(5, 10));
            assertEquals(3, myCalendarThree.book(25, 55));
        }

    }
}

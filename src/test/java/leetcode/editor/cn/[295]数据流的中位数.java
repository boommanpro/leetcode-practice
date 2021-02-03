package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

class SolutionTest295 {
//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 堆 设计 
// 👍 341 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        private int count = 0;

        private final PriorityQueue<Integer> minheap;

        private final PriorityQueue<Integer> maxheap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            count = 0;
            maxheap = new PriorityQueue<>((x, y) -> y - x);
            minheap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            count += 1;
            // 小顶堆的所有元素 都要大于 大顶堆的所有元素
            maxheap.offer(num);
            minheap.add(maxheap.poll());
            // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
            if ((count & 1) == 1) {
                maxheap.add(minheap.poll());
            }
        }

        public double findMedian() {
            if ((count & 1) == 0) {
                // 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
                return (double) (maxheap.peek() + minheap.peek()) / 2;
            } else {
                // 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
                return (double) maxheap.peek();
            }
        }

    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            MedianFinder finder = new MedianFinder();
            finder.addNum(1);
            finder.addNum(2);
            Assert.assertEquals(1.5, finder.findMedian(), 0.01);
            finder.addNum(3);
            Assert.assertEquals(2.0, finder.findMedian(), 0.01);

        }
    }
}
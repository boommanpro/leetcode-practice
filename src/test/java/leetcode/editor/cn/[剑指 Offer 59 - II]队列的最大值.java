package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class SolutionTest剑指Offer59_II {
//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
// Related Topics 栈 Sliding Window 
// 👍 197 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class MaxQueue {

        Queue<Integer> queue;

        Deque<Integer> max;

        public MaxQueue() {
            queue = new LinkedList<>();
            max = new LinkedList<>();
        }

        public int max_value() {
            return max.size() == 0 ? -1 : max.peek();
        }

        public void push_back(int value) {
            queue.add(value);
            while (max.size() != 0 && max.peekLast() < value) {
                max.pollLast();
            }
            max.add(value);
        }

        public int pop_front() {
            if (max.size() != 0 && max.peek().equals(queue.peek())) {
                max.poll();
            }
            return queue.size() == 0 ? -1 : queue.poll();
        }
    }

    /**
     * Your MaxQueue object will be instantiated and called as such:
     * MaxQueue obj = new MaxQueue();
     * int param_1 = obj.max_value();
     * obj.push_back(value);
     * int param_3 = obj.pop_front();
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            // 本算法基于问题的一个重要性质：当一个元素进入队列的时候，它前面所有比它小的元素就不会再对答案产生影响。
            MaxQueue queue0 = new MaxQueue();
            queue0.push_back(3);
            queue0.push_back(1);
            queue0.push_back(2);
            Assert.assertEquals(3, queue0.max_value());
            Assert.assertEquals(3, queue0.pop_front());
            Assert.assertEquals(2, queue0.max_value());
            Assert.assertEquals(1, queue0.pop_front());
            Assert.assertEquals(2, queue0.max_value());

            MaxQueue queue1 = new MaxQueue();
            Assert.assertEquals(-1, queue1.pop_front());
            Assert.assertEquals(-1, queue1.max_value());

            MaxQueue queue2 = new MaxQueue();
            queue2.push_back(3);
            queue2.push_back(2);
            queue2.push_back(1);
            Assert.assertEquals(3, queue2.max_value());
            Assert.assertEquals(3, queue2.pop_front());
            Assert.assertEquals(2, queue2.max_value());
        }
    }
}
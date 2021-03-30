package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题30 {
//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 
// 👍 114 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        Stack<Integer> stack;

        PriorityQueue<Integer> queue;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            queue = new PriorityQueue<>();
        }

        public void push(int x) {
            stack.push(x);
            if (queue.isEmpty()) {
                queue.add(x);
            } else if (queue.peek() >= x) {
                queue.add(x);
            }
        }

        public void pop() {
            Integer v = stack.pop();
            if (v.equals(queue.peek())) {
                queue.poll();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return queue.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            Assert.assertEquals(-3, minStack.min());
            minStack.pop();
            Assert.assertEquals(0, minStack.top());
            Assert.assertEquals(-2, minStack.min());
        }
    }
}
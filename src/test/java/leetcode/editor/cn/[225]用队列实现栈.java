package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

class SolutionTest225 {
//使用队列实现栈的下列操作： 
//
// 
// push(x) -- 元素 x 入栈 
// pop() -- 移除栈顶元素 
// top() -- 获取栈顶元素 
// empty() -- 返回栈是否为空 
// 
//
// 注意: 
//
// 
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
//法的。 
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。 
// 
// Related Topics 栈 设计

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {

        private int tail;
        private final Queue<Integer> q;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            q = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            tail = x;
            q.offer(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            int size = q.size();
            for (int i = 0; i < size - 2; i++) {
                q.add(q.remove());
            }
            tail = q.remove();
            q.add(tail);
            return q.remove();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return tail;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q.isEmpty();
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            MyStack stack = new MyStack();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            Assert.assertEquals(3, stack.top());
            Assert.assertEquals(3, stack.pop());
            Assert.assertEquals(2, stack.top());
            Assert.assertEquals(2, stack.pop());
            Assert.assertFalse(stack.empty());
            Assert.assertEquals(1, stack.pop());
            Assert.assertTrue(stack.empty());
        }
    }
}
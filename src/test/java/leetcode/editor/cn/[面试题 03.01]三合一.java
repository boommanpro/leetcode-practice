package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题03_01 {
//三合一。描述如何只用一个数组来实现三个栈。 
//
// 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。s
//tackNum表示栈下标，value表示压入的值。 
//
// 构造函数会传入一个stackSize参数，代表每个栈的大小。 
//
// 示例1: 
//
//  输入：
//["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
//[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
// 输出：
//[null, null, null, 1, -1, -1, true]
//说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
// 
//
// 示例2: 
//
//  输入：
//["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
//[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, -1, -1]
// 
// Related Topics 设计

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class TripleInOne {

        /**
         * 3个栈
         */
        private final int[][] multiStack;

        /**
         * 栈的最大容量
         */
        private final int stackSize;

        /**
         * 栈的当前容量
         */
        private final int[] size = new int[]{-1, -1, -1};

        public TripleInOne(int stackSize) {
            this.stackSize = stackSize;
            multiStack = new int[3][stackSize];
        }

        //tackNum表示栈下标，value表示压入的值。

        //当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。

        public void push(int stackNum, int value) {
            if (size[stackNum] < stackSize-1) {
                size[stackNum]++;
                multiStack[stackNum][size[stackNum]] = value;
            }
        }

        public int pop(int stackNum) {
            if (size[stackNum] >= 0) {
                int value = multiStack[stackNum][size[stackNum]];
                size[stackNum]--;
                return value;
            }
            return -1;
        }

        public int peek(int stackNum) {
            if (size[stackNum] >= 0) {
                return multiStack[stackNum][size[stackNum]];
            }
            return -1;
        }

        public boolean isEmpty(int stackNum) {
            return size[stackNum] == -1;
        }
    }

    /**
     * Your TripleInOne object will be instantiated and called as such:
     * TripleInOne obj = new TripleInOne(stackSize);
     * obj.push(stackNum,value);
     * int param_2 = obj.pop(stackNum);
     * int param_3 = obj.peek(stackNum);
     * boolean param_4 = obj.isEmpty(stackNum);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            TripleInOne triple0 = new TripleInOne(2);
            triple0.push(0, 1);
            triple0.push(0, 2);
            Assert.assertEquals(2, triple0.pop(0));
            Assert.assertEquals(1, triple0.pop(0));
            Assert.assertEquals(-1, triple0.pop(0));
            Assert.assertTrue(triple0.isEmpty(0));

            TripleInOne triple1 = new TripleInOne(2);
            triple1.push(0, 1);
            triple1.push(0, 2);
            triple1.push(0, 3);
            Assert.assertEquals(2, triple1.pop(0));
            Assert.assertEquals(1, triple1.pop(0));
            Assert.assertEquals(-1, triple1.pop(0));
            Assert.assertEquals(-1, triple1.peek(0));
        }
    }
}
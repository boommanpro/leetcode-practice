package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

class SolutionTest703 {
//设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。 
//
// 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返
//回当前数据流中第K大的元素。 
//
// 示例: 
//
// 
//int k = 3;
//int[] arr = [4,5,8,2]; -> [4,5,8]   //最终维护一个k大小数组  如果插入数据比nums[0]<=则不插入 //如果比kth大则插入合适位置后num[0]删除,
// 永远维护k大小的数组
//KthLargest kthLargest = new KthLargest(3, arr);
//kthLargest.add(3);   // returns 4   -> [4,5,8]
//kthLargest.add(5);   // returns 5   -> [5,5,8]
//kthLargest.add(10);  // returns 5   -> [5,8,10]
//kthLargest.add(9);   // returns 8   -> [8,9,10]
//kthLargest.add(4);   // returns 8   -> [8,9,10]
// 
//
// 说明: 
//你可以假设 nums 的长度≥ k-1 且k ≥ 1。 
// Related Topics 堆

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {

        int size;
        PriorityQueue<Integer> pq;

        public KthLargest(int k, int[] nums) {
            size = k;
            pq = new PriorityQueue<>(3);
            for(int x : nums)
                add(x);
        }

        @SuppressWarnings("all")
        public int add(int val) {
            pq.offer(val);
            if(pq.size() > size)
                pq.poll();
            return pq.peek();
        }
    }

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            int k = 3;
            int[] arr = new int[]{4, 5, 8, 2};
            KthLargest kthLargest = new KthLargest(3, arr);
            Assert.assertEquals(4, kthLargest.add(3));
            Assert.assertEquals(5, kthLargest.add(5));
            Assert.assertEquals(5, kthLargest.add(10));
            Assert.assertEquals(8, kthLargest.add(9));
            Assert.assertEquals(8, kthLargest.add(4));
        }
    }
}
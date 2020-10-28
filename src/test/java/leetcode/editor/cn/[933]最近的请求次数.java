package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest933 {
//写一个 RecentCounter 类来计算特定时间范围内最近的请求。 
//
// 请你实现 RecentCounter 类： 
//
// 
// RecentCounter() 初始化计数器，请求数为 0 。 
// int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求
//）。确切地说，返回在 [t-3000, t] 内发生的请求数。 
// 
//
// 保证每次对 ping 的调用都使用比之前更大的 t 值。 
//
// 
//
// 示例 1： 
//
// 输入：
//["RecentCounter", "ping", "ping", "ping", "ping"]
//[[], [1], [100], [3001], [3002]]
//输出：
//[null, 1, 2, 3, 3]
//
//解释：
//RecentCounter recentCounter = new RecentCounter();
//recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
//recentCounter.ping(100);   // requests = [<u>1</u>, <u>100</u>]，范围是 [-2900,100
//]，返回 2
//recentCounter.ping(3001);  // requests = [<u>1</u>, <u>100</u>, <u>3001</u>]，范
//围是 [1,3001]，返回 3
//recentCounter.ping(3002);  // requests = [1, <u>100</u>, <u>3001</u>, <u>3002<
///u>]，范围是 [2,3002]，返回 3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= t <= 104 
// 保证每次对 ping 的调用都使用比之前更大的 t 值 
// 至多调用 ping 方法 104 次 
// 
// Related Topics 队列 
// 👍 68 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class RecentCounter {

        Queue<Integer> queue;

        private static final int INTERVAL = 3000;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            remove(t - INTERVAL);
            queue.add(t);
            return queue.size();
        }

        private void remove(int v) {
            while (!queue.isEmpty() && queue.peek() < v) {
                queue.poll();
            }
        }
    }

    /**
     * Your RecentCounter object will be instantiated and called as such:
     * RecentCounter obj = new RecentCounter();
     * int param_1 = obj.ping(t);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            RecentCounter counter0 = new RecentCounter();
            Assert.assertEquals(1, counter0.ping(1));
            Assert.assertEquals(2, counter0.ping(100));
            Assert.assertEquals(3, counter0.ping(3001));
            Assert.assertEquals(3, counter0.ping(3002));
        }
    }
}
package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

class SolutionTest729 {
//实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
//
// 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
//
// 日程可以用一对整数 startTime 和 endTime 表示，这里的时间是半开区间，即 [startTime, endTime), 实数 x 的范围为
//， startTime <= x < endTime 。
//
// 实现 MyCalendar 类：
//
//
// MyCalendar() 初始化日历对象。
// boolean book(int startTime, int endTime) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。
//否则，返回 false 并且不要将该日程安排添加到日历中。
//
//
//
//
// 示例：
//
//
//输入：
//["MyCalendar", "book", "book", "book"]
//[[], [10, 20], [15, 25], [20, 30]]
//输出：
//[null, true, false, true]
//
//解释：
//MyCalendar myCalendar = new MyCalendar();
//myCalendar.book(10, 20); // return True
//myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了
//。
//myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20
// ，且不包含时间 20 。
//
//
//
// 提示：
//
//
// 0 <= start < end <= 10⁹
// 每个测试用例，调用 book 方法的次数最多不超过 1000 次。
//
//
// Related Topics设计 | 线段树 | 数组 | 二分查找 | 有序集合
//
// 👍 316, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendar {

        private TreeMap<Integer, Integer> calendar;

        public MyCalendar() {
            calendar = new TreeMap<>();
        }

        public boolean book(int startTime, int endTime) {
            Map.Entry<Integer, Integer> floorEntry = calendar.floorEntry(endTime - 1);
            Map.Entry<Integer, Integer> ceilingEntry = calendar.ceilingEntry(startTime);
            if (floorEntry != null) {
                if (floorEntry.getValue() >= startTime) {
                    return false;
                }
            }
            if (ceilingEntry != null) {
                if (ceilingEntry.getKey() < endTime) {
                    return false;
                }
            }
            calendar.put(startTime, endTime - 1);
            return true;
        }

    }

    /**
     * Your MyCalendar object will be instantiated and called as such:
     * MyCalendar obj = new MyCalendar();
     * boolean param_1 = obj.book(startTime,endTime);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {


        @Test
        public void testBook() {
            MyCalendar myCalendar = new MyCalendar();

            // 测试用例1：第一次预订成功
            Assert.assertTrue("Test case 1 failed", myCalendar.book(10, 20));

            // 测试用例2：第二次预订失败，时间冲突
            Assert.assertFalse("Test case 2 failed", myCalendar.book(15, 25));

            // 测试用例3：第三次预订成功，时间不冲突
            Assert.assertTrue("Test case 3 failed", myCalendar.book(20, 30));

            // 测试用例4：预订在已有预订之前，时间不冲突
            Assert.assertTrue("Test case 4 failed", myCalendar.book(5, 10));

            // 测试用例5：预订在已有预订之后，时间不冲突
            Assert.assertTrue("Test case 5 failed", myCalendar.book(30, 40));

            // 测试用例6：预订与已有预订相邻，时间不冲突
            Assert.assertTrue("Test case 6 failed", myCalendar.book(0, 5));
            Assert.assertTrue("Test case 7 failed", myCalendar.book(40, 50));

            System.out.println("All test cases passed!");
        }

        @Test
        public void testBookNew() {
            MyCalendar myCalendar = new MyCalendar();

            // 新的测试用例
            Assert.assertTrue("Test case 1 failed", myCalendar.book(48, 50));
            Assert.assertTrue("Test case 2 failed", myCalendar.book(0, 6));
            Assert.assertTrue("Test case 3 failed", myCalendar.book(6, 13));
            Assert.assertFalse("Test case 4 failed", myCalendar.book(8, 13)); // 冲突
            Assert.assertTrue("Test case 5 failed", myCalendar.book(15, 23));
            Assert.assertFalse("Test case 6 failed", myCalendar.book(49, 50)); // 冲突
            Assert.assertFalse("Test case 7 failed", myCalendar.book(45, 50)); // 冲突
            Assert.assertTrue("Test case 8 failed", myCalendar.book(29, 34));
            Assert.assertFalse("Test case 9 failed", myCalendar.book(3, 12)); // 冲突
            Assert.assertTrue("Test case 10 failed", myCalendar.book(38, 44));

            System.out.println("New test cases passed!");
        }
    }
}

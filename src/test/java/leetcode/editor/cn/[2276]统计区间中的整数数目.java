package leetcode.editor.cn;

import com.sun.jndi.cosnaming.CNCtx;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class SolutionTest2276 {
//给你区间的 空 集，请你设计并实现满足要求的数据结构： 
//
// 
// 新增：添加一个区间到这个区间集合中。 
// 统计：计算出现在 至少一个 区间中的整数个数。 
// 
//
// 实现 CountIntervals 类： 
//
// 
// CountIntervals() 使用区间的空集初始化对象 
// void add(int left, int right) 添加区间 [left, right] 到区间集合之中。 
// int count() 返回出现在 至少一个 区间中的整数个数。 
// 
//
// 注意：区间 [left, right] 表示满足 left <= x <= right 的所有整数 x 。 
//
// 
//
// 示例 1： 
//
// 
//输入
//["CountIntervals", "add", "add", "count", "add", "count"]
//[[], [2, 3], [7, 10], [], [5, 8], []]
//输出
//[null, null, null, 6, null, 8]
//
//解释
//CountIntervals countIntervals = new CountIntervals(); // 用一个区间空集初始化对象
//countIntervals.add(2, 3);  // 将 [2, 3] 添加到区间集合中
//countIntervals.add(7, 10); // 将 [7, 10] 添加到区间集合中
//countIntervals.count();    // 返回 6
//                           // 整数 2 和 3 出现在区间 [2, 3] 中
//                           // 整数 7、8、9、10 出现在区间 [7, 10] 中
//countIntervals.add(5, 8);  // 将 [5, 8] 添加到区间集合中
//countIntervals.count();    // 返回 8
//                           // 整数 2 和 3 出现在区间 [2, 3] 中
//                           // 整数 5 和 6 出现在区间 [5, 8] 中
//                           // 整数 7 和 8 出现在区间 [5, 8] 和区间 [7, 10] 中
//                           // 整数 9 和 10 出现在区间 [7, 10] 中 
//
// 
//
// 提示： 
//
// 
// 1 <= left <= right <= 10⁹ 
// 最多调用 add 和 count 方法 总计 10⁵ 次 
// 调用 count 方法至少一次 
// 
// Related Topics 设计 线段树 有序集合 👍 27 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class CountIntervals {

        private int cnt = 0;

        private final TreeMap<Integer, Integer> m = new TreeMap<>();

        public CountIntervals() {

        }

        public void add(int left, int right) {
            // 遍历所有被 [left,right] 覆盖到的区间（部分覆盖也算）
            for (Map.Entry<Integer, Integer> e = m.ceilingEntry(left); e != null && e.getValue() <= right; e = m.ceilingEntry(left)) {
                int l = e.getValue(), r = e.getKey();
                left = Math.min(left, l);   // 合并后的新区间，其左端点为所有被覆盖的区间的左端点的最小值
                right = Math.max(right, r); // 合并后的新区间，其右端点为所有被覆盖的区间的右端点的最大值
                cnt -= r - l + 1;
                m.remove(r);
            }
            cnt += right - left + 1;
            m.put(right, left); // 所有被覆盖到的区间与 [left,right] 合并成一个新区间
        }


        public int count() {
            return cnt;
        }
    }

    /**
     * Your CountIntervals object will be instantiated and called as such:
     * CountIntervals obj = new CountIntervals();
     * obj.add(left,right);
     * int param_2 = obj.count();
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            CountIntervals intervals = null;
            intervals = new CountIntervals();
            intervals.add(2, 3);
            intervals.add(7, 10);
            Assert.assertEquals(6, intervals.count());
            intervals.add(5, 8);
            Assert.assertEquals(8, intervals.count());
            intervals = new CountIntervals();
            intervals.add(8, 43);
            intervals.add(13, 16);
            intervals.add(26, 33);
            intervals.add(28, 36);
            intervals.add(29, 37);
            Assert.assertEquals(36, intervals.count());
        }

    }
}
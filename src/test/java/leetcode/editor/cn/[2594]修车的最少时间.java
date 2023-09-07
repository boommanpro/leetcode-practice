package leetcode.editor.cn;

import lombok.Getter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

class SolutionTest2594 {
//给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n² 分钟内修好
// n 辆车。
//
// 同时给你一个整数 cars ，表示总共需要修理的汽车数目。
//
// 请你返回修理所有汽车 最少 需要多少时间。
//
// 注意：所有机械工可以同时修理汽车。
//
//
//
// 示例 1：
//
//
//输入：ranks = [4,2,3,1], cars = 10
//输出：16
//解释：
//- 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
//- 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
//- 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
//- 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
//16 分钟是修理完所有车需要的最少时间。
//
//
// 示例 2：
//
//
//输入：ranks = [5,1,8], cars = 6
//输出：16
//解释：
//- 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
//- 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
//- 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
//16 分钟时修理完所有车需要的最少时间。
//
//
//
//
// 提示：
//
//
// 1 <= ranks.length <= 10⁵
// 1 <= ranks[i] <= 100
// 1 <= cars <= 10⁶
//
//
// Related Topics数组 | 二分查找
//
// 👍 48, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {



        public long repairCars(int[] ranks, int cars) {
            long l = 1, r = 1l * ranks[0] * cars * cars;
            while (l < r) {
                long m = l + r >> 1;
                if (check(ranks, cars, m)) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return l;
        }

        public boolean check(int[] ranks, int cars, long m) {
            long cnt = 0;
            for (int x : ranks) {
                cnt += (long) Math.sqrt(m / x);
            }
            return cnt >= cars;
        }

        public static class Worker {
            Integer id;
            long rank;

            long time;

            Long next;
        }



        public long repairCars0(int[] ranks, int cars) {
            //n*n
            // 1 3 5 7 9 每次小号的时间都是前一次时间 n*2+1
            TreeSet<Worker> treeSet = new TreeSet<>((o1, o2) -> {
                if (o1.next.equals(o2.next)) {
                    return o1.id.compareTo(o2.id);
                }
                return o1.next.compareTo(o2.next);
            });
            for (int i = 0; i < ranks.length; i++) {
                Worker worker = new Worker();
                worker.id = i;
                worker.rank = ranks[i];
                worker.time = 1;
                worker.next = worker.rank;
                treeSet.add(worker);
            }

            long ans = 0;
            for (int i = 0; i < cars; i++) {
                Worker worker = treeSet.pollFirst();
                ans = Math.max(ans, worker.next);
                worker.time++;
                worker.next = worker.time * worker.time * worker.rank;
                treeSet.add(worker);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(16, solution.repairCars(new int[]{4, 2, 3, 1}, 10));
            Assert.assertEquals(16, solution.repairCars(new int[]{5, 1, 8}, 6));
            Assert.assertEquals(37632, solution.repairCars(new int[]{3, 3, 5, 1, 1, 3, 3, 7, 4}, 1088));
            Assert.assertEquals(2358388332L, solution.repairCars(new int[]{31, 31, 5, 19, 19, 10, 31, 18, 19, 3, 16, 20, 4, 16, 2, 25, 10, 16, 23, 18, 21, 23, 28, 6, 7, 29, 11, 11, 19, 20, 24, 19, 26, 12, 29, 29, 1, 14, 17, 26, 24, 7, 11, 28, 22, 14, 31, 12, 3, 19, 16, 26, 11}, 736185));
        }

    }
}

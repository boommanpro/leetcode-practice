package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest765 {
//N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交
//换座位。 
//
// 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)
//。 
//
// 这些情侣的初始座位 row[i] 是由最初始坐在第 i 个座位上的人决定的。 
//
// 示例 1: 
//
// 
//输入: row = [0, 2, 1, 3]
//输出: 1
//解释: 我们只需要交换row[1]和row[2]的位置即可。
// 
//
// 示例 2: 
//
// 
//输入: row = [3, 2, 0, 1]
//输出: 0
//解释: 无需交换座位，所有的情侣都已经可以手牵手了。
// 
//
// 说明: 
//
// 
// len(row) 是偶数且数值在 [4, 60]范围内。 
// 可以保证row 是序列 0...len(row)-1 的一个全排列。 
// 
// Related Topics 贪心算法 并查集 图 
// 👍 228 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSwapsCouples(int[] row) {
            int n = row.length;
            int tot = n / 2;
            UnionFind unionFind = new UnionFind(tot);

            for (int i = 0; i < n; i += 2) {
                int l = row[i] / 2;
                int r = row[i + 1] / 2;
                unionFind.union(l, r);
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < tot; i++) {
                int fx = unionFind.find(i);
                map.put(fx, map.getOrDefault(fx, 0) + 1);
            }

            int ret = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                ret += entry.getValue() - 1;
            }
            return ret;
        }

        public static class UnionFind {

            private final int[] parents;

            public UnionFind(int n) {
                parents = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                }
            }

            public boolean union(int x, int y) {
                int px = find(x);
                int py = find(y);
                if (px == py) {
                    return false;
                }
                if (px > py) {
                    int temp = px;
                    px = py;
                    py = temp;
                }
                parents[px] = py;
                return true;
            }

            private int find(int v) {
                if (v != parents[v]) {
                    parents[v] = find(parents[v]);
                }
                return parents[v];
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.minSwapsCouples(new int[]{0, 2, 1, 3}));
            Assert.assertEquals(0, solution.minSwapsCouples(new int[]{3, 2, 0, 1}));
        }
    }
}
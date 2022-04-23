package leetcode.editor.cn;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest587 {
//在一个二维的花园中，有一些用 (x, y) 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。只有当所有的树都被绳子包围时，花园才能
//围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。 
//
// 
//
// 示例 1: 
//
// 输入: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
//输出: [[1,1],[2,0],[4,2],[3,3],[2,4]]
//解释:
//
// 
//
// 示例 2: 
//
// 输入: [[1,2],[2,2],[4,2]]
//输出: [[1,2],[2,2],[4,2]]
//解释:
//
//即使树都在一条直线上，你也需要先用绳子包围它们。
// 
//
// 
//
// 注意: 
//
// 
// 所有的树应当被围在一起。你不能剪断绳子来包围树或者把树分成一组以上。 
// 输入的整数在 0 到 100 之间。 
// 花园至少有一棵树。 
// 所有树的坐标都是不同的。 
// 输入的点没有顺序。输出顺序也没有要求。 
// Related Topics 几何 数组 数学 👍 92 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] subtraction(int[] a, int[] b) { // 向量相减
            return new int[]{a[0] - b[0], a[1] - b[1]};
        }

        double cross(int[] a, int[] b) { // 叉乘
            return a[0] * b[1] - a[1] * b[0];
        }

        double getArea(int[] a, int[] b, int[] c) { // 向量 ab 转为 向量 ac 过程中扫过的面积
            return cross(subtraction(b, a), subtraction(c, a));
        }

        public int[][] outerTrees(int[][] trees) {
            Arrays.sort(trees, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            int n = trees.length, tp = 0;
            int[] stk = new int[n + 10];
            boolean[] vis = new boolean[n + 10];
            stk[++tp] = 0; // 不标记起点
            for (int i = 1; i < n; i++) {
                int[] c = trees[i];
                while (tp >= 2) {
                    int[] a = trees[stk[tp - 1]], b = trees[stk[tp]];
                    if (getArea(a, b, c) < 0) vis[stk[tp--]] = false;
                    else break;
                }
                stk[++tp] = i;
                vis[i] = true;
            }
            int size = tp;
            for (int i = n - 1; i >= 0; i--) {
                if (vis[i]) continue;
                int[] c = trees[i];
                while (tp > size) {
                    int[] a = trees[stk[tp - 1]], b = trees[stk[tp]];
                    if (getArea(a, b, c) < 0) tp--;
                        // vis[stk[tp--]] = false; // 非必须
                    else break;
                }
                stk[++tp] = i;
                // vis[i] = true; // 非必须
            }
            int[][] ans = new int[tp - 1][2];
            for (int i = 1; i < tp; i++) ans[i - 1] = trees[stk[i]];
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[1, 1],[2, 0],[4, 2],[3, 3],[2, 4]]", ArrayUtils.twoDimension2String(solution.outerTrees(new int[][]{
                    {1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}
            })));
            Assert.assertEquals("[[1, 2],[2, 2],[4, 2]]", ArrayUtils.twoDimension2String(solution.outerTrees(new int[][]{
                    {1, 2}, {2, 2}, {4, 2}
            })));
        }

    }
}
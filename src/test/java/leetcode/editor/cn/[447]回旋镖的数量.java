package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest447 {
//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。
//
// 返回平面上所有回旋镖的数量。
//
// 示例 1：
//
//
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
//
//
// 示例 2：
//
//
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
//
//
// 示例 3：
//
//
//输入：points = [[1,1]]
//输出：0
//
//
//
//
// 提示：
//
//
// n == points.length
// 1 <= n <= 500
// points[i].length == 2
// -10⁴ <= xi, yi <= 10⁴
// 所有点都 互不相同
//
//
// Related Topics数组 | 哈希表 | 数学
//
// 👍 302, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            Map<Integer, Integer> cnt = new HashMap<>();
            int ans = 0;
            for (int[] a : points) {
                cnt.clear();
                for (int[] b : points) {
                    int dis = (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
                    int curr = cnt.getOrDefault(dis, 0);
                    ans += 2 * curr;
                    cnt.put(dis, curr + 1);
                }
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
            Assert.assertEquals(2, solution.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
            Assert.assertEquals(2, solution.numberOfBoomerangs(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
            Assert.assertEquals(0, solution.numberOfBoomerangs(new int[][]{{1, 1},}));
        }

    }
}

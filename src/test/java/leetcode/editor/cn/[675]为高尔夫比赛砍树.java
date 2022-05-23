package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class SolutionTest675 {
//你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个 m x n 的矩阵表示， 在这个矩阵中： 
//
// 
// 0 表示障碍，无法触碰 
// 1 表示地面，可以行走 
// 比 1 大的数 表示有树的单元格，可以行走，数值表示树的高度 
// 
//
// 每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。 
//
// 你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。 
//
// 你将从 (0, 0) 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。 
//
// 可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。 
//
// 
//
// 示例 1： 
//
// 
//输入：forest = [[1,2,3],[0,0,4],[7,6,5]]
//输出：6
//解释：沿着上面的路径，你可以用 6 步，按从最矮到最高的顺序砍掉这些树。 
//
// 示例 2： 
//
// 
//输入：forest = [[1,2,3],[0,0,0],[7,6,5]]
//输出：-1
//解释：由于中间一行被障碍阻塞，无法访问最下面一行中的树。
// 
//
// 示例 3： 
//
// 
//输入：forest = [[2,3,4],[0,0,5],[8,7,6]]
//输出：6
//解释：可以按与示例 1 相同的路径来砍掉所有的树。
//(0,0) 位置的树，可以直接砍去，不用算步数。
// 
//
// 
//
// 提示： 
//
// 
// m == forest.length 
// n == forest[i].length 
// 1 <= m, n <= 50 
// 0 <= forest[i][j] <= 10⁹ 
// 
// Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 👍 146 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public static class TreePoint {
            private int height;
            private int x;
            private int y;

            public TreePoint(int height, int x, int y) {
                this.height = height;
                this.x = x;
                this.y = y;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }
        }

        public static int[][] DIRECTION = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
        };

        private static final int BLOCK = 0;

        private static final int CAN_RUN = 1;

        public int cutOffTree(List<List<Integer>> forest) {
            int m = forest.size();
            int n = forest.get(0).size();

            //求出树的高度列表
            TreeMap<Integer, TreePoint> treeMap = new TreeMap<>();
            for (int i = 0; i < m; i++) {
                List<Integer> row = forest.get(i);
                for (int j = 0; j < n; j++) {
                    Integer height = row.get(j);
                    if (height > 1) {
                        treeMap.put(height, new TreePoint(height, i, j));
                    }
                }
            }
            int ans = 0;
            int currX = 0;
            int currY = 0;
            for (Map.Entry<Integer, TreePoint> integerTreePointEntry : treeMap.entrySet()) {
                TreePoint tree = integerTreePointEntry.getValue();
                int cost = calcCost(currX, currY, tree.getX(), tree.getY(), m, n, forest);
                if (cost == -1) {
                    return -1;
                }
                ans += cost;
                currX = tree.getX();
                currY = tree.getY();
            }

            return ans;
        }

        private int calcCost(int currX, int currY, int x, int y, int m, int n, List<List<Integer>> forest) {

            int ans = 0;
            boolean[][] visited = new boolean[m][n];
            visited[currX][currY] = true;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{currX, currY});
            while (!queue.isEmpty()) {
                int len = queue.size();
                while (len > 0) {
                    int[] curr = queue.poll();
                    if (curr[0] == x && curr[1] == y) {
                        return ans;
                    }
                    for (int[] direction : DIRECTION) {
                        int nextX = curr[0] + direction[0];
                        int nextY = curr[1] + direction[1];
                        if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !forest.get(nextX).get(nextY).equals(0) && !visited[nextX][nextY]) {
                            visited[nextX][nextY] = true;
                            queue.add(new int[]{nextX, nextY});
                        }
                    }
                    len--;
                }
                ans++;
            }

            return -1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(6, solution.cutOffTree(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(0, 0, 4), Arrays.asList(7, 6, 5))));
            Assert.assertEquals(-1, solution.cutOffTree(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(0, 0, 0), Arrays.asList(7, 6, 5))));
            Assert.assertEquals(6, solution.cutOffTree(Arrays.asList(Arrays.asList(2, 3, 4), Arrays.asList(0, 0, 5), Arrays.asList(8, 7, 6))));
            Assert.assertEquals(6, solution.cutOffTree(Arrays.asList(Arrays.asList(2, 3, 4), Arrays.asList(0, 0, 5), Arrays.asList(8, 7, 6))));

            Assert.assertEquals(192, solution.cutOffTree(Arrays.asList(Arrays.asList(63750247, 40643210, 95516857, 89928134, 66334829, 58741187, 76532780, 45104329), Arrays.asList(3219401, 97566322, 9135413, 75944198, 93735601, 33923288, 50116695, 83660397), Arrays.asList(64460750, 53045740, 31903386, 78155821, 90848739, 38769489, 99349027, 85982891), Arrays.asList(30628785, 51077683, 70534803, 67460877, 91077770, 74197235, 5696362, 91459886), Arrays.asList(56105195, 82479378, 45937951, 52817583, 2768114, 43329099, 28189138, 21418604))));
        }

    }
}
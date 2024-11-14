package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

class SolutionTest3249 {
//现有一棵 无向 树，树中包含 n 个节点，按从 0 到 n - 1 标记。树的根节点是节点 0 。给你一个长度为 n - 1 的二维整数数组 edges，其
//中 edges[i] = [ai, bi] 表示树中节点 ai 与节点 bi 之间存在一条边。
//
// 如果一个节点的所有子节点为根的 子树 包含的节点数相同，则认为该节点是一个 好节点。
//
// 返回给定树中 好节点 的数量。
//
// 子树 指的是一个节点以及它所有后代节点构成的一棵树。
//
//
//
//
//
// 示例 1：
//
//
// 输入：edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
//
//
// 输出：7
//
// 说明：
//
// 树的所有节点都是好节点。
//
// 示例 2：
//
//
// 输入：edges = [[0,1],[1,2],[2,3],[3,4],[0,5],[1,6],[2,7],[3,8]]
//
//
// 输出：6
//
// 说明：
//
// 树中有 6 个好节点。上图中已将这些节点着色。
//
// 示例 3：
//
//
// 输入：edges = [[0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,1
//2],[10,11]]
//
//
// 输出：12
//
// 解释：
//
// 除了节点 9 以外其他所有节点都是好节点。
//
//
//
// 提示：
//
//
// 2 <= n <= 10⁵
// edges.length == n - 1
// edges[i].length == 2
// 0 <= ai, bi < n
// 输入确保 edges 总表示一棵有效的树。
//
//
// Related Topics树 | 深度优先搜索
//
// 👍 48, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int size = 0;

        public int countGoodNodes(int[][] edges) {
            size = 0;
            Map<Integer, List<Integer>> childMap = new HashMap<>();
            for (int[] edge : edges) {
                int x = edge[0];
                int y = edge[1];
                childMap.computeIfAbsent(x, i -> new ArrayList<>()).add(y);
                childMap.computeIfAbsent(y, i -> new ArrayList<>()).add(x);
            }
            dfs(childMap, 0, -1);
            return size;
        }

        private int dfs(Map<Integer, List<Integer>> childMap, int curr, int parent) {
            int count = 0;
            int sum = 0;
            boolean valid = true;
            for (Integer child : childMap.get(curr)) {
                if (child != parent) {
                    int cnt = dfs(childMap, child, curr);
                    sum += cnt;
                    if (count == 0) {
                        count = cnt;
                    } else if (count != cnt) {
                        valid = false;
                    }
                }
            }
            if (valid) {
                size++;
            }
            return sum + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void testAllNodesGood() {
            int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
            assertEquals(7, solution.countGoodNodes(edges));
        }

        @Test
        public void testSomeNodesGood() {
            int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 5}, {1, 6}, {2, 7}, {3, 8}};
            assertEquals(6, solution.countGoodNodes(edges));
        }

        @Test
        public void testMostNodesGood() {
            int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {1, 4}, {0, 5}, {5, 6}, {6, 7}, {7, 8}, {0, 9}, {9, 10}, {9, 12}, {10, 11}};
            assertEquals(12, solution.countGoodNodes(edges));
        }
    }
}

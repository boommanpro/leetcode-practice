package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class SolutionTest310 {
//树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。 
//
// 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中
// edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。 
//
// 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度
//树 。 
//
// 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。 树的 
//高度 是指根节点和叶子节点之间最长向下路径上边的数量。
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4, edges = [[1,0],[1,2],[1,3]]
//输出：[1]
//解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。 
//
// 示例 2： 
// 
// 
//输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//输出：[3,4]
// 
//
// 
//
// 
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10⁴ 
// edges.length == n - 1 
// 0 <= ai, bi < n 
// ai != bi 
// 所有 (ai, bi) 互不相同 
// 给定的输入 保证 是一棵树，并且 不会有重复的边 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 724 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            Map<Integer, List<Integer>> linkTable = new HashMap<>();
            for (int i = 0; i < n; i++) {
                linkTable.put(i, new ArrayList<>());
            }
            for (int[] edge : edges) {
                linkTable.get(edge[0]).add(edge[1]);
                linkTable.get(edge[1]).add(edge[0]);
            }
            int[] parent = new int[n];
            Arrays.fill(parent, -1);
            int top = findTop(linkTable, parent, 0);
            int tail = findTop(linkTable, parent, top);
            List<Integer> path = new ArrayList<>();
            parent[top] = -1;
            while (tail != -1) {
                path.add(tail);
                tail = parent[tail];
            }

            int len = path.size();
            if ((len & 1) == 1) {
                return Collections.singletonList(path.get(len / 2));
            }
            return Arrays.asList(path.get(len / 2), path.get(len / 2 - 1));
        }


        private int findTop(Map<Integer, List<Integer>> linkTable, int[] parent, int node) {
            LinkedList<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            queue.add(node);
            int tail = node;
            visited.add(node);
            while (!queue.isEmpty()) {
                Integer v = queue.poll();
                for (Integer curr : linkTable.get(v)) {
                    if (!visited.contains(curr)) {
                        visited.add(curr);
                        parent[curr] = v;
                        queue.add(curr);
                    }
                }
                tail = v;
            }
            return tail;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[1]", solution.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}).toString());
            Assert.assertEquals("[4, 3]", solution.findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}).toString());
            Assert.assertEquals("[0]", solution.findMinHeightTrees(8, new int[][]{{0, 1}, {1, 2}, {2, 3}, {0, 4}, {4, 5}, {4, 6}, {6, 7}}).toString());
        }

    }
}
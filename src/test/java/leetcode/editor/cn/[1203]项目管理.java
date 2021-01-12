package leetcode.editor.cn;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1203 {
//公司共有 n 个项目和 m 个小组，每个项目要不无人接手，要不就由 m 个小组之一负责。 
//
// group[i] 表示第 i 个项目所属的小组，如果这个项目目前无人接手，那么 group[i] 就等于 -1。（项目和小组都是从零开始编号的）小组可能存
//在没有接手任何项目的情况。 
//
// 请你帮忙按要求安排这些项目的进度，并返回排序后的项目列表： 
//
// 
// 同一小组的项目，排序后在列表中彼此相邻。 
// 项目之间存在一定的依赖关系，我们用一个列表 beforeItems 来表示，其中 beforeItems[i] 表示在进行第 i 个项目前（位于第 i 个
//项目左侧）应该完成的所有项目。 
// 
//
// 如果存在多个解决方案，只需要返回其中任意一个即可。如果没有合适的解决方案，就请返回一个 空列表 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[
//3,6],[],[],[]]
//输出：[6,3,4,1,5,2,0,7]
// 
//
// 示例 2： 
//
// 
//输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[
//3],[],[4],[]]
//输出：[]
//解释：与示例 1 大致相同，但是在排序后的列表中，4 必须放在 6 的前面。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m <= n <= 3 * 104 
// group.length == beforeItems.length == n 
// -1 <= group[i] <= m - 1 
// 0 <= beforeItems[i].length <= n - 1 
// 0 <= beforeItems[i][j] <= n - 1 
// i != beforeItems[i][j] 
// beforeItems[i] 不含重复元素 
// 
// Related Topics 深度优先搜索 图 拓扑排序 
// 👍 57 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
            int N = m + n;
            int[] groupDegree = new int[N];
            int[] itemDegree = new int[n];
            List<Integer> groupIds = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                groupIds.add(i);
            }
            List<List<Integer>> groupItems = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                groupItems.add(new ArrayList<>());
            }
            List<List<Integer>> groupGraph = new ArrayList<>();
            List<List<Integer>> itemGraph = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                groupGraph.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                itemGraph.add(new ArrayList<>());
            }

            // allocation item to vir group
            int leftId = m;
            for (int i = 0; i < n; i++) {
                if (group[i] == -1) {
                    group[i] = leftId++;
                }
                groupItems.get(group[i]).add(i);
            }

            for (int i = 0; i < n; i++) {
                int currGroupId = group[i];
                for (int beforeItem : beforeItems.get(i)) {
                    int beforeGroup = group[beforeItem];
                    if (beforeGroup == currGroupId) {
                        itemDegree[i]++;
                        itemGraph.get(beforeItem).add(i);
                    } else {
                        groupDegree[currGroupId]++;
                        groupGraph.get(beforeGroup).add(currGroupId);
                    }
                }
            }

            List<Integer> groupTopSort = topSort(groupDegree, groupGraph, groupIds);
            if (groupTopSort.isEmpty()) {
                return new int[]{};
            }
            int[] ans = new int[n];
            int idx = 0;
            for (int groupId : groupTopSort) {
                List<Integer> items = groupItems.get(groupId);
                if (items.isEmpty()) {
                    continue;
                }
                List<Integer> itemsTopSort = topSort(itemDegree, itemGraph, items);
                if (itemsTopSort.isEmpty()) {
                    return new int[]{};
                }
                for (Integer item : itemsTopSort) {
                    ans[idx++] = item;
                }
            }
            return ans;
        }

        public List<Integer> topSort(int[] degree, List<List<Integer>> graph, List<Integer> items) {
            List<Integer> ans = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            for (Integer item : items) {
                if (degree[item] == 0) {
                    queue.offer(item);
                }
            }
            while (!queue.isEmpty()) {
                Integer u = queue.poll();
                ans.add(u);
                for (Integer v : graph.get(u)) {
                    if (--degree[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
            return ans.size() == items.size() ? ans : new ArrayList<>();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[6, 3, 4, 5, 2, 0, 7, 1]",
                    Arrays.toString(solution.sortItems(8, 2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1},
                            Arrays.asList(Collections.emptyList(), Collections.singletonList(6), Collections.singletonList(5),
                                    Collections.singletonList(6), Arrays.asList(3, 6), Collections.emptyList(),
                                    Collections.emptyList(), Collections.emptyList())))
            );

            Assert.assertEquals("[]",
                    Arrays.toString(solution.sortItems(8, 2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1},
                            Arrays.asList(Collections.emptyList(), Collections.singletonList(6), Collections.singletonList(5),
                                    Collections.singletonList(6), Collections.singletonList(3), Collections.emptyList(),
                                    Collections.singletonList(4), Collections.emptyList())))
            );
        }
    }
}
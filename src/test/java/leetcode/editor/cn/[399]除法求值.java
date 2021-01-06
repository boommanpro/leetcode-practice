package leetcode.editor.cn;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest399 {
//给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values
//[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。 
//
// 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj =
// ? 的结果作为答案。 
//
// 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。 
//
// 
//
// 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
//,["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//条件：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// 示例 2： 
//
// 
//输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], quer
//ies = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
// 
//
// 示例 3： 
//
// 
//输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a
//","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj 由小写英文字母与数字组成 
// 
// Related Topics 并查集 图 
// 👍 309 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Integer, Integer> parents;

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

            int max = equations.size() * 2;
            UnionFind unionFind = new UnionFind(max);
            Map<String, Integer> dict = new HashMap<>();
            int count = 0;
            for (int i = 0; i < equations.size(); i++) {
                List<String> equation = equations.get(i);
                String t0 = equation.get(0);
                String t1 = equation.get(1);
                if (!dict.containsKey(t0)) {
                    dict.put(t0, count++);
                }
                if (!dict.containsKey(t1)) {
                    dict.put(t1, count++);
                }
                unionFind.union(dict.get(t0), dict.get(t1), values[i]);
            }

            double[] ans = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                List<String> query = queries.get(i);
                Integer t0 = dict.get(query.get(0));
                Integer t1 = dict.get(query.get(1));
                if (t0 == null || t1 == null) {
                    ans[i] = -1.0;
                    continue;
                }
                ans[i] = unionFind.isConnected(t0, t1);
            }
            return ans;

        }

        public class UnionFind {

            int[] parent;

            double[] weight;

            public UnionFind(int n) {
                parent = new int[n];
                weight = new double[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    weight[i] = 1.0;
                }
            }

            public void union(int x, int y, double value) {
                int px = find(x);
                int py = find(y);
                if (px == py) {
                    return;
                }
                parent[px] = parent[py];
                weight[px] = weight[y] * value / weight[x];
            }

            private int find(int x) {
                if (x != parent[x]) {
                    int origin = parent[x];
                    parent[x] = find(parent[x]);
                    weight[x] *= weight[origin];
                }
                return parent[x];
            }

            public double isConnected(int x, int y) {
                int px = find(x);
                int py = find(y);
                if (px == py) {
                    return weight[x] / weight[y];
                }
                return -1.0;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();

            Assert.assertEquals("[6.0]", Arrays.toString(solution.calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")), new double[]{2.0, 3.0},
                    Arrays.asList(
                            Arrays.asList("a", "c")
                    ))));

            Assert.assertEquals("[6.0, 0.5, -1.0, 1.0, -1.0]", Arrays.toString(solution.calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")), new double[]{2.0, 3.0},
                    Arrays.asList(
                            Arrays.asList("a", "c"),
                            Arrays.asList("b", "a"),
                            Arrays.asList("a", "e"),
                            Arrays.asList("a", "a"),
                            Arrays.asList("x", "x")
                    ))));

            Assert.assertEquals("[3.75, 0.4, 5.0, 0.2]", Arrays.toString(solution.calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"), Arrays.asList("bc", "cd")), new double[]{1.5, 2.5, 5.0},
                    Arrays.asList(
                            Arrays.asList("a", "c"),
                            Arrays.asList("c", "b"),
                            Arrays.asList("bc", "cd"),
                            Arrays.asList("cd", "bc")
                    ))));

            Assert.assertEquals("[0.5, 2.0, -1.0, -1.0]", Arrays.toString(solution.calcEquation(Collections.singletonList(Arrays.asList("a", "b")), new double[]{0.5},
                    Arrays.asList(
                            Arrays.asList("a", "b"),
                            Arrays.asList("b", "a"),
                            Arrays.asList("a", "c"),
                            Arrays.asList("x", "y")
                    ))));

            Assert.assertEquals("[360.0, 0.008333333333333333, 20.0, 1.0, -1.0, -1.0]", Arrays.toString(solution.calcEquation(Arrays.asList(
                    Arrays.asList("x1", "x2"),
                    Arrays.asList("x2", "x3"),
                    Arrays.asList("x3", "x4"),
                    Arrays.asList("x4", "x5")
                    ), new double[]{3.0, 4.0, 5.0, 6.0},
                    Arrays.asList(
                            Arrays.asList("x1", "x5"),
                            Arrays.asList("x5", "x2"),
                            Arrays.asList("x2", "x4"),
                            Arrays.asList("x2", "x2"),
                            Arrays.asList("x2", "x9"),
                            Arrays.asList("x9", "x9")
                    ))));

            Assert.assertEquals("[10.947999999999999]", Arrays.toString(solution.calcEquation(Arrays.asList(
                    Arrays.asList("a", "b"),
                    Arrays.asList("e", "f"),
                    Arrays.asList("b", "e")
                    ), new double[]{3.4, 1.4, 2.3},
                    Arrays.asList(
                            Arrays.asList("a", "f")
                    ))));

            Assert.assertEquals("[1.1333333333333333, 16.8, 1.5, 1.0, 0.05952380952380952, 2.2666666666666666, 0.4411764705882353, -1.0, -1.0]", Arrays.toString(solution.calcEquation(Arrays.asList(
                    Arrays.asList("x1", "x2"),
                    Arrays.asList("x2", "x3"),
                    Arrays.asList("x1", "x4"),
                    Arrays.asList("x2", "x5")
                    ),
                    new double[]{3.0, 0.5, 3.4, 5.6},
                    Arrays.asList(
                            Arrays.asList("x2", "x4"),
                            Arrays.asList("x1", "x5"),
                            Arrays.asList("x1", "x3"),
                            Arrays.asList("x5", "x5"),
                            Arrays.asList("x5", "x1"),
                            Arrays.asList("x3", "x4"),
                            Arrays.asList("x4", "x3"),
                            Arrays.asList("x6", "x6"),
                            Arrays.asList("x0", "x0")

                    ))));


        }
    }
}
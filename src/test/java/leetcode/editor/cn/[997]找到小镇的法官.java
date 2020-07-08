package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest997 {
//在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。 
//
// 如果小镇的法官真的存在，那么： 
//
// 
// 小镇的法官不相信任何人。 
// 每个人（除了小镇法官外）都信任小镇的法官。 
// 只有一个人同时满足属性 1 和属性 2 。 
// 
//
// 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。 
//
// 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入：N = 2, trust = [[1,2]]
//输出：2
// 
//
// 示例 2： 
//
// 输入：N = 3, trust = [[1,3],[2,3]]
//输出：3
// 
//
// 示例 3： 
//
// 输入：N = 3, trust = [[1,3],[2,3],[3,1]]
//输出：-1
// 
//
// 示例 4： 
//
// 输入：N = 3, trust = [[1,2],[2,3]]
//输出：-1
// 
//
// 示例 5： 
//
// 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
//输出：3 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 1000 
// trust.length <= 10000 
// trust[i] 是完全不同的 
// trust[i][0] != trust[i][1] 
// 1 <= trust[i][0], trust[i][1] <= N 
// 
// Related Topics 图 
// 👍 70 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findJudge(int N, int[][] trust) {
            if (N == 1 && trust.length == 0) {
                return 1;
            }
            Set<Integer> persons = new HashSet<>();
            HashMap<Integer, Set<Integer>> trustMap = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                persons.add(i);
            }
            int m = trust.length;
            for (int i = 0; i < m; i++) {
                int from = trust[i][0];
                int to = trust[i][1];
                persons.remove(from);
                trustMap.remove(from);
                if (persons.contains(to)) {
                    Set<Integer> temps = trustMap.getOrDefault(to, new HashSet<>());
                    temps.add(from);
                    trustMap.put(to, temps);
                }
            }
            if (persons.isEmpty()) {
                return -1;
            }
            if (trustMap.isEmpty()) {
                return -1;
            }
            for (Map.Entry<Integer, Set<Integer>> entry : trustMap.entrySet()) {
                if (entry.getValue().size() == N - 1) {
                    return entry.getKey();
                }
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
            Assert.assertEquals(2, solution.findJudge(2, new int[][]{{1, 2}}));
            Assert.assertEquals(3, solution.findJudge(3, new int[][]{{1, 3}, {2, 3}}));
            Assert.assertEquals(-1, solution.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
            Assert.assertEquals(-1, solution.findJudge(3, new int[][]{{1, 2}, {2, 3}}));
            Assert.assertEquals(3, solution.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
            Assert.assertEquals(1, solution.findJudge(1, new int[][]{}));
        }
    }
}
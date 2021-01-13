package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1654 {
//有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。 
//
// 跳蚤跳跃的规则如下： 
//
// 
// 它可以 往前 跳恰好 a 个位置（即往右跳）。 
// 它可以 往后 跳恰好 b 个位置（即往左跳）。 
// 它不能 连续 往后跳 2 次。 
// 它不能跳到任何 forbidden 数组中的位置。 
// 
//
// 跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。 
//
// 给你一个整数数组 forbidden ，其中 forbidden[i] 是跳蚤不能跳到的位置，同时给你整数 a， b 和 x ，请你返回跳蚤到家的最少跳跃
//次数。如果没有恰好到达 x 的可行方案，请你返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
//输出：3
//解释：往前跳 3 次（0 -> 3 -> 6 -> 9），跳蚤就到家了。
// 
//
// 示例 2： 
//
// 
//输入：forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
//输出：2
//解释：往前跳一次（0 -> 16），然后往回跳一次（16 -> 7），跳蚤就到家了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= forbidden.length <= 1000 
// 1 <= a, b, forbidden[i] <= 2000 
// 0 <= x <= 2000 
// forbidden 中所有位置互不相同。 
// 位置 x 不在 forbidden 中。 
// 
// Related Topics 广度优先搜索 动态规划 
// 👍 12 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimumJumps(int[] forbidden, int a, int b, int x) {
            Set<Integer> forbiddenSet = Arrays.stream(forbidden).boxed().collect(Collectors.toSet());
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 1, 0});
            Set<Integer> visited = new HashSet<>();
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int currPosition = curr[0];
                if (currPosition == x) {
                    return curr[2];
                }
                if (visited.contains(currPosition)) {
                    continue;
                }
                visited.add(currPosition);
                if (curr[1] == 1 && currPosition - b > 0 && !forbiddenSet.contains(currPosition - b)) {
                    queue.add(new int[]{currPosition - b, -1, curr[2] + 1});
                }
                if (!forbiddenSet.contains(currPosition + a) && currPosition + a <= 6000) {
                    queue.add(new int[]{currPosition + a, 1, curr[2] + 1});
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
            Assert.assertEquals(3, solution.minimumJumps(new int[]{14, 4, 18, 1, 15}, 3, 15, 9));
            Assert.assertEquals(-1, solution.minimumJumps(new int[]{8, 3, 16, 6, 12, 20}, 15, 13, 11));
            Assert.assertEquals(2, solution.minimumJumps(new int[]{1, 6, 2, 14, 5, 17, 4}, 16, 9, 7));
            Assert.assertEquals(3998, solution.minimumJumps(new int[]{1998}, 1999, 2000, 2000));
        }
    }
}
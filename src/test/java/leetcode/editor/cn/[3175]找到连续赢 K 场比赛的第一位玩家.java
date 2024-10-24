package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest3175 {
//有 n 位玩家在进行比赛，玩家编号依次为 0 到 n - 1 。
//
// 给你一个长度为 n 的整数数组 skills 和一个 正 整数 k ，其中 skills[i] 是第 i 位玩家的技能等级。skills 中所有整数 互不
//相同 。
//
// 所有玩家从编号 0 到 n - 1 排成一列。
//
// 比赛进行方式如下：
//
//
// 队列中最前面两名玩家进行一场比赛，技能等级 更高 的玩家胜出。
// 比赛后，获胜者保持在队列的开头，而失败者排到队列的末尾。
//
//
// 这个比赛的赢家是 第一位连续 赢下 k 场比赛的玩家。
//
// 请你返回这个比赛的赢家编号。
//
//
//
// 示例 1：
//
//
// 输入：skills = [4,2,6,3,9], k = 2
//
//
// 输出：2
//
// 解释：
//
// 一开始，队列里的玩家为 [0,1,2,3,4] 。比赛过程如下：
//
//
// 玩家 0 和 1 进行一场比赛，玩家 0 的技能等级高于玩家 1 ，玩家 0 胜出，队列变为 [0,2,3,4,1] 。
// 玩家 0 和 2 进行一场比赛，玩家 2 的技能等级高于玩家 0 ，玩家 2 胜出，队列变为 [2,3,4,1,0] 。
// 玩家 2 和 3 进行一场比赛，玩家 2 的技能等级高于玩家 3 ，玩家 2 胜出，队列变为 [2,4,1,0,3] 。
//
//
// 玩家 2 连续赢了 k = 2 场比赛，所以赢家是玩家 2 。
//
// 示例 2：
//
//
// 输入：skills = [2,5,4], k = 3
//
//
// 输出：1
//
// 解释：
//
// 一开始，队列里的玩家为 [0,1,2] 。比赛过程如下：
//
//
// 玩家 0 和 1 进行一场比赛，玩家 1 的技能等级高于玩家 0 ，玩家 1 胜出，队列变为 [1,2,0] 。
// 玩家 1 和 2 进行一场比赛，玩家 1 的技能等级高于玩家 2 ，玩家 1 胜出，队列变为 [1,0,2] 。
// 玩家 1 和 0 进行一场比赛，玩家 1 的技能等级高于玩家 0 ，玩家 1 胜出，队列变为 [1,2,0] 。
//
//
// 玩家 1 连续赢了 k = 3 场比赛，所以赢家是玩家 1 。
//
//
//
// 提示：
//
//
// n == skills.length
// 2 <= n <= 10⁵
// 1 <= k <= 10⁹
// 1 <= skills[i] <= 10⁶
// skills 中的整数互不相同。
//
//
// Related Topics数组 | 模拟
//
// 👍 41, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findWinningPlayer(int[] skills, int k) {
            int n = skills.length;
            int max = 0;
            int len = 0;
            for (int i = 1; i < n && len < k; i++) {
                if (skills[i] > skills[max]) {
                    max = i;
                    len = 0;
                }
                len++;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

        @Test
        public void testExample1() {
            int[] skills = {4, 2, 6, 3, 9};
            int k = 2;
            assertEquals(2, solution.findWinningPlayer(skills, k));
        }

        @Test
        public void testExample2() {
            int[] skills = {2, 5, 4};
            int k = 3;
            assertEquals(1, solution.findWinningPlayer(skills, k));
        }
    }
}

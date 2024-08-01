package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class SolutionTestLCP40 {
//「力扣挑战赛」心算项目的挑战比赛中，要求选手从 `N` 张卡牌中选出 `cnt` 张卡牌，若这 `cnt` 张卡牌数字总和为偶数，则选手成绩「有效」且得分为
// `cnt` 张卡牌数字总和。
//给定数组 `cards` 和 `cnt`，其中 `cards[i]` 表示第 `i` 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分
//的卡牌方案，则返回 0。
//
//**示例 1：**
//
//> 输入：`cards = [1,2,8,9], cnt = 3`
//>
//> 输出：`18`
//>
//> 解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
//
//**示例 2：**
//
//> 输入：`cards = [3,3,1], cnt = 1`
//>
//> 输出：`0`
//>
//> 解释：不存在获取有效得分的卡牌方案。
//
//**提示：**
//- `1 <= cnt <= cards.length <= 10^5`
//- `1 <= cards[i] <= 1000`
//
// Related Topics贪心 | 数组 | 排序
//
// 👍 108, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxmiumScore(int[] cards, int cnt) {
            int n = cards.length;
            Arrays.sort(cards);
            int sum = 0;
            int[] even = new int[]{-1, -1};
            int[] odd = new int[]{-1, -1};
            for (int i = n - 1; i >= 0; i--) {
                int v = cards[i];
                if (i >= n - cnt) {
                    sum += v;
                    if (v % 2 == 0) {
                        even[0] = v;
                    } else {
                        odd[0] = v;
                    }
                } else {
                    if (v % 2 == 0) {
                        even[1] = Math.max(v,even[1]);
                    } else {
                        odd[1] = Math.max(v,odd[1]);
                    }
                }
            }
            if (sum % 2 == 0) {
                return sum;
            }
            int ans = 0;
            if (even[0] != -1 && odd[1] != -1) {
                ans = sum - even[0] + odd[1];
            }
            if (even[1] != -1 && odd[0] != -1) {
                ans = Math.max(ans, sum + even[1] - odd[0]);
            }
            return ans;
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
        public void testMaxmiumScoreExample1() {
            int[] cards = {1, 2, 8, 9};
            int cnt = 3;
            int expected = 18;
            int result = solution.maxmiumScore(cards, cnt);
            assertEquals(expected, result);
        }

        @Test
        public void testMaxmiumScoreExample2() {
            int[] cards = {3, 3, 1};
            int cnt = 1;
            int expected = 0;
            int result = solution.maxmiumScore(cards, cnt);
            assertEquals(expected, result);
        }

        @Test
        public void testMaxmiumScoreExample3() {
            int[] cards = {7, 4, 1};
            int cnt = 1;
            int expected = 4;
            int result = solution.maxmiumScore(cards, cnt);
            assertEquals(expected, result);
        }

        @Test
        public void testMaxmiumScoreExample4() {
            int[] cards = {7,6,4,6};
            int cnt = 1;
            int expected = 6;
            int result = solution.maxmiumScore(cards, cnt);
            assertEquals(expected, result);
        }
    }
}

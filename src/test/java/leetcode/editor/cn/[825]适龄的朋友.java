package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest825 {
//在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
//
// 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
//
//
// ages[y] <= 0.5 * ages[x] + 7
// ages[y] > ages[x]
// ages[y] > 100 && ages[x] < 100
//
//
// 否则，x 将会向 y 发送一条好友请求。
//
// 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
//
// 返回在该社交媒体网站上产生的好友请求总数。
//
//
//
// 示例 1：
//
//
//输入：ages = [16,16]
//输出：2
//解释：2 人互发好友请求。
//
//
// 示例 2：
//
//
//输入：ages = [16,17,18]
//输出：2
//解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
//
//
// 示例 3：
//
//
//输入：ages = [20,30,100,110,120]
//输出：3
//解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
//
//
//
//
// 提示：
//
//
// n == ages.length
// 1 <= n <= 2 * 10⁴
// 1 <= ages[i] <= 120
//
//
// Related Topics数组 | 双指针 | 二分查找 | 排序
//
// 👍 232, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numFriendRequests(int[] ages) {
            int[] person = new int[121];
            for (int age : ages) {
                person[age]++;
            }
            int max = 121;
            int sum = 0;
            for (int i = 1; i < max; i++) {
                for (int j = 1; j < max; j++) {
                    if (check(i, j)) {
                        if (i == j) {
                            sum += (person[i] * (person[i] - 1));
                        } else {
                            sum += person[i] * person[j];
                        }
                    }
                }
            }
            return sum;
        }

        private boolean check(int x, int y) {
            if (y <= 0.5 * x + 7) {
                return false;
            }
            if (y > x) {
                return false;
            }
            if (y > 100 && x < 100) {
                return false;
            }
            return true;
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
        public void testBasicFunctionality() {
            int[] ages = {16, 16};
            assertEquals(2, solution.numFriendRequests(ages));
        }

        @Test
        public void testDifferentAgeRanges() {
            int[] ages = {16, 17, 18};
            assertEquals(2, solution.numFriendRequests(ages));
        }

        @Test
        public void testAgesCrossing100() {
            int[] ages = {20, 30, 100, 110, 120};
            assertEquals(3, solution.numFriendRequests(ages));
        }
    }
}

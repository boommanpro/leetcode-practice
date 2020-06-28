package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest374 {
//我们正在玩一个猜数字游戏。 游戏规则如下： 
//我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。 
//每次你猜错了，我会告诉你这个数字是大了还是小了。 
//你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）： 
//
// -1 : 我的数字比较小
// 1 : 我的数字比较大
// 0 : 恭喜！你猜对了！
// 
//
// 
//
// 示例 : 
//
// 输入: n = 10, pick = 6
//输出: 6 
// Related Topics 二分查找

    static
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return         -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */


    public class Solution extends GuessGame {

        public int guessNumber(int n) {
            int l = 1;
            int r = n;
            while (l <= r) {
                int mid = ((r - l) >> 1) + l;
                int ans = guess(mid);
                if (ans == 0) {
                    return mid;
                }
                //说明我们的mid数太笑了
                if (ans == 1) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            //理论一定不会走到这里,因为数据在1-n之间
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    static class GuessGame {

        private int pick;

        public GuessGame() {

        }

        public void setPick(int pick) {
            this.pick = pick;
        }

        public int guess(int num) {
            if (num == pick) {
                return 0;
            }
            return pick > num ? 1 : -1;
        }
    }


    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            solution.setPick(6);
            Assert.assertEquals(6, solution.guessNumber(10));
            solution.setPick(1);
            Assert.assertEquals(1, solution.guessNumber(10));
            solution.setPick(10);
            Assert.assertEquals(10, solution.guessNumber(10));
        }
    }
}
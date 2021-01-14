package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest935 {
//国际象棋中的骑士可以按下图所示进行移动： 
//
// . 
//
// 
//这一次，我们将 “骑士” 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳 N-1 步。每一步必须是从一个数字键跳到另一个数字键。 
//
// 每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下 N 位数字。 
//
// 你能用这种方式拨出多少个不同的号码？ 
//
// 因为答案可能很大，所以输出答案模 10^9 + 7。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：1
//输出：10
// 
//
// 示例 2： 
//
// 输入：2
//输出：20
// 
//
// 示例 3： 
//
// 输入：3
//输出：46
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 5000 
// 
// Related Topics 动态规划 
// 👍 60 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int knightDialer(int n) {
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(10, solution.knightDialer(1));
            Assert.assertEquals(20, solution.knightDialer(2));
            Assert.assertEquals(46, solution.knightDialer(3));
        }
    }
}
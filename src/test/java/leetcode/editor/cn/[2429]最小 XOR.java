package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest2429 {
//给你两个正整数 num1 和 num2 ，找出满足下述条件的整数 x ： 
//
// 
// x 的置位数和 num2 相同，且 
// x XOR num1 的值 最小 
// 
//
// 注意 XOR 是按位异或运算。 
//
// 返回整数 x 。题目保证，对于生成的测试用例， x 是 唯一确定 的。 
//
// 整数的 置位数 是其二进制表示中 1 的数目。 
//
// 
//
// 示例 1： 
//
// 输入：num1 = 3, num2 = 5
//输出：3
//解释：
//num1 和 num2 的二进制表示分别是 0011 和 0101 。
//整数 3 的置位数与 num2 相同，且 3 XOR 3 = 0 是最小的。
// 
//
// 示例 2： 
//
// 输入：num1 = 1, num2 = 12
//输出：3
//解释：
//num1 和 num2 的二进制表示分别是 0001 和 1100 。
//整数 3 的置位数与 num2 相同，且 3 XOR 1 = 2 是最小的。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1, num2 <= 10⁹ 
// 
//
// Related Topics 贪心 位运算 👍 16 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimizeXor(int num1, int num2) {
            int c1 = Integer.bitCount(num1);
            int c2 = Integer.bitCount(num2);
            for (; c2 < c1; ++c2){
                num1 &= num1 - 1; // 最低的 1 变成 0
            }
            for (; c2 > c1; --c2){
                num1 |= num1 + 1; // 最低的 0 变成 1
            }
            return num1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.minimizeXor(3, 5));
            Assert.assertEquals(3, solution.minimizeXor(1, 12));
        }

    }
}
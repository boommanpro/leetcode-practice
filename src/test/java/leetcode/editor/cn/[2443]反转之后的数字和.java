package leetcode.editor.cn;

import org.junit.Test;

class SolutionTest2443 {
//给你一个 非负 整数 num 。如果存在某个 非负 整数 k 满足 k + reverse(k) = num ，则返回 true ；否则，返回 false 
//。 
//
// reverse(k) 表示 k 反转每个数位后得到的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 443
//输出：true
//解释：172 + 271 = 443 ，所以返回 true 。
// 
//
// 示例 2： 
//
// 
//输入：num = 63
//输出：false
//解释：63 不能表示为非负整数及其反转后数字之和，返回 false 。
// 
//
// 示例 3： 
//
// 
//输入：num = 181
//输出：true
//解释：140 + 041 = 181 ，所以返回 true 。注意，反转后的数字可能包含前导零。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 10⁵ 
// 
//
// Related Topics 数学 枚举 👍 6 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {

        public boolean sumOfNumberAndReverse(int num) {
            int k = 0;
            for (int i = 0; i <= num; i++) {
                if (i + reverse(i) == num) {;
                    return true;
                }
            }
            return false;
        }

        public static int reverse(int i) {
            if (i < 10) {
                return i;
            }
            return Integer.parseInt(new StringBuilder().append(i).reverse().toString());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

    }
}
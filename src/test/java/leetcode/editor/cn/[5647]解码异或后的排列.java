package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;
import weeks.Template;

import java.util.Arrays;

class SolutionTest5647 {
//给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。 
//
// 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说
//，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。 
//
// 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。 
//
// 
//
// 示例 1： 
//
// 输入：encoded = [3,1]
//输出：[1,2,3]
//解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
// 
//
// 示例 2： 
//
// 输入：encoded = [6,5,4,6]
//输出：[2,4,1,5,3]
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n < 105 
// n 是奇数。 
// encoded.length == n - 1 
// 
// Related Topics 位运算 
// 👍 5 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] decode(int[] encoded) {
            int n = encoded.length + 1;
            int allXor = 0;
            for (int i = 1; i <= n; i++) {
                allXor ^= i;
            }
            int suffix = encoded[1];
            for (int i = 3; i < encoded.length; i += 2) {
                suffix ^= encoded[i];
            }
            int first = suffix ^ allXor;
            int[] ans = new int[n];
            ans[0] = first;
            calc(ans, encoded);
            return ans;
        }

        private void calc(int[] ans, int[] encoded) {
            for (int i = 0; i < encoded.length; i++) {
                ans[i + 1] = ans[i] ^ encoded[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[1, 2, 3]", Arrays.toString(solution.decode(new int[]{3, 1})));
            Assert.assertEquals("[2, 4, 1, 5, 3]", Arrays.toString(solution.decode(new int[]{6, 5, 4, 6})));
            Assert.assertEquals("[7, 4, 8, 9, 6, 3, 1, 2, 5]", Arrays.toString(solution.decode(new int[]{3, 12, 1, 15, 5, 2, 3, 7})));
            Assert.assertEquals("[6, 4, 2, 1, 5, 3, 7, 8, 9]", Arrays.toString(solution.decode(new int[]{2, 6, 3, 4, 6, 4, 15, 1})));
        }
    }
}
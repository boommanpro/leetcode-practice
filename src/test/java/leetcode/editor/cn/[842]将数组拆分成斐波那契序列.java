package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest842 {
//给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。 
//
// 形式上，斐波那契式序列是一个非负整数列表 F，且满足： 
//
// 
// 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）； 
// F.length >= 3； 
// 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。 
// 
//
// 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。 
//
// 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。 
//
// 
//
// 示例 1： 
//
// 输入："123456579"
//输出：[123,456,579]
// 
//
// 示例 2： 
//
// 输入: "11235813"
//输出: [1,1,2,3,5,8,13]
// 
//
// 示例 3： 
//
// 输入: "112358130"
//输出: []
//解释: 这项任务无法完成。
// 
//
// 示例 4： 
//
// 输入："0123"
//输出：[]
//解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
// 
//
// 示例 5： 
//
// 输入: "1101111"
//输出: [110, 1, 111]
//解释: 输出 [11,0,11,11] 也同样被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 字符串 S 中只含有数字。 
// 
// Related Topics 贪心算法 字符串 回溯算法 
// 👍 135 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> splitIntoFibonacci(String S) {
            List<Integer> ans = new ArrayList<>();
            backTracking(S, S.length(), ans, 0, 0, 0);
            return ans;
        }

        private boolean backTracking(String S, int len, List<Integer> ans, int index, int prev, int sum) {
            if (len == index) {
                return ans.size() >= 3;
            }
            long currLong = 0;
            for (int i = index; i < len; i++) {
                if (i > index && S.charAt(index) == '0') {
                    return false;
                }
                currLong = currLong * 10 + S.charAt(i) - '0';
                if (currLong > Integer.MAX_VALUE) {
                    return false;
                }
                int curr = (int) currLong;
                if (ans.size() >= 2) {
                    if (curr < sum) {
                        continue;
                    }
                    if (curr > sum) {
                        return false;
                    }
                }
                ans.add(curr);
                if (backTracking(S, len, ans, i + 1, curr, curr + prev)) {
                    return true;
                } else {
                    ans.remove(ans.size() - 1);
                }
            }
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[123, 456, 579]", solution.splitIntoFibonacci("123456579").toString());
            Assert.assertEquals("[1, 1, 2, 3, 5, 8, 13]", solution.splitIntoFibonacci("11235813").toString());
            Assert.assertEquals("[]", solution.splitIntoFibonacci("112358130").toString());
            Assert.assertEquals("[]", solution.splitIntoFibonacci("0123").toString());
            Assert.assertEquals("[11, 0, 11, 11]", solution.splitIntoFibonacci("1101111").toString());
            Assert.assertEquals("[0, 0, 0]", solution.splitIntoFibonacci("000").toString());
        }
    }
}
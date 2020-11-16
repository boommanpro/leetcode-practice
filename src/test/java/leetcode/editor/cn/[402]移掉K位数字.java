package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

class SolutionTest402 {
//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法 
// 👍 394 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            int len = num.length();
            if (len == k) {
                return "0";
            }
            Deque<Integer> queue = new LinkedList<>();
            for (char c : num.toCharArray()) {
                int v = c - '0';
                while (k > 0 && !queue.isEmpty() && queue.peekLast() > v) {
                    k--;
                    queue.pollLast();
                }
                queue.offerLast(v);
            }
            while (k > 0) {
                queue.pollLast();
                k--;
            }
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                Integer v = queue.pollFirst();
                if (sb.length() == 0 && v == 0) {
                    continue;
                }
                sb.append(v);
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("1219", solution.removeKdigits("1432219", 3));
            Assert.assertEquals("200", solution.removeKdigits("10200", 1));
            Assert.assertEquals("0", solution.removeKdigits("10", 2));
            Assert.assertEquals("1234", solution.removeKdigits("123456", 2));
            Assert.assertEquals("1224", solution.removeKdigits("12345264", 4));
        }
    }
}
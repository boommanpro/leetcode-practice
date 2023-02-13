package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest1234 {
//有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。 
//
// 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。 
//
// 
//
// 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。 
//
// 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。 
//
// 请返回待替换子串的最小可能长度。 
//
// 如果原字符串自身就是一个平衡字符串，则返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "QWER"
//输出：0
//解释：s 已经是平衡的了。 
//
// 示例 2： 
//
// 
//输入：s = "QQWE"
//输出：1
//解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
// 
//
// 示例 3： 
//
// 
//输入：s = "QQQW"
//输出：2
//解释：我们可以把前面的 "QQ" 替换成 "ER"。 
// 
//
// 示例 4： 
//
// 
//输入：s = "QQQQ"
//输出：3
//解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s.length 是 4 的倍数 
// s 中只含有 'Q', 'W', 'E', 'R' 四种字符 
// 
//
// Related Topics 字符串 滑动窗口 👍 114 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int balancedString(String s) {
            int max = s.length() / 4;
            int ans = s.length();
            int len = s.length();
            Map<Character, Integer> window = new HashMap<>();
            window.put('Q', 0);
            window.put('W', 0);
            window.put('E', 0);
            window.put('R', 0);
            s = s + s;
            for (int r = 0, l = 0; r < s.length(); r++) {
                char rc = s.charAt(r);
                window.put(rc, window.get(rc) + 1);
                while (window.get(rc) > max) {
                    char lc = s.charAt(l++);
                    window.put(lc, window.get(lc) - 1);
                }
                if (l == 0 || r == s.length() - 1 || l <= len && r >= len) {
                    ans = Math.min(ans, len - (r - l + 1));
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(0, solution.balancedString("QWER"));
            Assert.assertEquals(1, solution.balancedString("QQWE"));
            Assert.assertEquals(2, solution.balancedString("QQQW"));
            Assert.assertEquals(3, solution.balancedString("QQQQ"));
            Assert.assertEquals(4, solution.balancedString("WWQQRRRRQRQQ"));
            Assert.assertEquals(14, solution.balancedString("WEWEQQRWRRWREQWEEWEQERQWWWRERRWEWWQWQQWQEREQRQRRREQWWERRERQWWRRWRWRQRWWQWRWWWWREWWWW"));
            Assert.assertEquals(5, solution.balancedString("WWWEQRQEWWQQQWQQQWEWEEWRRRRRWWQE"));
        }

    }
}
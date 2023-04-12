package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1147 {
//你会得到一个字符串 text 。你应该把它分成 k 个子字符串 (subtext1, subtext2，…， subtextk) ，要求满足: 
//
// 
// subtexti 是 非空 字符串 
// 所有子字符串的连接等于 text ( 即subtext1 + subtext2 + ... + subtextk == text ) 
// 对于所有 i 的有效值( 即 1 <= i <= k ) ，subtexti == subtextk - i + 1 均成立 
// 
//
// 返回k可能最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：text = "ghiabcdefhelloadamhelloabcdefghi"
//输出：7
//解释：我们可以把字符串拆分成 "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"。
// 
//
// 示例 2： 
//
// 
//输入：text = "merchant"
//输出：1
//解释：我们可以把字符串拆分成 "(merchant)"。
// 
//
// 示例 3： 
//
// 
//输入：text = "antaprezatepzapreanta"
//输出：11
//解释：我们可以把字符串拆分成 "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 1000 
// text 仅由小写英文字符组成 
// 
//
// Related Topics 贪心 双指针 字符串 动态规划 哈希函数 滚动哈希 👍 127 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestDecomposition(String s) {
            int n = s.length();
            int l = 0;
            int r = n - 1;
            int ans = 0;
            while (l <= r) {
                int len = 1;
                while (!judge(s, l, r, len)) {
                    len++;
                }
                if (l + len - 1 <= r - len) {
                    ans += 2;
                } else {
                    ans++;
                }
                l += len;
                r -= len;
            }
            return ans;
        }

        private boolean judge(String s, int l, int r, int len) {
            for (int i = 0; i < len; i++) {
                if (s.charAt(l + i) != s.charAt(r - len + i + 1)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(7, solution.longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
            Assert.assertEquals(1, solution.longestDecomposition("merchant"));
            Assert.assertEquals(11, solution.longestDecomposition("antaprezatepzapreanta"));
            Assert.assertEquals(3, solution.longestDecomposition("aaa"));
            Assert.assertEquals(2, solution.longestDecomposition("elvtoelvto"));
            Assert.assertEquals(3, solution.longestDecomposition("aaa"));

        }

    }
}
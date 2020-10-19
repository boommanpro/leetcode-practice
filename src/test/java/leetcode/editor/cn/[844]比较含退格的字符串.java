package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest844 {
//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// 
// Related Topics 栈 双指针 
// 👍 183 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            char[] sChars = S.toCharArray();
            char[] tChars = T.toCharArray();
            int p = 0;
            int len = sChars.length;
            for (int i = 0; i < len; i++) {
                if (sChars[i] == '#') {
                     p = Math.max(--p, 0);
                    continue;
                }
                sChars[p++] = sChars[i];
            }
            int q = 0;
            len = tChars.length;
            for (int i = 0; i < len; i++) {
                if (tChars[i] == '#') {
                    q = Math.max(--q, 0);
                    continue;
                }
                tChars[q++] = tChars[i];
            }
            return compareCharsPrefix(sChars, tChars, p, q);
        }

        private boolean compareCharsPrefix(char[] sChars, char[] tChars, int p, int q) {
            if (p != q) {
                return false;
            }
            for (int i = 0; i < p; i++) {
                if (sChars[i] != tChars[i]) {
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
            Assert.assertTrue(solution.backspaceCompare("ab#c", "ad#c"));
            Assert.assertTrue(solution.backspaceCompare("ab##", "c#d#"));
            Assert.assertTrue(solution.backspaceCompare("a##c", "#a#c"));
            Assert.assertFalse(solution.backspaceCompare("a#c", "b"));
            Assert.assertTrue(solution.backspaceCompare("xywrrmp", "xywrrmu#p"));
        }
    }
}
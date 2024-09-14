package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

class SolutionTest2390 {
//给你一个包含若干星号 * 的字符串 s 。
//
// 在一步操作中，你可以：
//
//
// 选中 s 中的一个星号。
// 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
//
//
// 返回移除 所有 星号之后的字符串。
//
// 注意：
//
//
// 生成的输入保证总是可以执行题面中描述的操作。
// 可以证明结果字符串是唯一的。
//
//
//
//
// 示例 1：
//
//
//输入：s = "leet**cod*e"
//输出："lecoe"
//解释：从左到右执行移除操作：
//- 距离第 1 个星号最近的字符是 "leet**cod*e" 中的 't' ，s 变为 "lee*cod*e" 。
//- 距离第 2 个星号最近的字符是 "lee*cod*e" 中的 'e' ，s 变为 "lecod*e" 。
//- 距离第 3 个星号最近的字符是 "lecod*e" 中的 'd' ，s 变为 "lecoe" 。
//不存在其他星号，返回 "lecoe" 。
//
// 示例 2：
//
//
//输入：s = "erase*****"
//输出：""
//解释：整个字符串都会被移除，所以返回空字符串。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s 由小写英文字母和星号 * 组成
// s 可以执行上述操作
//
//
// Related Topics栈 | 字符串 | 模拟
//
// 👍 72, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeStars(String s) {
            LinkedList<Character> queue = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c == '*') {
                    if (!queue.isEmpty()) {
                        queue.pollLast();
                    }
                } else {
                    queue.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : queue) {
                sb.append(c);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

        @Test
        public void testRemoveStars() {
            // 测试用例 1
            String input1 = "leet**cod*e";
            String expectedOutput1 = "lecoe";
            Assert.assertEquals(expectedOutput1, solution.removeStars(input1));

            // 测试用例 2
            String input2 = "erase*****";
            String expectedOutput2 = "";
            Assert.assertEquals(expectedOutput2, solution.removeStars(input2));

            // 测试用例 3
            String input3 = "a*b*c*";
            String expectedOutput3 = "";
            Assert.assertEquals(expectedOutput3, solution.removeStars(input3));
        }
    }
}

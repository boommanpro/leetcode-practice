package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题01_05 {
//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 字符串 动态规划

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean oneEditAway(String first, String second) {
            //判断是否仅需要一次编辑,即允许一次跳过
            if (first == null && second == null) {
                return true;
            }
            first = first == null ? "" : first;
            second = second == null ? "" : second;

            int m = first.length();
            int n = second.length();
            //先判断长度是否一致
            if (Math.abs(n - m) > 1) {
                return false;
            }
            if (m > n) {
                String temp = first;
                first = second;
                second = temp;
                int t = m;
                m = n;
                n = t;
            }
            //获取最小长度
            int i = 0;
            int j = 0;
            while (i < m) {
                if (first.charAt(i) != second.charAt(j)) {
                    break;
                }
                i++;
                j++;
            }
            if (m == n) {
                return isEqual(first, second, i + 1, j + 1, m, n);
            }
            return isEqual(first, second, i, j + 1, m, n);
        }

        private boolean isEqual(String first, String second, int i, int j, int m, int n) {
            while (i < m && j < n) {
                if (first.charAt(i) != second.charAt(j)) {
                    return false;
                }
                i++;
                j++;
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
            Assert.assertTrue(solution.oneEditAway("pale", "ple"));
            Assert.assertFalse(solution.oneEditAway("pales", "pal"));
            Assert.assertTrue(solution.oneEditAway("b", ""));
            Assert.assertTrue(solution.oneEditAway("a", "b"));
            Assert.assertTrue(solution.oneEditAway("ab", "bb"));
            Assert.assertTrue(solution.oneEditAway("ba", "bb"));
            Assert.assertTrue(solution.oneEditAway("ba", "cba"));
            Assert.assertFalse(solution.oneEditAway("teacher", "leachers"));
        }
    }
}
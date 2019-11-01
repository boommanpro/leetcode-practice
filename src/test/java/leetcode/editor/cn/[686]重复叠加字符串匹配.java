package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest686 {

    //给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
//
// 举个例子，A = "abcd"，B = "cdabcdab"。 
//
// 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。 
//
// 注意: 
//
// A 与 B 字符串的长度在1和10000区间范围内。 
// Related Topics 字符串
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 话说官方题解的描述看起来有些复杂而且不够直观，其他题解大多也都提到了关键是要找到终止长度即B.length + A.length * 2，我尝试说明一下原因。
         * 在B的长度大于A长度时且能够满足题意A叠加后B成为其子串的，总共只有四种情况
         * 叠加n个A后刚好与B完全相等，例如A = 'ab', B = 'abab'，此时刚好只需要循环n次即可满足条件，循环更多次也只是重复无用功
         * 叠加n个A后与B的后部分完全相等，但此时B头部还有一小部分值刚好是A尾部分，例如A = 'ab', b = 'babab'，此时最少需要循环n + 1次才可满足条件
         * 同上一条，但多余部分出现在B的尾部，例如A = 'ab', b = 'ababa'，此时最少需要的循环次数同上
         * 同上，多余部分在B的头尾都有，例如A = 'ab', b = 'bababa'，此时最少需要的循环次数为n + 2次
         * 由上面的所有情况分析得到最少需要循环的次数为n + 2次，n为正整数，转化为最小需要的长度S就是S >= (n + 2) * A.length，因为n = B.length / A.length，所以S >= B.length + A.length * 2
         */
        public int repeatedStringMatch(String A, String B) {
            int endLen = B.length() + A.length() * 2;
            int count = 1;
            StringBuilder repeatA = new StringBuilder(A);

            while (repeatA.length() <= endLen) {
                if (repeatA.indexOf(B) != -1) {
                    return count;
                }
                count++;
                repeatA.append(A);

            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.repeatedStringMatch("abcd", "cdabcdab"));
        }
    }
}
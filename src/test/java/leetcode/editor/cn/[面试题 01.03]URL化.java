package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题01_03 {
//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，
//请使用字符数组实现，以便直接在数组上操作。） 
//
// 示例1: 
//
//  输入："Mr John Smith    ", 13
// 输出："Mr%20John%20Smith"
// 
//
// 示例2: 
//
//  输入："               ", 5
// 输出："%20%20%20%20%20"
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 500000]范围内。 
// 
// Related Topics 字符串

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String replaceSpaces(String S, int length) {
            return replaceSpaces(S.toCharArray(), length);
        }

        public String replaceSpaces(char[] chars, int length) {
            int n = chars.length;
            int l = length - 1;
            int r = n - 1;
            while (l < r && l >= 0) {
                if (chars[l] != ' ') {
                    chars[r--] = chars[l];
                } else {
                    chars[r--] = '0';
                    chars[r--] = '2';
                    chars[r--] = '%';
                }
                l--;
            }
            if (l == r) {
                return new String(chars);
            }
            int offset = r + 1;
            return new String(chars, offset, n - offset);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("Mr%20John%20Smith", solution.replaceSpaces("Mr John Smith    ", 13));
            Assert.assertEquals("%20%20%20%20%20", solution.replaceSpaces("               ", 5));
            Assert.assertEquals("ds%20sdfs%20afs%20sdfa%20dfssf%20asdf", solution.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27));
            Assert.assertEquals("ds%20sdfs%20afs%20sdfa%20dfssf%20asdf", solution.replaceSpaces("ds sdfs afs sdfa dfssf asdf                       ", 27));
            Assert.assertEquals("ds%20s%20d%20f%20s%20afs%20sdfa%20dfssf%20asdf", solution.replaceSpaces("ds s d f s afs sdfa dfssf asdf                       ", 30));

        }
    }
}
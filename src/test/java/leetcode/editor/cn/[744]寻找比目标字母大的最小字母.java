package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest744 {
//给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。 
//
// 在比较时，字母是依序循环出现的。举个例子： 
//
// 
// 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a' 
// 
//
// 
//
// 示例： 
//
// 输入:
//letters = ['c', 'f', 'j']
//target = 'a'
//输出: 'c'
//
//输入:
//letters = ['c', 'f', 'j']
//target = 'c'
//输出: 'f'
//
//输入:
//letters = ['c', 'f', 'j']
//target = 'd'
//输出: 'f'
//
//输入:
//letters = ['c', 'f', 'j']
//target = 'g'
//输出: 'j'
//
//输入:
//letters = ['c', 'f', 'j']
//target = 'j'
//输出: 'c'
//
//输入:
//letters = ['c', 'f', 'j']
//target = 'k'
//输出: 'c'
// 
//
// 
//
// 提示： 
//
// 
// letters长度范围在[2, 10000]区间内。 
// letters 仅由小写字母组成，最少包含两个不同的字母。 
// 目标字母target 是一个小写字母。 
// 
// Related Topics 二分查找

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int n = letters.length;
            int l = 1;
            for (int r = 0; r < n - 1; r++) {
                if (letters[r] != letters[r + 1]) {
                    letters[l] = letters[r + 1];
                    l++;
                }
            }
            n = l;
            int r = n - 1;
            l = 0;
            if (n == 1 || target >= letters[r] || target < letters[l]) {
                return letters[l];
            }
            //二分查找
            while (l < r) {
                int mid = ((r - l) >> 1) + l;
                if (letters[mid] == target) {
                    return letters[mid + 1];
                }
                if (letters[mid] > target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return letters[l];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals('c', solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
            Assert.assertEquals('f', solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
            Assert.assertEquals('f', solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
            Assert.assertEquals('j', solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
            Assert.assertEquals('c', solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
            Assert.assertEquals('c', solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
            Assert.assertEquals('n', solution.nextGreatestLetter(new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'}, 'e'));
        }
    }
}
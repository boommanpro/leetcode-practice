package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest556 {
//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。 
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：21
// 
//
// 示例 2： 
//
// 
//输入：n = 21
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 双指针 字符串 👍 206 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int nextGreaterElement(int input) {
            char[] array = ("" + input).toCharArray();
            int i = array.length - 2;
            while (i >= 0 && array[i + 1] <= array[i]) {
                i--;
            }
            if (i == -1) {
                return -1;
            }
            int j = array.length - 1;
            while (j >= 0 && array[j] <= array[i]) {
                j--;
            }
            swap(array, i, j);
            reverse(array, i + 1);
            try {
                return Integer.parseInt(new String(array));
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        private void reverse(char[] array, int i) {
            int j = array.length - 1;
            while (i < j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        private void swap(char[] array, int x, int y) {
            char temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(21, solution.nextGreaterElement(12));
            Assert.assertEquals(-1, solution.nextGreaterElement(21));
            Assert.assertEquals(-1, solution.nextGreaterElement(Integer.MAX_VALUE - 1));
            Assert.assertEquals(1243, solution.nextGreaterElement(1234));
            Assert.assertEquals(158513467, solution.nextGreaterElement(158476531));
        }

    }
}
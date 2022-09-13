package leetcode.editor.cn;

import org.junit.Test;

class SolutionTest670 {
//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 351 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            String s = Integer.toString(num);
            int ans = num;
            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    swap(array, i, j);
                    ans = Math.max(ans, Integer.parseInt(new String(array)));
                    swap(array, i, j);
                }
            }
            return ans;
        }

        private void swap(char[] array, int i, int j) {
            char a = array[i];
            array[i] = array[j];
            array[j] = a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

    }
}
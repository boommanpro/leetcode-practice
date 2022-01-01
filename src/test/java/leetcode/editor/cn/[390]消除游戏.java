package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest390 {
//给定一个从1 到 n 排序的整数列表。 
//首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。 
//第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。 
//我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。 
//返回长度为 n 的列表中，最后剩下的数字。 
//
// 示例： 
//
// 
//输入:
//n = 9,
//1 2 3 4 5 6 7 8 9
//2 4 6 8
//2 6
//6
//
//输出:
//6 
// Related Topics 数学 
// 👍 140 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastRemaining(int n) {
            int min = 1;
            int max = n;
            int round = 1;
            int surplus = n;
            boolean directionLeft = true;
            while (surplus > 1) {
                if (directionLeft) {
                    min += round;
                    if (surplus % 2 != 0) {
                        max -= round;
                    }
                }
                if (!directionLeft) {
                    max -= round;
                    if (surplus % 2 != 0) {
                        min += round;
                    }
                }
                round *= 2;
                surplus /= 2;
                directionLeft = !directionLeft;
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(6, solution.lastRemaining(9));
        }

    }
}
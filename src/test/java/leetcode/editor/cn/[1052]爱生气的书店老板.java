package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1052 {
//今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分
//钟结束后离开。 
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一
//分钟的顾客就会不满意，不生气则他们是满意的。 
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。 
//
// 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。 
// 
//
// 示例： 
//
// 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//输出：16
//解释：
//书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= X <= customers.length == grumpy.length <= 20000 
// 0 <= customers[i] <= 1000 
// 0 <= grumpy[i] <= 1 
// 
// Related Topics 数组 Sliding Window 
// 👍 79 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {
            int init = 0;
            int len = customers.length;
            for (int i = 0; i < len; i++) {
                if (grumpy[i] == 0) {
                    init += customers[i];
                }
            }

            int l = findL(grumpy);
            if (l == -1) {
                return init;
            }
            int curr = 0;
            int max = 0;
            for (int r = 0; r < len; r++) {
                if (grumpy[r] == 1) {
                    curr += customers[r];
                    while (r - l >= X) {
                        curr -= customers[l];
                        l++;
                        while (grumpy[l] == 0) {
                            l++;
                        }
                    }
                    max = Math.max(max, curr);
                }
            }
            return init + max;
        }

        private int findL(int[] grumpy) {
            for (int i = 0; i < grumpy.length; i++) {
                if (grumpy[i] == 1) {
                    return i;
                }
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
            Assert.assertEquals(16, solution.maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
            Assert.assertEquals(3, solution.maxSatisfied(new int[]{3}, new int[]{1}, 1));
            Assert.assertEquals(17, solution.maxSatisfied(new int[]{2, 6, 6, 9}, new int[]{0, 0, 1, 1}, 1));
            Assert.assertEquals(22176, solution.maxSatisfied(new int[]{22, 609, 498, 467, 957, 156, 897, 839, 136, 382, 43, 395, 910, 662, 496, 472, 582, 573, 355, 849, 174, 77, 900, 751, 487, 530, 566, 350, 15, 351, 793, 166, 698, 583, 858, 895, 907, 942, 2, 512, 895, 30, 270, 585, 838, 271, 905, 476, 217, 536},
                    new int[]{1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0},
                    26));
        }
    }
}
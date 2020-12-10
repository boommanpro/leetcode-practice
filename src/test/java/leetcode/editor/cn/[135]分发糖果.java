package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest135 {
//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻的孩子中，评分高的孩子必须获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 示例 1: 
//
// 输入: [1,0,2]
//输出: 5
//解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2: 
//
// 输入: [1,2,2]
//输出: 4
//解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 314 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int candy(int[] ratings) {
            int len = ratings.length;
            int[] candies = new int[len];
            //填充糖果默认值
            Arrays.fill(candies, 1);
            //正序填充 往前看
            for (int i = 1; i < len; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                }
            }
            //反序填充 往后看
            for (int i = len - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    if (candies[i] <= candies[i + 1]) {
                        candies[i] = candies[i + 1] + 1;
                    }
                }
            }
            return Arrays.stream(candies).sum();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(5, solution.candy(new int[]{1, 0, 2}));
            Assert.assertEquals(4, solution.candy(new int[]{1, 2, 2}));
            Assert.assertEquals(13, solution.candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
            Assert.assertEquals(21, solution.candy(new int[]{1, 2, 3, 4, 5, 6}));
        }
    }
}
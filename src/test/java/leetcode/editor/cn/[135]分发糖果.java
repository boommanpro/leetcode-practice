package leetcode.editor.cn;

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

        public int candy(int[] nums) {
            int len = nums.length;
            int ans = 1;
            int prev = 1;
            int desc = 0;
            int asc = 1;
            for (int i = 1; i < len; i++) {
                if (nums[i] >= nums[i - 1]) {
                    prev = nums[i] == nums[i - 1] ? 1 : prev + 1;
                    asc = prev;
                    ans += prev;
                    desc = 0;
                } else {
                    desc++;
                    if (desc == asc) {
                        desc++;
                    }
                    ans += desc;
                    prev = 1;
                }
            }
            return ans;
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
            Assert.assertEquals(13, solution.candy(new int[]{1, 3, 5, 3, 2, 1}));
            Assert.assertEquals(15, solution.candy(new int[]{0, 1, 2, 5, 3, 2, 7}));
            Assert.assertEquals(18, solution.candy(new int[]{1, 3, 5, 4, 3, 2, 1}));
        }
    }
}
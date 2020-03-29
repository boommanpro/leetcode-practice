package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;
class SolutionTest11 {
//给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例: 
//
// 输入: [1,8,6,2,5,4,8,3,7]
//输出: 49 
// Related Topics 数组 双指针
    public static
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int resultArea = getArea(height, left, right);
        while (right > left) {
            if (height[right] > height[left]) {
                left++;
            }else {
                right--;
            }
            resultArea = getMax(resultArea, getArea(height, left, right));
        }
        return resultArea;
    }

    private int getArea(int[] height, int left, int right) {
        return (right - left) * (height[right] > height[left] ? height[left] : height[right]);
    }

    private int getMax(int a, int b) {
        return a > b ? a : b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Assert.assertEquals(1, new Solution().maxArea(IntStream.of(1, 1).toArray()));
            Assert.assertEquals(49, new Solution().maxArea(IntStream.of(1, 8, 6, 2, 5, 4, 8, 3, 7).toArray()));
            Assert.assertEquals(17, new Solution().maxArea(IntStream.of(2,3,4,5,18,17,6).toArray()));

        }
    }
}
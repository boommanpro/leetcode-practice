package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class SolutionTest面试题17_10 {
//数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。 
//
// 示例 1： 
//
// 输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 
//
// 示例 2： 
//
// 输入：[3,2]
//输出：-1 
//
// 
//
// 示例 3： 
//
// 输入：[2,2,1,1,1,2,2]
//输出：2 
//
// 
//
// 说明： 
//你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？ 
// Related Topics 位运算 数组 分治算法

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int n = nums.length;
            int threshold = n / 2;
            return Arrays.stream(nums).boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(integerLongEntry -> integerLongEntry.getValue() > threshold)
                    .findAny()
                    .map(Map.Entry::getKey)
                    .orElse(-1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(5, solution.majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
            Assert.assertEquals(-1, solution.majorityElement(new int[]{3, 2}));
            Assert.assertEquals(2, solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        }
    }
}
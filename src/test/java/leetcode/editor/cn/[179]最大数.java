package leetcode.editor.cn;

import jdk.nashorn.internal.ir.IfNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

class SolutionTest179 {
//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 排序 
// 👍 518 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int MAX = (int) 1e9;

        public String largestNumber(int[] nums) {
            String ans = Arrays.stream(nums).boxed().map(String::valueOf).sorted((a, b) -> (b + a).compareTo(a + b)).reduce("", (a, b) -> a + b);
            return ans.charAt(0) == '0' ? "0" : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("210", solution.largestNumber(new int[]{10, 2}));
            Assert.assertEquals("9534330", solution.largestNumber(new int[]{3, 30, 34, 5, 9}));
            Assert.assertEquals("1", solution.largestNumber(new int[]{1}));
            Assert.assertEquals("10", solution.largestNumber(new int[]{10}));
            Assert.assertEquals("1113111311", solution.largestNumber(new int[]{111311, 1113}));
        }

    }
}
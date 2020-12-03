package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class SolutionTest659 {
//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
// 输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 :
//1, 2, 3
//3, 4, 5
//
//
//
//
// 示例 2：
//
// 输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 :
//1, 2, 3, 4, 5
//3, 4, 5
//
//
//
//
// 示例 3：
//
// 输入: [1,2,3,4,4,5]
//输出: False
//
//
//
//
// 提示：
//
//
// 输入的数组长度范围为 [1, 10000]
//
//
//
// Related Topics 堆 贪心算法
// 👍 136 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossible(int[] nums) {
            Map<Integer, Long> countMap = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<Integer, Integer> endMap = new HashMap<>();
            for (int num : nums) {
                long count = countMap.get(num);
                if (count > 0) {
                    int endCount = endMap.getOrDefault(num - 1, 0);
                    if (endCount != 0) {
                        endMap.put(num - 1, endCount - 1);
                        endMap.put(num, endMap.getOrDefault(num, 0) + 1);
                        countMap.put(num, count - 1);
                    }else {
                        Long num1Count = countMap.getOrDefault(num + 1, 0L);
                        Long num2Count = countMap.getOrDefault(num + 2, 0L);
                        if (num1Count <= 0 || num2Count <= 0) {
                            return false;
                        }
                        countMap.put(num, count - 1);
                        countMap.put(num + 1, num1Count - 1);
                        countMap.put(num + 2, num2Count - 1);
                        endMap.put(num + 2, endMap.getOrDefault(num + 2, 0) + 1);
                    }
                }
            }
            return true;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.isPossible(new int[]{1, 2, 3, 3, 4, 5}));
            Assert.assertTrue(solution.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
            Assert.assertFalse(solution.isPossible(new int[]{1, 2, 3, 4, 4, 5}));
        }
    }
}
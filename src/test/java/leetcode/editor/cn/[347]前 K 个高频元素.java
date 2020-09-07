package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest347 {

    //给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 说明： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 
// Related Topics 堆 哈希表
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] topKFrequent(int[] nums, int k) {

            return Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted((o1, o2) -> (int) (o2.getValue() - o1.getValue()))
                    .map(Map.Entry::getKey).collect(Collectors.toList())
                    .subList(0, k).stream().mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();

            int[] result1 = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
            Assert.assertArrayEquals(new int[]{1, 2}, result1);

            int[] result2 = solution.topKFrequent(new int[]{1}, 1);
            Assert.assertArrayEquals(new int[]{1}, result2);
        }
    }
}
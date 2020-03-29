package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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

        public List<Integer> topKFrequent(int[] nums, int k) {
            //堆排序  + Map
            Map<Integer, Integer> dict = new HashMap<>();
            for (int num : nums) {
                dict.put(num, dict.getOrDefault(num, 0) + 1);
            }
            Map<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());

            dict.forEach((key, value) -> {
                List<Integer> list = map.getOrDefault(value, new ArrayList<>());
                list.add(key);
                map.put(value, list);
            });

            List<Integer> result = new ArrayList<>(k);
            for (List<Integer> value : map.values()) {
                result.addAll(value);

                if (result.size() >= k) {
                    break;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();

            List<Integer> result1 = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
            int[] result1Array = result1.stream().mapToInt(Integer::intValue).toArray();
            Assert.assertArrayEquals(new int[]{1, 2}, result1Array);

            List<Integer> result2 = solution.topKFrequent(new int[]{1}, 1);
            int[] result2Array = result2.stream().mapToInt(Integer::intValue).toArray();
            Assert.assertArrayEquals(new int[]{1}, result2Array);
        }
    }
}
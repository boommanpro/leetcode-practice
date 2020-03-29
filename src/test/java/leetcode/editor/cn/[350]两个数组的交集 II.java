package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionTest350 {

    //给定两个数组，编写一个函数来计算它们的交集。
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9] 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶: 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> dict1 = new HashMap<>();
            Map<Integer, Integer> dict2 = new HashMap<>();
            for (int v : nums1) {
                dict1.put(v, dict1.getOrDefault(v, 0) + 1);
            }
            for (int v : nums2) {
                dict2.put(v, dict2.getOrDefault(v, 0) + 1);
            }
            List<Integer> resultList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : dict1.entrySet()) {
                if (!dict2.containsKey(entry.getKey())) {
                    continue;
                }
                int minLength = Math.min(entry.getValue(), dict2.get(entry.getKey()));
                for (int i = 0; i < minLength; i++) {
                    resultList.add(entry.getKey());
                }
            }
            return resultList.stream().mapToInt(value -> value).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }
    }
}
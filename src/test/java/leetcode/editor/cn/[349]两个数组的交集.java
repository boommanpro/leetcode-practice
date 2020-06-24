package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest349 {
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> dict1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            Set<Integer> dict2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
            dict1.retainAll(dict2);
            return dict1.stream().mapToInt(Integer::intValue).toArray();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertArrayEquals(new int[]{2}, solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
            Assert.assertArrayEquals(new int[]{4, 9}, solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
        }
    }
}
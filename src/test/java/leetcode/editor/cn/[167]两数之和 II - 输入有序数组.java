package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest167 {

    //给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] twoSum(int[] numbers, int target) {
            int[] index = new int[2];
            int i = 0, j = numbers.length - 1;
            while (i < j) {
                if (numbers[i] + numbers[j] > target)
                    j--;
                else if (numbers[i] + numbers[j] < target)
                    i++;
                else {
                    index[0] = i + 1;
                    index[1] = j + 1;
                    break;
                }
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            int[] array1 = {2, 7, 11, 15};
            int target1 = 9;
            int[] result1 = solution.twoSum(array1, target1);
            Assert.assertEquals(target1, array1[result1[0] - 1] + array1[result1[1] - 1]);

            int[] array2 = {1, 2, 3, 7, 9, 25, 100, 101, 120, 150};
            int target2 = 129;
            int[] result2 = solution.twoSum(array2, target2);
            Assert.assertEquals(target2, array2[result2[0] - 1] + array2[result2[1] - 1]);

        }
    }
}
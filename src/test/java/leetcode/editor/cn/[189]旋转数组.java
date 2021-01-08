package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest189 {
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组 
// 👍 623 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return;
            }
            k %= nums.length;
            if (k == 0) {
                return;
            }
            int count = 0;
            for (int i = 0; i < k; i++) {
                count += move(nums, k, i);
                if (count == nums.length) {
                    return;
                }
            }

        }

        private int move(int[] nums, int k, int i) {
            int p = i;
            int prev = nums[p];
            int count = 0;
            do {
                int next = (p + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                p = next;
                count++;
            } while (p != i);
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();

            int[] array0 = {1, 2, 3, 4, 5, 6, 7};
            solution.rotate(array0, 3);
            Assert.assertEquals("[5, 6, 7, 1, 2, 3, 4]", Arrays.toString(array0));

            int[] array1 = {-1, -100, 3, 99};
            solution.rotate(array1, 2);
            Assert.assertEquals("[3, 99, -1, -100]", Arrays.toString(array1));

            int[] array2 = {1, 2, 3, 4, 5, 6, 7};
            solution.rotate(array2, 5);
            Assert.assertEquals("[3, 4, 5, 6, 7, 1, 2]", Arrays.toString(array2));

            int[] array3 = {1, 2, 3};
            solution.rotate(array3, 2);
            Assert.assertEquals("[2, 3, 1]", Arrays.toString(array3));

            int[] array4 = {1, 2};
            solution.rotate(array4, 1);
            Assert.assertEquals("[2, 1]", Arrays.toString(array4));

            int[] array5 = {1, 2, 3, 4, 5, 6};
            solution.rotate(array5, 3);
            Assert.assertEquals("[4, 5, 6, 1, 2, 3]", Arrays.toString(array5));
        }
    }
}
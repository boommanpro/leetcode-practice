package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest283 {
    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针
    public static


//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            // 输入: [0,1,0,3,12]
            // 输出: [1,3,12,0,0]
            int l = 0, r = 0;
            while (r < nums.length) {
                if (nums[r] != 0 && l != r && nums[l] == 0) {
                    nums[l] = nums[r];
                    nums[r] = 0;
                    l++;
                }
                if (nums[l] != 0) {
                    l++;
                }
                r++;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            int[] array1 = new int[]{0, 1, 0, 3, 12};
            solution.moveZeroes(array1);
            Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, array1);

            int[] array2 = new int[]{1};
            solution.moveZeroes(array2);
            Assert.assertArrayEquals(new int[]{1}, array2);

            int[] array3 = new int[]{2, 1};
            solution.moveZeroes(array3);
            Assert.assertArrayEquals(new int[]{2, 1}, array3);


            int[] array4 = new int[]{1,0,1};
            solution.moveZeroes(array4);
            Assert.assertArrayEquals(new int[]{1, 1,0}, array4);
        }
    }
}
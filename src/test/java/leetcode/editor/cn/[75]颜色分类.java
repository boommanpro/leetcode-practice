package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest75 {

    //给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 注意: 
//不能使用代码库中的排序函数来解决这道题。 
//
// 示例: 
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2] 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用计数排序的两趟扫描算法。 
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void sortColors(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            for (int i = 0; i <= r; i++) {
                if (nums[i] == 0 && i != l) {
                    swap(nums, l, i);
                    l++;
                }
                if (nums[i] == 2) {
                    swap(nums, i, r);
                    r--;
                    i--;
                }
            }
        }

        private void swap(int[] nums, int a, int b) {
            int c = nums[a];
            nums[a] = nums[b];
            nums[b] = c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            int[] array1 = {1, 1, 1, 2, 0, 2, 2, 1, 1, 2, 2, 1, 1, 0, 0, 0, 1, 2, 0};
            System.out.println("before:" + Arrays.toString(array1));
            solution.sortColors(array1);
            System.out.println("after:" + Arrays.toString(array1));
            Assert.assertArrayEquals(array1, new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2});

            int[] array2 = {2, 0, 2, 1, 1, 0};
            System.out.println("before:" + Arrays.toString(array2));
            solution.sortColors(array2);
            System.out.println("after:" + Arrays.toString(array2));
            Assert.assertArrayEquals(array2, new int[]{0, 0, 1, 1, 2, 2});

            int[] array3 = {2, 0, 1};
            System.out.println("before:" + Arrays.toString(array3));
            solution.sortColors(array3);
            System.out.println("after:" + Arrays.toString(array3));
            Assert.assertArrayEquals(array3, new int[]{0, 1, 2});
        }
    }
}
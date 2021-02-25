package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1089 {
//给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。 
//
// 注意：请不要在超过该数组长度的位置写入元素。 
//
// 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。 
//
// 
//
// 示例 1： 
//
// 输入：[1,0,2,3,0,4,5,0]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
// 
//
// 示例 2： 
//
// 输入：[1,2,3]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10000 
// 0 <= arr[i] <= 9 
// 
// Related Topics 数组 
// 👍 76 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void duplicateZeros(int[] arr) {
            int last = arr.length - 1;
            int offset = 0;
            for (int i = 0; i <= last - offset; i++) {
                if (arr[i] == 0) {
                    if (i + offset == last) {
                        arr[last] = 0;
                        last--;
                        offset--;
                    }
                    offset++;
                }
            }
            last -= offset;
            while (last >= 0) {
                arr[last + offset] = arr[last];
                if (arr[last] == 0) {
                    offset--;
                    arr[last + offset] = arr[last];
                }
                last--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            int[] arr0 = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
            solution.duplicateZeros(arr0);
            Assert.assertEquals("[1, 0, 0, 2, 3, 0, 0, 4]", Arrays.toString(arr0));
            int[] arr1 = new int[]{1, 2, 3};
            solution.duplicateZeros(arr1);
            Assert.assertEquals("[1, 2, 3]", Arrays.toString(arr1));
            int[] arr2 = new int[]{8, 4, 5, 0, 0, 0, 0, 7};
            solution.duplicateZeros(arr2);
            Assert.assertEquals("[8, 4, 5, 0, 0, 0, 0, 0]", Arrays.toString(arr2));
            int[] arr3 = new int[]{9, 9, 9, 4, 8, 0, 0, 3, 7, 2, 0, 0, 0, 0, 9, 1, 0, 0, 1, 1, 0, 5, 6, 3, 1, 6, 0, 0, 2, 3, 4, 7, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 7, 3, 3, 0, 5, 7, 0, 8, 1, 9, 6, 3, 0, 8, 8, 8, 8, 0, 0, 5, 0, 0, 0, 3, 7, 7, 7, 7, 5, 1, 0, 0, 8, 0, 0};
            solution.duplicateZeros(arr3);
            Assert.assertEquals("[9, 9, 9, 4, 8, 0, 0, 0, 0, 3, 7, 2, 0, 0, 0, 0, 0, 0, 0, 0, 9, 1, 0, 0, 0, 0, 1, 1, 0, 0, 5, 6, 3, 1, 6, 0, 0, 0, 0, 2, 3, 4, 7, 0, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 0, 0, 7, 3, 3, 0, 0, 5, 7, 0, 0, 8, 1, 9, 6, 3, 0, 0, 8, 8, 8, 8, 0]", Arrays.toString(arr3));
        }
    }
}
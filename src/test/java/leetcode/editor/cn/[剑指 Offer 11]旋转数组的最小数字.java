package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest剑指Offer_11 {
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找 
// 👍 86 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minArray(int[] numbers) {
            int n = numbers.length;
            int l = 0;
            int r = n - 1;
            //如果是递增序列那么就还是0
            if (numbers[l] < numbers[r]) {
                return numbers[l];
            }
            //二分查找
            while (l < r) {
                int mid = ((r - l) >> 1) + l;
                if (numbers[mid] < numbers[r]) {
                    r = mid;
                } else if (numbers[mid] > numbers[r]) {
                    l = mid + 1;
                } else {
                    r--;
                }
            }
            return numbers[l];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(0, solution.minArray(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 1, 1, 1}));
            Assert.assertEquals(1, solution.minArray(new int[]{3, 4, 5, 1, 2}));
            Assert.assertEquals(0, solution.minArray(new int[]{2, 2, 2, 0, 1}));
            Assert.assertEquals(1, solution.minArray(new int[]{1, 2, 3, 4, 5}));
        }
    }
}
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest448 {

    //给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int index = (nums[i] - 1) % nums.length;
                nums[index] += nums.length;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= nums.length) {
                    result.add(i + 1);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        //数组长度为n
        //遍历每一个元素 其元素本应对应排序后的位置的值+n
        //若数组元素值小于等于n，则说明数组下标值不存在，即消失的数字

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[5, 6]", solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).toString());
        }
    }
}
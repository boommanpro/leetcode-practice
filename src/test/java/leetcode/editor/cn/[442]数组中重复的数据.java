package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest442 {

    //给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
//
// 找到所有出现两次的元素。 
//
// 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？ 
//
// 示例： 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[2,3]
// 
// Related Topics 数组
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> result = new ArrayList<>();
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                int index = (nums[i] - 1) % len;
                nums[index] += len;
            }
            for (int i = 0; i < len; i++) {
                if (nums[i] > 2 * len) {
                    result.add(i + 1);
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
            Assert.assertEquals("[2, 3]", solution.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).toString());
        }
    }
}
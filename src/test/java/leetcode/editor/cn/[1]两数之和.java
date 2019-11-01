package leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
class SolutionTest1 {
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表
    public static
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //第一种 排序数组 然后二分查找
        //第二种 放到map中
        Map<Integer, Integer> dictMap = new HashMap<>(nums.length);
        int search;
        for (int i = 0; i < nums.length; i++) {
            search = target - nums[i];
            Integer position = dictMap.get(search);
            if (position != null) {
                return new int[]{position, i};
            }
            dictMap.put(nums[i], i);
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertArrayEquals(new int[]{0,1},solution.twoSum(new int[]{2, 7, 11, 15}, 9));
            Assert.assertArrayEquals(new int[]{2,3},solution.twoSum(new int[]{10, 100, 11, 15}, 26));
            Assert.assertArrayEquals(new int[]{0,3},solution.twoSum(new int[]{99, 8, 7, 6}, 105));
        }
    }
}
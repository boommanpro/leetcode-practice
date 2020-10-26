package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1365 {
//给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。 
//
// 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。 
//
// 以数组形式返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [8,1,2,2,3]
//输出：[4,0,1,1,3]
//解释： 
//对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。 
//对于 nums[1]=1 不存在比它小的数字。
//对于 nums[2]=2 存在一个比它小的数字：（1）。 
//对于 nums[3]=2 存在一个比它小的数字：（1）。 
//对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
// 
//
// 示例 2： 
//
// 输入：nums = [6,5,4,8]
//输出：[2,1,0,3]
// 
//
// 示例 3： 
//
// 输入：nums = [7,7,7,7]
//输出：[0,0,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 500 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 哈希表 
// 👍 83 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[][] array = new int[nums.length][3];
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                array[i][0] = nums[i];
                array[i][1] = i;
            }
            array = Arrays.stream(array).sorted((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }).toArray(int[][]::new);
            for (int i = 1; i < len; i++) {
                if (array[i][0] == array[i - 1][0]) {
                    array[i][2] = array[i - 1][2];
                    continue;
                }
                array[i][2] = i;
            }

            return Arrays.stream(array).sorted(Comparator.comparingInt(o -> o[1])).map(ints -> ints[2]).mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[4, 0, 1, 1, 3]", Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
            Assert.assertEquals("[2, 1, 0, 3]", Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})));
            Assert.assertEquals("[0, 0, 0, 0]", Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})));
        }
    }
}
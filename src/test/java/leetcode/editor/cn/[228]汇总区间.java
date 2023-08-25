package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class SolutionTest228 {
//给定一个无重复元素的有序整数数组 nums 。
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 num
//s 的数字 x 。
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出：
//
//
// "a->b" ，如果 a != b
// "a" ，如果 a == b
//
//
//
//
// 示例 1：
//
//
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
//
//
// 示例 2：
//
//
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
//
//
// 示例 3：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 4：
//
//
//输入：nums = [-1]
//输出：["-1"]
//
//
// 示例 5：
//
//
//输入：nums = [0]
//输出：["0"]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 20
// -231 <= nums[i] <= 231 - 1
// nums 中的所有值都 互不相同
// nums 按升序排列
//
// Related Topics 数组
// 👍 100 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            List<int[]> ans = new ArrayList<>();
            int[] curr = new int[]{nums[0], nums[0]};
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1] + 1) {
                    curr[1] = nums[i];
                } else {
                    ans.add(curr);
                    curr = new int[]{nums[i], nums[i]};
                }
            }
            ans.add(curr);


            return ans.stream().map(ints -> {
                if (ints[0] == ints[1]) {
                    return String.format("%d", ints[0]);
                }
                return String.format("%d->%d", ints[0], ints[1]);
            }).collect(Collectors.toList());
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[]", solution.summaryRanges(new int[]{}).toString());
            Assert.assertEquals("[0->2, 4->5, 7]", solution.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}).toString());
        }
    }
}

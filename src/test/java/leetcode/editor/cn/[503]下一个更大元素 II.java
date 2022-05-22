package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

class SolutionTest503 {
//给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素
// 。 
//
// 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 
//。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,3]
//输出: [2,3,4,-1,4]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 栈 数组 单调栈 👍 629 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            int n = nums.length;
            int[] ans = new int[n];
            int i = 2 * (n - 1);
            while (i >= 0) {
                int p = i % n;
                while (!stack.isEmpty() && stack.peek() <= nums[p]) {
                    stack.pop();
                }
                ans[p] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[p]);
                i--;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[2, -1, 2]", Arrays.toString(solution.nextGreaterElements(new int[]{1, 2, 1})));
            Assert.assertEquals("[2, 3, 4, -1, 4]", Arrays.toString(solution.nextGreaterElements(new int[]{1,2,3,4,3})));
        }

    }
}
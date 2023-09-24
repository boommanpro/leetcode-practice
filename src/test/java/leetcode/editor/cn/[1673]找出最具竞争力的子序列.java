package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest1673 {
//给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
//
// 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
//
// 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力
//。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,5,2,6], k = 2
//输出：[2,6]
//解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
//
//
// 示例 2：
//
//
//输入：nums = [2,4,3,3,5,4,9,6], k = 4
//输出：[2,3,3,4]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 0 <= nums[i] <= 10⁹
// 1 <= k <= nums.length
//
//
// Related Topics栈 | 贪心 | 数组 | 单调栈
//
// 👍 108, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] mostCompetitive(int[] nums, int k) {
            int n = nums.length;
            int delete = n - k;
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int curr = nums[i];
                while (delete > 0 && !stack.isEmpty() && stack.peek() > curr) {
                    stack.pop();
                    delete--;
                }
                stack.push(curr);
            }
            while (delete > 0) {
                stack.pop();
                delete--;
            }
            int[] ans = new int[k];
            for (int i = k - 1; i >= 0; i--) {
                ans[i] = stack.pop();
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

            Assert.assertArrayEquals(new int[]{2, 6}, solution.mostCompetitive(new int[]{3, 5, 2, 6}, 2));
            Assert.assertArrayEquals(new int[]{2, 3, 3, 4}, solution.mostCompetitive(new int[]{2, 4, 3, 3, 5, 4, 9, 6}, 4));
        }

    }
}

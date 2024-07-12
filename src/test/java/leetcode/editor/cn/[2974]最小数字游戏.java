package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest2974 {
//你有一个下标从 0 开始、长度为 偶数 的整数数组 nums ，同时还有一个空数组 arr 。Alice 和 Bob 决定玩一个游戏，游戏中每一轮
//Alice 和 Bob 都会各自执行一次操作。游戏规则如下：
//
//
// 每一轮，Alice 先从 nums 中移除一个 最小 元素，然后 Bob 执行同样的操作。
// 接着，Bob 会将移除的元素添加到数组 arr 中，然后 Alice 也执行同样的操作。
// 游戏持续进行，直到 nums 变为空。
//
//
// 返回结果数组 arr 。
//
//
//
// 示例 1：
//
//
//输入：nums = [5,4,2,3]
//输出：[3,2,5,4]
//解释：第一轮，Alice 先移除 2 ，然后 Bob 移除 3 。然后 Bob 先将 3 添加到 arr 中，接着 Alice 再将 2 添加到 arr 中
//。于是 arr = [3,2] 。
//第二轮开始时，nums = [5,4] 。Alice 先移除 4 ，然后 Bob 移除 5 。接着他们都将元素添加到 arr 中，arr 变为 [3,2,5
//,4] 。
//
//
// 示例 2：
//
//
//输入：nums = [2,5]
//输出：[5,2]
//解释：第一轮，Alice 先移除 2 ，然后 Bob 移除 5 。然后 Bob 先将 5 添加到 arr 中，接着 Alice 再将 2 添加到 arr 中
//。于是 arr = [5,2] 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100
// nums.length % 2 == 0
//
//
// Related Topics数组 | 排序 | 模拟 | 堆（优先队列）
//
// 👍 14, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numberGame(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i += 2) {
                exchange(nums, i, i + 1);
            }
            return nums;
        }

        private void exchange(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            // 测试用例1: 基本情况
            int[] input1 = {5, 4, 2, 3};
            int[] expectedOutput1 = {3, 2, 5, 4};
            Assert.assertArrayEquals(expectedOutput1, solution.numberGame(input1));

            // 测试用例2: 两个元素的情况
            int[] input2 = {2, 5};
            int[] expectedOutput2 = {5, 2};
            Assert.assertArrayEquals(expectedOutput2, solution.numberGame(input2));

        }

    }
}

package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest2952 {
//给你一个下标从 0 开始的整数数组 coins，表示可用的硬币的面值，以及一个整数 target 。
//
// 如果存在某个 coins 的子序列总和为 x，那么整数 x 就是一个 可取得的金额 。
//
// 返回需要添加到数组中的 任意面值 硬币的 最小数量 ，使范围 [1, target] 内的每个整数都属于 可取得的金额 。
//
// 数组的 子序列 是通过删除原始数组的一些（可能不删除）元素而形成的新的 非空 数组，删除过程不会改变剩余元素的相对位置。
//
//
//
// 示例 1：
//
//
//输入：coins = [1,4,10], target = 19
//输出：2
//解释：需要添加面值为 2 和 8 的硬币各一枚，得到硬币数组 [1,2,4,8,10] 。
//可以证明从 1 到 19 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 2 。
//
//
// 示例 2：
//
//
//输入：coins = [1,4,10,5,7,19], target = 19
//输出：1
//解释：只需要添加一枚面值为 2 的硬币，得到硬币数组 [1,2,4,5,7,10,19] 。
//可以证明从 1 到 19 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 1 。
//
// 示例 3：
//
//
//输入：coins = [1,1,1], target = 20
//输出：3
//解释：
//需要添加面值为 4 、8 和 16 的硬币各一枚，得到硬币数组 [1,1,1,4,8,16] 。
//可以证明从 1 到 20 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 3 。
//
//
//
// 提示：
//
//
// 1 <= target <= 10⁵
// 1 <= coins.length <= 10⁵
// 1 <= coins[i] <= target
//
//
// Related Topics贪心 | 数组 | 排序
//
// 👍 82, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumAddedCoins(int[] coins, int target) {
            Arrays.sort(coins);
            int add = 0;
            for (int s = 1, i = 0, n = coins.length; s <= target; ) {
                if (i < n && coins[i] <= s) {
                    s += coins[i++];
                }else {
                    s *= 2;
                    add++;
                }
            }
            return add;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.minimumAddedCoins(new int[]{1, 4, 10}, 19));
        }

    }
}

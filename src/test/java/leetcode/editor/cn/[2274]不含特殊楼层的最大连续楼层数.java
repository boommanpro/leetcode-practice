package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class SolutionTest2274 {
//Alice 管理着一家公司，并租用大楼的部分楼层作为办公空间。Alice 决定将一些楼层作为 特殊楼层 ，仅用于放松。
//
// 给你两个整数 bottom 和 top ，表示 Alice 租用了从 bottom 到 top（含 bottom 和 top 在内）的所有楼层。另给你一个
//整数数组 special ，其中 special[i] 表示 Alice 指定用于放松的特殊楼层。
//
// 返回不含特殊楼层的 最大 连续楼层数。
//
//
//
// 示例 1：
//
//
//输入：bottom = 2, top = 9, special = [4,6]
//输出：3
//解释：下面列出的是不含特殊楼层的连续楼层范围：
//- (2, 3) ，楼层数为 2 。
//- (5, 5) ，楼层数为 1 。
//- (7, 9) ，楼层数为 3 。
//因此，返回最大连续楼层数 3 。
//
//
// 示例 2：
//
//
//输入：bottom = 6, top = 8, special = [7,6,8]
//输出：0
//解释：每层楼都被规划为特殊楼层，所以返回 0 。
//
//
//
//
// 提示
//
//
// 1 <= special.length <= 10⁵
// 1 <= bottom <= special[i] <= top <= 10⁹
// special 中的所有值 互不相同
//
//
// Related Topics数组 | 排序
//
// 👍 37, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxConsecutive(int bottom, int top, int[] special) {
            Arrays.sort(special);
            int max = 0;
            int curr = bottom;
            for (int gap : special) {
                if (curr < gap) {
                    max = Math.max(gap - curr, max);
                }
                curr = gap + 1;
            }
            if (curr < top) {
                max = Math.max(top - curr + 1, max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            // 示例1
            int bottom1 = 2;
            int top1 = 9;
            int[] special1 = {4, 6};
            assertEquals(3, solution.maxConsecutive(bottom1, top1, special1));

            // 示例2
            int bottom2 = 6;
            int top2 = 8;
            int[] special2 = {7, 6, 8};
            assertEquals(0, solution.maxConsecutive(bottom2, top2, special2));
        }
    }
}

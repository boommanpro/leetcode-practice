package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest2342 {
//给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与
//nums[j] 的数位和相等。
//
// 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
//
//
//
// 示例 1：
//
//
//输入：nums = [18,43,36,13,7]
//输出：54
//解释：满足条件的数对 (i, j) 为：
//- (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
//- (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
//所以可以获得的最大和是 54 。
//
// 示例 2：
//
//
//输入：nums = [10,12,19,14]
//输出：-1
//解释：不存在满足条件的数对，返回 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁹
//
//
// Related Topics数组 | 哈希表 | 排序 | 堆（优先队列）
//
// 👍 46, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSum(int[] nums) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int num : nums) {
                int v = num;
                int curr = 0;
                while (num > 0) {
                    curr += num % 10;
                    num /= 10;
                }
                List<Integer> list = map.getOrDefault(curr, new ArrayList<>());
                list.add(v);
                map.put(curr, list);
            }
            int ans = -1;
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                List<Integer> list = entry.getValue();
                if (list.size() <= 1) {
                    continue;
                }
                Collections.sort(list);
                ans = Math.max(ans, list.get(list.size() - 1) + list.get(list.size() - 2));
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
            Assert.assertEquals(54, solution.maximumSum(new int[]{18, 43, 36, 13, 7}));
            Assert.assertEquals(-1, solution.maximumSum(new int[]{10, 12, 19, 14}));
        }

    }
}

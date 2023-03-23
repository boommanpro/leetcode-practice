package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest1630 {
//如果一个数列由至少两个元素组成，且每两个连续元素之间的差值都相同，那么这个序列就是 等差数列 。更正式地，数列 s 是等差数列，只需要满足：对于每个有效的 
//i ， s[i+1] - s[i] == s[1] - s[0] 都成立。 
//
// 例如，下面这些都是 等差数列 ： 
//
// 1, 3, 5, 7, 9
//7, 7, 7, 7
//3, -1, -5, -9 
//
// 下面的数列 不是等差数列 ： 
//
// 1, 1, 2, 5, 7 
//
// 给你一个由 n 个整数组成的数组 nums，和两个由 m 个整数组成的数组 l 和 r，后两个数组表示 m 组范围查询，其中第 i 个查询对应范围 [l[
//i], r[i]] 。所有数组的下标都是 从 0 开始 的。 
//
// 返回 boolean 元素构成的答案列表 answer 。如果子数组 nums[l[i]], nums[l[i]+1], ... , nums[r[i]]
// 可以 重新排列 形成 等差数列 ，answer[i] 的值就是 true；否则answer[i] 的值就是 false 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
//输出：[true,false,true]
//解释：
//第 0 个查询，对应子数组 [4,6,5] 。可以重新排列为等差数列 [6,5,4] 。
//第 1 个查询，对应子数组 [4,6,5,9] 。无法重新排列形成等差数列。
//第 2 个查询，对应子数组 [5,9,3,7] 。可以重新排列为等差数列 [3,5,7,9] 。 
//
// 示例 2： 
//
// 输入：nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4
//,4,9,7,9,10]
//输出：[false,true,false,false,true,true]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// m == l.length 
// m == r.length 
// 2 <= n <= 500 
// 1 <= m <= 500 
// 0 <= l[i] < r[i] < n 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 排序 👍 82 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            int m = l.length;
            List<Boolean> ans = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int L = l[i];
                int R = r[i];
                int min = nums[L];
                int max = nums[R];
                for (int j = L; j <= R; j++) {
                    min = Math.min(nums[j], min);
                    max = Math.max(nums[j], max);
                }
                if (min == max) {
                    ans.add(true);
                    continue;
                }
                int len = R - L;
                if ((max - min) % len != 0) {
                    ans.add(false);
                    continue;
                }
                int gap = (max - min) / len;
                boolean[] dp = new boolean[len + 1];
                for (int j = L; j <= R; j++) {
                    int v = nums[j] - min;
                    if (v % gap != 0) {
                        ans.add(false);
                        break;
                    }
                    int idx = v / gap;
                    if (dp[idx]) {
                        ans.add(false);
                        break;
                    }
                    dp[idx] = true;
                    if (j == R) {
                        ans.add(true);
                        break;
                    }
                }
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
            Assert.assertEquals("[true, false, true]", solution.checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}).toString());
            Assert.assertEquals("[false, true, false, false, true, true]", solution.checkArithmeticSubarrays(new int[]{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10}, new int[]{0, 1, 6, 4, 8, 7}, new int[]{4, 4, 9, 7, 9, 10}).toString());
            Assert.assertEquals("[true, false, false, false, true, false, false, true, true]", solution.checkArithmeticSubarrays(new int[]{1, 2, 10, -6, -7, 8, 16, 0, 0, 10, 20, 15, -2, -3, -1, -4, -4, -8, -2}, new int[]{14, 5, 11, 15, 12, 13, 9, 7, 0}, new int[]{15, 8, 14, 18, 15, 16, 12, 8, 1}).toString());
        }

    }
}
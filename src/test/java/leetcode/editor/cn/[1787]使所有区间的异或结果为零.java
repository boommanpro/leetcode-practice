package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1787 {
//给你一个整数数组 nums 和一个整数 k 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 rig
//ht（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR n
//ums[right] 。 
//
// 返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0,3,0], k = 1
//输出：3
//解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
//输出：3
//解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
//输出：3
//解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3] 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 2000 
// 0 <= nums[i] < 210 
// 
// Related Topics 动态规划 
// 👍 12 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public static final int MAX = (int) Math.pow(2, 10);

        public int minChanges(int[] nums, int k) {
            int[][] posCnt = new int[k][MAX];
            int[] posMax = new int[k];
            int[] size = new int[k];
            for (int i = 0; i < nums.length; i++) {
                int pos = i % k;
                posCnt[pos][nums[i]]++;
                size[pos]++;
                posMax[pos] = Math.max(posMax[pos], posCnt[pos][nums[i]]);
            }
            int res = dfs(posCnt, size, new Integer[k][MAX], nums, k, k - 1, 0);
            int sumCost = 0;
            int massCnt = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                sumCost += size[i] - posMax[i];
                massCnt = Math.min(massCnt, posMax[i]);
            }
            return Math.min(sumCost + massCnt, res);
        }

        private int dfs(int[][] posCnt, int[] size, Integer[][] memo, int[] nums, int k, int pos, int x) {
            if (pos == 0) {
                return size[pos] - posCnt[pos][x];
            }
            if (memo[pos][x] != null) {
                return memo[pos][x];
            }
            int ans = nums.length;
            for (int i = pos; i < nums.length; i += k) {
                int num = nums[i];
                ans = Math.min(ans, size[pos] - posCnt[pos][num] + dfs(posCnt, size, memo, nums, k, pos - 1, x ^ num));
            }
            memo[pos][x] = ans;
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertEquals(3, solution.minChanges(new int[]{1, 2, 0, 3, 0}, 1));
//            Assert.assertEquals(3, solution.minChanges(new int[]{3, 4, 5, 2, 1, 7, 3, 4, 7}, 3));
//            Assert.assertEquals(136, solution.minChanges(new int[]{126, 214, 35, 169, 106, 223, 213, 59, 36, 60, 200, 46, 75, 97, 60, 144, 150, 255, 181, 251, 122, 103, 98, 165, 5, 240, 150, 55, 184, 220, 68, 254, 26, 71, 17, 98, 2, 204, 31, 42, 105, 94, 117, 11, 15, 207, 182, 97, 116, 143, 212, 161, 61, 242, 62, 79, 167, 145, 244, 188, 140, 134, 226, 28, 79, 139, 245, 254, 249, 93, 226, 183, 46, 2, 107, 214, 167, 187, 131, 153, 47, 29, 155, 225, 225, 144, 113, 135, 111, 14, 211, 94, 77, 151, 22, 35, 127, 162, 13, 143, 187, 228, 110, 123, 42, 8, 58, 165, 249, 27, 85, 50, 235, 144, 159, 34, 197, 27, 185, 71, 238, 80, 43, 185, 158, 148, 27, 169, 87, 80, 108, 87, 252, 242, 187, 157, 98, 168, 24, 46, 131, 7, 155, 187, 50, 103, 198, 21, 128, 91, 235, 210, 238, 145, 216, 224, 216, 170, 25, 181, 42, 209, 112, 200, 243, 152, 148, 177, 124, 203, 75}, 33));
            Assert.assertEquals(3, solution.minChanges(new int[]{1, 2, 4, 1, 2, 5, 1, 2, 6}, 3));
        }
    }
}
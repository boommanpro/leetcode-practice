package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1442 {
//给你一个整数数组 arr 。 
//
// 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。 
//
// a 和 b 定义如下： 
//
// 
// a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1] 
// b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k] 
// 
//
// 注意：^ 表示 按位异或 操作。 
//
// 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [2,3,1,6,7]
//输出：4
//解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
// 
//
// 示例 2： 
//
// 输入：arr = [1,1,1,1,1]
//输出：10
// 
//
// 示例 3： 
//
// 输入：arr = [2,3]
//输出：0
// 
//
// 示例 4： 
//
// 输入：arr = [1,3,5,7,9]
//输出：3
// 
//
// 示例 5： 
//
// 输入：arr = [7,11,12,9,5,2,7,17,22]
//输出：8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 300 
// 1 <= arr[i] <= 10^8 
// 
// Related Topics 位运算 数组 数学 
// 👍 46 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countTriplets(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return 0;
            }
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                int curr = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    curr = curr ^ arr[j];
                    if (curr == 0) {
                        ans += j - i;
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
            Assert.assertEquals(4, solution.countTriplets(new int[]{2, 3, 1, 6, 7}));
            Assert.assertEquals(10, solution.countTriplets(new int[]{1, 1, 1, 1, 1}));
            Assert.assertEquals(0, solution.countTriplets(new int[]{2, 3}));
            Assert.assertEquals(3, solution.countTriplets(new int[]{1, 3, 5, 7, 9}));
            Assert.assertEquals(8, solution.countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
        }
    }
}
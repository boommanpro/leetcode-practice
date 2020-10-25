package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest845 {
//我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”： 
//
// 
// B.length >= 3 
// 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B
//[B.length - 1] 
// 
//
// （注意：B 可以是 A 的任意子数组，包括整个数组 A。） 
//
// 给出一个整数数组 A，返回最长 “山脉” 的长度。 
//
// 如果不含有 “山脉” 则返回 0。 
//
// 
//
// 示例 1： 
//
// 输入：[2,1,4,7,3,2,5]
//输出：5
//解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
// 
//
// 示例 2： 
//
// 输入：[2,2,2]
//输出：0
//解释：不含 “山脉”。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
// Related Topics 双指针 
// 👍 96 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int longestMountain(int[] A) {
            int max = 0;
            int l = 0;
            int r = 0;
            int length = A.length;
            for (int i = 1; i < length; i++) {
                if (A[i] == A[i - 1]) {
                    l = 0;
                    r = 0;
                    continue;
                }
                if (A[i] > A[i - 1]) {
                    if (i >= 2 && A[i - 1] < A[i - 2]) {
                        l = 0;
                        r = 0;
                    }
                    l++;
                    continue;
                }
                if (l != 0 && A[i] < A[i - 1]) {
                    r++;
                    max = Math.max(l + r + 1, max);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(5, solution.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
            Assert.assertEquals(0, solution.longestMountain(new int[]{2, 2, 2}));
            Assert.assertEquals(3, solution.longestMountain(new int[]{1, 2, 0, 2, 0, 2}));
        }
    }
}
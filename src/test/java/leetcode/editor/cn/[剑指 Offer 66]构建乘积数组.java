package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest剑指Offer66 {
//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// 👍 96 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] constructArr(int[] a) {
            if (a == null || a.length == 0) {
                return a;
            }
            int[] prefix = new int[a.length];
            int[] suffix = new int[a.length];
            int[] ans = new int[a.length];
            prefix[0] = 1;
            suffix[0] = 1;
            for (int i = 1; i < a.length; i++) {
                prefix[i] = a[i - 1] * prefix[i - 1];
                suffix[i] = a[a.length - i] * suffix[i - 1];
            }
            for (int i = 0; i < a.length; i++) {
                int left = i;
                int right = a.length - i - 1;
                ans[i] = prefix[left] * suffix[right];
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
            Assert.assertEquals("[120, 60, 40, 30, 24]", Arrays.toString(solution.constructArr(new int[]{1, 2, 3, 4, 5})));
        }
    }
}
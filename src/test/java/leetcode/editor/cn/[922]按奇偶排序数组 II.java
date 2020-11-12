package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest922 {
//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。 
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。 
//
// 你可以返回任何满足上述条件的数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// Related Topics 排序 数组 
// 👍 165 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] sortArrayByParityII(int[] A) {
            int[] bucket = new int[1000 + 1];
            for (int a : A) {
                bucket[a]++;
            }
            int curr = 0;
            int i = consumeEven(bucket, 0);
            int j = consumeOdd(bucket, 1);
            while (curr < A.length) {
                if (curr % 2 == 0) {
                    A[curr] = i;
                    i = consumeEven(bucket, i);
                } else {
                    A[curr] = j;
                    j = consumeOdd(bucket, j);
                }
                curr++;
            }
            return A;
        }

        private int consumeOdd(int[] bucket, int curr) {

            while (curr < bucket.length && bucket[curr] == 0) {
                curr += 2;
            }
            if (curr >= bucket.length) {
                return 0;
            }
            bucket[curr]--;
            return curr;
        }

        private int consumeEven(int[] bucket, int curr) {

            while (curr < bucket.length && bucket[curr] == 0) {
                curr += 2;
            }
            if (curr >= bucket.length) {
                return 0;
            }
            bucket[curr]--;
            return curr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[2, 5, 4, 7]", Arrays.toString(solution.sortArrayByParityII(new int[]{4,2,5,7})));
        }
    }
}
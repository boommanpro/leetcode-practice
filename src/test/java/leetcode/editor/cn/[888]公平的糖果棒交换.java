package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest888 {
//爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。 
//
// 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。） 
//
// 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。 
//
// 如果有多个答案，你可以返回其中任何一个。保证答案存在。 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [1,1], B = [2,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：A = [1,2], B = [2,3]
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：A = [2], B = [1,3]
//输出：[2,3]
// 
//
// 示例 4： 
//
// 
//输入：A = [1,2,5], B = [2,4]
//输出：[5,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= B.length <= 10000 
// 1 <= A[i] <= 100000 
// 1 <= B[i] <= 100000 
// 保证爱丽丝与鲍勃的糖果总量不同。 
// 答案肯定存在。 
// 
// Related Topics 数组 
// 👍 98 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            boolean[] bSet = new boolean[100001];
            int aSum = Arrays.stream(A).sum();
            int bSum = Arrays.stream(B).sum();
            for (int i : B) {
                bSet[i] = true;
            }
            int diff = (bSum - aSum) / 2;
            for (int i : A) {
                int target = diff + i;
                if (target >= 0 && target <= 100000 && bSet[target]) {
                    return new int[]{i, target};
                }
            }
            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[1, 2]", Arrays.toString(solution.fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
            Assert.assertEquals("[1, 2]", Arrays.toString(solution.fairCandySwap(new int[]{1, 2}, new int[]{2, 3})));
            Assert.assertEquals("[2, 3]", Arrays.toString(solution.fairCandySwap(new int[]{2}, new int[]{1, 3})));
            Assert.assertEquals("[5, 4]", Arrays.toString(solution.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
        }
    }
}
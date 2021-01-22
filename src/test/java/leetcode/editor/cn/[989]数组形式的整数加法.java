package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest989 {
//对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。 
//
// 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1,2,0,0], K = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
// 
//
// 示例 2： 
//
// 输入：A = [2,7,4], K = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
// 
//
// 示例 3： 
//
// 输入：A = [2,1,5], K = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
// 
//
// 示例 4： 
//
// 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
//输出：[1,0,0,0,0,0,0,0,0,0,0]
//解释：9999999999 + 1 = 10000000000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 0 <= A[i] <= 9 
// 0 <= K <= 10000 
// 如果 A.length > 1，那么 A[0] != 0 
// 
// Related Topics 数组 
// 👍 99 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> addToArrayForm(int[] A, int K) {
            List<Integer> ans = new ArrayList<>();
            int p = A.length - 1;
            int append = 0;
            while (K != 0 || append != 0 || p >= 0) {
                int sum = K % 10 + append + (p >= 0 ? A[p] : 0);
                append = sum / 10;
                K /= 10;
                ans.add(sum % 10);
                p--;
            }
            Collections.reverse(ans);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[1, 2, 3, 4]", solution.addToArrayForm(new int[]{1, 2, 0, 0}, 34).toString());
            Assert.assertEquals("[4, 5, 5]", solution.addToArrayForm(new int[]{2, 7, 4}, 181).toString());
            Assert.assertEquals("[1, 0, 2, 1]", solution.addToArrayForm(new int[]{2, 1, 5}, 806).toString());
            Assert.assertEquals("[1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]", solution.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1).toString());
        }
    }
}
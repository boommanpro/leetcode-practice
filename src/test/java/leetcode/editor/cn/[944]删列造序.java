package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest944 {
//给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。 
//
// 你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。 
//
// 删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.le
//ngth-1][n]]）。（可以参见 删除操作范例） 
//
// 
//
// 示例 1： 
//
// 输入：["cba", "daf", "ghi"]
//输出：1
//解释：
//当选择 D = {1}，删除后 A 的列为：["c","d","g"] 和 ["a","f","i"]，均为非降序排列。
//若选择 D = {}，那么 A 的列 ["b","a","h"] 就不是非降序排列了。
// 
//
// 示例 2： 
//
// 输入：["a", "b"]
//输出：0
//解释：D = {}
// 
//
// 示例 3： 
//
// 输入：["zyx", "wvu", "tsr"]
//输出：3
//解释：D = {0, 1, 2}
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 1000 
// 
//
// 
//
// 删除操作范例： 
//
// 比如，有 A = ["abcdef", "uvwxyz"]， 
//
// 
//
// 要删掉的列为 {0, 2, 3}，删除后 A 为["bef", "vyz"]， A 的列分别为["b","v"], ["e","y"], ["f","z"
//]。 
//
// 
// Related Topics 贪心算法 
// 👍 39 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minDeletionSize(String[] A) {
            if (A == null || A.length < 2) {
                return 0;
            }
            if (A[0].length() == 0) {
                return 0;
            }

            int len = A[0].length();
            int ans = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 1; j < A.length; j++) {
                    if (A[j - 1].charAt(i) > A[j].charAt(i)) {
                        ans++;
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
            Assert.assertEquals(1, solution.minDeletionSize(new String[]{"cba", "daf", "ghi"}));
            Assert.assertEquals(0, solution.minDeletionSize(new String[]{"a", "b"}));
            Assert.assertEquals(3, solution.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}));
        }
    }
}
package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class SolutionTest873 {
//如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的： 
//
// 
// n >= 3 
// 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2} 
// 
//
// 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回 0 。 
//
// （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 
//是 [3, 4, 5, 6, 7, 8] 的一个子序列） 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入: arr = [1,2,3,4,5,6,7,8]
//输出: 5
//解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
// 
//
// 示例 2： 
//
// 
//输入: arr = [1,3,7,11,12,14,18]
//输出: 3
//解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 1000 
// 
// 1 <= arr[i] < arr[i + 1] <= 10^9 
// 
// 
// Related Topics 数组 哈希表 动态规划 👍 241 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final long max = (long) 1e9;

        public int lenLongestFibSubseq(int[] arr) {
            Set<Integer> dict = Arrays.stream(arr).boxed().collect(Collectors.toSet());
            int n = arr.length;
            Set<Long> repeat = new HashSet<>();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    long v = arr[i] * max + arr[j];
                    if (repeat.contains(v)) {
                        continue;
                    }
                    int prev = arr[i];
                    int curr = arr[j];
                    int next = prev + curr;
                    int len = 0;
                    while (dict.contains(next)) {
                        v = prev * max + curr;
                        repeat.add(v);
                        prev = curr;
                        curr = next;
                        next = prev + curr;
                        len++;
                    }
                    ans = Math.max(ans, len);
                }
            }
            return ans == 0 ? 0 : ans + 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(5, solution.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
            Assert.assertEquals(3, solution.lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}));
        }

    }
}
package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SolutionTest60 {
//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法 
// 👍 305 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<Integer> result;

        public String getPermutation(int n, int k) {
            result = new ArrayList<>();
            int[] selectPath = new int[n];
            for (int i = 0; i < n; i++) {
                selectPath[i] = i + 1;
            }
            dfs(selectPath, 0, 0, n);
            Collections.sort(result);
            return result.get(k - 1).toString();
        }

        private void dfs(int[] selectPath, int path, int start, int n) {
            if (start == n) {
                result.add(path);
                return;
            }
            for (int i = start; i < n; i++) {
                path = path * 10 + selectPath[i];
                swap(selectPath, start, i);
                dfs(selectPath, path, start + 1, n);
                swap(selectPath, start, i);
                path = path / 10;
            }
        }

        private void swap(int[] selectPath, int start, int i) {
            int temp = selectPath[start];
            selectPath[start] = selectPath[i];
            selectPath[i] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("213", solution.getPermutation(3, 3));
            Assert.assertEquals("312", solution.getPermutation(3, 5));
        }
    }
}
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest131 {
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 给定一个字符串,在任意分割若干次,是的都是回文串
         */
        public List<List<String>> partition(String s) {
            if (s == null || s.isEmpty()) {
                return new ArrayList<>();
            }
            return partitionHelper(s, 0, s.length());
        }

        private List<List<String>> partitionHelper(String s, int start, int len) {
            if (start == len) {
                List<List<String>> res = new ArrayList<>();
                //这块一定要有new ArrayList<>(); 因为是有结果的
                res.add(new ArrayList<>());
                return res;
            }
            List<List<String>> res = new ArrayList<>();
            for (int i = start; i < len; i++) {
                //判断是否是回文 如果是的话可以当做一个单元处理
                if (isPalindrome(s, start, i)) {
                    //第一个值
                    String prefix = s.substring(start, i + 1);
                    //他的子集
                    for (List<String> subList : partitionHelper(s, i + 1, len)) {
                        subList.add(0, prefix);
                        res.add(subList);
                    }
                }
            }
            return res;
        }

        private boolean isPalindrome(String s, int l, int r) {
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }

        public List<List<String>> partition0(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            int length = s.length();
            for (int len = 1; len <= length; len++) {
                for (int i = 0; i <= s.length() - len; i++) {
                    int j = i + len - 1;
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
                }
            }
            return partitionHelper(s, 0, dp);
        }

        private List<List<String>> partitionHelper(String s, int start, boolean[][] dp) {
            if (start == s.length()) {
                List<String> list = new ArrayList<>();
                List<List<String>> ans = new ArrayList<>();
                ans.add(list);
                return ans;
            }
            List<List<String>> ans = new ArrayList<>();
            for (int i = start; i < s.length(); i++) {
                if (dp[start][i]) {
                    String left = s.substring(start, i + 1);
                    for (List<String> l : partitionHelper(s, i + 1, dp)) {
                        l.add(0, left);
                        ans.add(l);
                    }
                }

            }
            return ans;
        }

        public List<List<String>> partition1(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            int length = s.length();
            for (int len = 1; len <= length; len++) {
                for (int i = 0; i <= s.length() - len; i++) {
                    dp[i][i + len - 1] = s.charAt(i) == s.charAt(i + len - 1) && (len < 3 || dp[i + 1][i + len - 2]);
                }
            }
            List<List<String>> ans = new ArrayList<>();
            partitionHelper(s, 0, dp, new ArrayList<>(), ans);
            return ans;
        }

        private void partitionHelper(String s, int start, boolean[][] dp, List<String> temp, List<List<String>> res) {
            //到了空串就加到最终的结果中
            if (start == s.length()) {
                res.add(new ArrayList<>(temp));
            }
            //在不同位置切割
            for (int i = start; i < s.length(); i++) {
                //如果是回文串就加到结果中
                if (dp[start][i]) {
                    String left = s.substring(start, i + 1);
                    temp.add(left);
                    partitionHelper(s, i + 1, dp, temp, res);
                    temp.remove(temp.size() - 1);
                }

            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();

            Assert.assertEquals("[[a]]", solution.partition("a").toString());
            Assert.assertEquals("[[a, a, b], [aa, b]]", solution.partition("aab").toString());
            Assert.assertEquals("[[a, a, a, a], [a, a, aa], [a, aa, a], [a, aaa], [aa, a, a], [aa, aa], [aaa, a], [aaaa]]", solution.partition("aaaa").toString());
            Assert.assertEquals("[]", solution.partition("").toString());
        }
    }
}
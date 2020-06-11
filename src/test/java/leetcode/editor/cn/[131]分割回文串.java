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
            return partitionHelper(s, 0);
        }

        private List<List<String>> partitionHelper(String s, int start) {
            if (start == s.length()) {
                List<List<String>> res = new ArrayList<>();
                List<String> sub = new ArrayList<>();
                res.add(sub);
                return res;
            }
            List<List<String>> res = new ArrayList<>();
            int length = s.length();
            for (int i = start; i < length; i++) {
                if (isPalindrome(s, start, i )) {
                    String left = s.substring(start, i + 1);
                    for (List<String> l : partitionHelper(s, i + 1)) {
                        l.add(0, left);
                        res.add(l);
                    }
                }
            }
            return res;
        }

        private boolean isPalindrome(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
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
            List<List<String>> aabResult = solution.partition("aab");
            System.out.println(aabResult);
            System.out.println(solution.partition("aaaa"));
            Assert.assertEquals("", "");
        }
    }
}
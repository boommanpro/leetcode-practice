package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import leetcode.editor.cn.utils.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;

class SolutionTest1239 {
//给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。 
//
// 请返回所有可行解 s 中最长长度。 
//
// 
//
// 示例 1： 
//
// 输入：arr = ["un","iq","ue"]
//输出：4
//解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
// 
//
// 示例 2： 
//
// 输入：arr = ["cha","r","act","ers"]
//输出：6
//解释：可能的解答有 "chaers" 和 "acters"。
// 
//
// 示例 3： 
//
// 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
//输出：26
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 16 
// 1 <= arr[i].length <= 26 
// arr[i] 中只含有小写英文字母 
// 
// Related Topics 位运算 回溯算法 
// 👍 56 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int maxLength;

        public int maxLength(List<String> arr) {
            maxLength = 0;
            //去重获取
            List<String> selectPath = new ArrayList<>();
            for (String path : arr) {
                if (notHadRepeat(path)) {
                    selectPath.add(path);
                }
            }
            boolean[] visited = new boolean[26];
            dfs(selectPath, 0, selectPath.size(), 0, visited);
            return maxLength;
        }

        private void dfs(List<String> selectPath, int start, int n, int len, boolean[] visited) {
            maxLength = Math.max(len, maxLength);
            for (int i = start; i < n; i++) {
                String path = selectPath.get(i);
                if (notHadRepeat(path, visited)) {
                    putCharVisited(path, visited);
                    dfs(selectPath, i + 1, n, len + path.length(), visited);
                    removeCharVisited(path, visited);
                }

            }
        }

        private void removeCharVisited(String path, boolean[] visited) {
            int n = path.length();
            for (int i = 0; i < n; i++) {
                visited[path.charAt(i) - 'a'] = false;
            }
        }

        private void putCharVisited(String path, boolean[] visited) {
            int n = path.length();
            for (int i = 0; i < n; i++) {
                visited[path.charAt(i) - 'a'] = true;
            }
        }

        private boolean notHadRepeat(String path, boolean[] visited) {
            int n = path.length();
            for (int i = 0; i < n; i++) {
                if (visited[path.charAt(i) - 'a']) {
                    return false;
                }
            }
            return true;
        }

        private boolean notHadRepeat(String path) {
            boolean[] visited = new boolean[26];
            int n = path.length();
            for (int i = 0; i < n; i++) {
                int curr = path.charAt(i) - 'a';
                if (visited[curr]) {
                    return false;
                }
                visited[curr] = true;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(4, solution.maxLength(CollectionUtils.from("un", "iq", "ue")));
            Assert.assertEquals(6, solution.maxLength(CollectionUtils.from("cha", "r", "act", "ers")));
            Assert.assertEquals(26, solution.maxLength(CollectionUtils.from("abcdefghijklmnopqrstuvwxyz")));
            Assert.assertEquals(16, solution.maxLength(CollectionUtils.from("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p")));
        }
    }
}
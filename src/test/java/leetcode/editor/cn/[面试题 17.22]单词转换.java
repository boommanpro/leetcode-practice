package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class SolutionTest面试题_17_22 {
//给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。 
//
// 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//["hit","hot","dot","lot","log","cog"]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 深度优先搜索 广度优先搜索 数组 字符串 
// 👍 18 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            Map<String, Boolean> wordMap = wordList.stream().collect(Collectors.toMap(Function.identity(), s -> false));
            if (!wordMap.containsKey(endWord)) {
                return new ArrayList<>();
            }
            List<String> result = new ArrayList<>();
            dfs(beginWord, endWord, new ArrayList<>(), wordMap, result);
            return result;
        }

        private void dfs(String beginWord, String endWord, List<String> path, Map<String, Boolean> selectPath, List<String> result) {
            path.add(beginWord);
            for (String tempWord : getNextWords(beginWord, selectPath)) {
                if (tempWord.equals(endWord)) {
                    path.add(tempWord);
                    result.addAll(path);
                    return;
                }
                dfs(tempWord, endWord, path, selectPath, result);
                path.remove(path.size() - 1);
            }
        }

        private List<String> getNextWords(String beginWord, Map<String, Boolean> selectPath) {
            List<String> result = new ArrayList<>();
            for (Map.Entry<String, Boolean> entry : selectPath.entrySet()) {
                if (!entry.getValue()) {
                    if (compareDiff(beginWord, entry.getKey()) == 1) {
                        result.add(entry.getKey());
                        entry.setValue(true);
                    }
                }
            }
            return result;
        }

        private int compareDiff(String beginWord, String key) {
            int count = 0;
            int n = beginWord.length();
            for (int i = 0; i < n; i++) {
                if (beginWord.charAt(i) != key.charAt(i)) {
                    count++;
                }
                if (count > 1) {
                    return Integer.MAX_VALUE;
                }
            }
            return count;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[hit, hot, lot, log, cog]", solution.findLadders("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))).toString());
            Assert.assertEquals("[]", solution.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")).toString());
        }
    }
}
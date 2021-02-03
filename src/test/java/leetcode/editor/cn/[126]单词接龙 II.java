package leetcode.editor.cn;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

class SolutionTest126 {
//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换后得到的单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
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
// Related Topics 广度优先搜索 数组 字符串 回溯算法 
// 👍 391 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int INF = Integer.MAX_VALUE;

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            Map<String, Integer> wordIdMap = new HashMap<>();
            List<String> idList = new ArrayList<>();
            int len = 0;
            for (String word : wordList) {
                if (!wordIdMap.containsKey(word)) {
                    wordIdMap.put(word, len++);
                    idList.add(word);
                }
            }
            if (!wordIdMap.containsKey(endWord)) {
                return new ArrayList<>();
            }
            if (!wordIdMap.containsKey(beginWord)) {
                wordIdMap.put(beginWord, len++);
                idList.add(beginWord);
            }
            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                edges.add(new ArrayList<>());
                edges.get(i).addAll(getAllConvert(idList.get(i), wordIdMap));
            }
            return bfs(wordIdMap.get(beginWord), wordIdMap.get(endWord), edges, len).stream().map(list -> list.stream().map(idList::get).collect(Collectors.toList())).collect(Collectors.toList());

        }

        private List<List<Integer>> bfs(Integer begin, Integer end, List<List<Integer>> edges, int len) {
            int[] cost = new int[len];
            Arrays.fill(cost, INF);
            cost[begin] = 0;
            Queue<List<Integer>> queue = new LinkedList<>();
            List<Integer> order = new ArrayList<>();
            order.add(begin);
            queue.offer(order);
            List<List<Integer>> ans = new ArrayList<>();
            while (!queue.isEmpty()) {
                List<Integer> curr = queue.poll();
                Integer last = curr.get(curr.size() - 1);
                if (last.equals(end)) {
                    ans.add(curr);
                } else {
                    int n = edges.get(last).size();
                    for (int i = 0; i < n; i++) {
                        if (cost[edges.get(last).get(i)] >= cost[last] + 1) {
                            cost[edges.get(last).get(i)] = cost[last] + 1;
                            List<Integer> tmp = new ArrayList<>(curr);
                            tmp.add(edges.get(last).get(i));
                            queue.offer(tmp);
                        }
                    }
                }
            }
            return ans;
        }

        private List<Integer> getAllConvert(String word, Map<String, Integer> wordMap) {
            char[] words = word.toCharArray();
            int len = words.length;
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                char before = words[i];
                for (int c = 0; c < 26; c++) {
                    char after = (char) (c + 'a');
                    if (before == after) {
                        continue;
                    }
                    words[i] = after;
                    Integer id = wordMap.get(new String(words));
                    if (id != null) {
                        ans.add(id);
                    }
                }
                words[i] = before;
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
            Assert.assertEquals("[[hit, hot, dot, dog, cog], [hit, hot, lot, log, cog]]", ArrayUtils.twoDimensionCollections2String(solution.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
        }
    }

}
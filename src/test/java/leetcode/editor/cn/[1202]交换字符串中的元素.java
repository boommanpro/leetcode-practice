package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1202 {
//给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。 
//
//
// 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。 
//
// 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。 
//
// 
//
// 示例 1: 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2]]
//输出："bacd"
//解释： 
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[1] 和 s[2], s = "bacd"
// 
//
// 示例 2： 
//
// 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
//输出："abcd"
//解释：
//交换 s[0] 和 s[3], s = "bcad"
//交换 s[0] 和 s[2], s = "acbd"
//交换 s[1] 和 s[2], s = "abcd" 
//
// 示例 3： 
//
// 输入：s = "cba", pairs = [[0,1],[1,2]]
//输出："abc"
//解释：
//交换 s[0] 和 s[1], s = "bca"
//交换 s[1] 和 s[2], s = "bac"
//交换 s[0] 和 s[1], s = "abc"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// 0 <= pairs.length <= 10^5 
// 0 <= pairs[i][0], pairs[i][1] < s.length 
// s 中只含有小写英文字母 
// 
// Related Topics 并查集 数组 
// 👍 79 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            char[] array = s.toCharArray();
            UnionFind unionFind = new UnionFind(s.length());
            for (List<Integer> pair : pairs) {
                unionFind.union(pair.get(0), pair.get(1));
            }
            Map<Integer, Set<Integer>> dict = new HashMap<>();
            for (List<Integer> pair : pairs) {
                int i = unionFind.find(pair.get(0));
                Set<Integer> set = dict.getOrDefault(i, new HashSet<>());
                set.add(pair.get(0));
                set.add(pair.get(1));
                dict.put(i, set);
            }
            for (Map.Entry<Integer, Set<Integer>> entry : dict.entrySet()) {
                int[] swapArray = entry.getValue().stream().sorted().mapToInt(Integer::intValue).toArray();
                List<Character> characterList = Arrays.stream(swapArray).mapToObj(value -> array[value]).sorted().collect(Collectors.toList());
                for (int i = 0; i < swapArray.length; i++) {
                    array[swapArray[i]] = characterList.get(i);
                }

            }

            return new String(array);
        }

        public static class UnionFind {

            int[] parent;

            public UnionFind(int n) {
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public void union(int x, int y) {
                int px = find(x);
                int py = find(y);
                if (px == py) {
                    return;
                }
                if (px > py) {
                    parent[py] = px;
                } else {
                    parent[px] = py;
                }
            }

            public int find(int v) {
                if (v != parent[v]) {
                    parent[v] = find(parent[v]);
                }
                return parent[v];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("bacd", solution.smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2))));
            Assert.assertEquals("abcd", solution.smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2), Arrays.asList(0, 2))));
            Assert.assertEquals("abc", solution.smallestStringWithSwaps("cba", Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2))));
        }
    }
}
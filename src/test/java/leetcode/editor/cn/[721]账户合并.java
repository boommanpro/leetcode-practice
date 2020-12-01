package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

class SolutionTest721 {
//给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其
//余元素是 emails 表示该帐户的邮箱地址。 
//
// 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为
//人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。 
//
// 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。 
//
// 例子 1: 
//
// 
//Input: 
//accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnn
//ybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Ma
//ry", "mary@mail.com"]]
//Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.
//com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//Explanation: 
//  第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。 
//  第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
//  我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com'
//]，
//  ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]仍然会被
//接受。
//
// 
//
// 注意： 
//
// 
// accounts的长度将在[1，1000]的范围内。 
// accounts[i]的长度将在[1，10]的范围内。 
// accounts[i][j]的长度将在[1，30]的范围内。 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 130 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] parents;

        Map<String, Integer> indexMap;

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            int len = accounts.size();
            parents = new int[len];
            indexMap = new HashMap<>();
            for (int i = 0; i < len; i++) {
                parents[i] = i;
            }
            for (int i = 0; i < accounts.size(); i++) {
                List<String> values = accounts.get(i);
                for (int j = 1; j < values.size(); j++) {
                    String email = values.get(j);
                    if (indexMap.containsKey(email)) {
                        union(i, indexMap.get(email));
                    }
                    indexMap.put(email, i);
                }
            }
            Map<Integer, TreeSet<String>> ans = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int pi = find(i);
                TreeSet<String> treeSet = ans.getOrDefault(pi, new TreeSet<>());
                treeSet.addAll(accounts.get(i).subList(1, accounts.get(i).size()));
                ans.put(pi, treeSet);
            }

            return ans.entrySet().stream().map(e -> {
                String name = accounts.get(e.getKey()).get(0);
                TreeSet<String> value = e.getValue();
                List<String> row = new ArrayList<>();
                row.add(name);
                row.addAll(value);
                return row;
            }).collect(Collectors.toList());

        }

        private int find(int x) {
            if (parents[x] == x) {
                return x;
            }
            parents[x] = find(parents[x]);
            return parents[x];
        }

        private void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            }
            int min = Math.min(px, py);
            parents[x] = min;
            parents[y] = min;
            parents[px] = min;
            parents[py] = min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[John, john00@mail.com, john_newyork@mail.com, johnsmith@mail.com], [John, johnnybravo@mail.com], [Mary, mary@mail.com]]", ArrayUtils.twoDimensionCollections2String(solution.accountsMerge(
                    Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                            Arrays.asList("John", "johnnybravo@mail.com"),
                            Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                            Arrays.asList("Mary", "mary@mail.com")
                    ))));
        }
    }
}
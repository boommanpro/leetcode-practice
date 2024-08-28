package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest3144 {
//给你一个字符串 s ，你需要将它分割成一个或者更多的 平衡 子字符串。比方说，s == "ababcc" 那么 ("abab", "c", "c") ，(
//"ab", "abc", "c") 和 ("ababcc") 都是合法分割，但是 ("a", "bab", "cc") ，("aba", "bc", "c") 和
// ("ab", "abcc") 不是，不平衡的子字符串用粗体表示。
//
// 请你返回 s 最少 能分割成多少个平衡子字符串。
//
// 注意：一个 平衡 字符串指的是字符串中所有字符出现的次数都相同。
//
//
//
// 示例 1：
//
//
// 输入：s = "fabccddg"
//
//
// 输出：3
//
// 解释：
//
// 我们可以将 s 分割成 3 个子字符串：("fab, "ccdd", "g") 或者 ("fabc", "cd", "dg") 。
//
// 示例 2：
//
//
// 输入：s = "abababaccddb"
//
//
// 输出：2
//
// 解释：
//
// 我们可以将 s 分割成 2 个子字符串：("abab", "abaccddb") 。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 只包含小写英文字母。
//
//
// Related Topics哈希表 | 字符串 | 动态规划 | 计数
//
// 👍 34, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSubstringsInPartition(String S) {
            Map<Integer, List<Integer>> map = new TreeMap<>();
            int n = S.length();
            char[] s = S.toCharArray();
            for (int i = 0; i < n; i++) {
                int[] count = new int[26];
                int max = 1;
                int k = 1;
                count[s[i] - 'a']++;
                ArrayList<Integer> value = new ArrayList<>();
                value.add(i + 1);
                map.put(i, value);
                int r = i + 1;
                while (r < n) {
                    k += count[s[r] - 'a']++ == 0 ? 1 : 0;
                    max = Math.max(count[s[r] - 'a'], max);
                    if (max * k == r - i + 1) {
                        value.add(r + 1);
                    }
                    r++;
                }
            }

            return bfs(map, 0, n);
        }

        private int bfs(Map<Integer, List<Integer>> map, int i, int n) {
            int depth = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            Set<Integer> visited = new HashSet<>();

            while (!queue.isEmpty()) {
                int size = queue.size();
                Set<Integer> nextSet = new HashSet<>();
                while (size-- > 0) {
                    int index = queue.poll();
                    if (index == n) {
                        return depth;
                    }
                    visited.add(index);
                    List<Integer> value = map.get(index);
                    for (Integer next : value) {
                        if (!visited.contains(next)) {
                            nextSet.add(next);
                        }
                    }
                }
                queue.addAll(nextSet);
                depth++;
            }
            return depth;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

        @Test
        public void testMinimumSubstringsInPartition1() {
            String s = "fabccddg";
            int expected = 3;
            Assert.assertEquals(expected, solution.minimumSubstringsInPartition(s));
        }

        @Test
        public void testMinimumSubstringsInPartition2() {
            String s = "abababaccddb";
            int expected = 2;
            Assert.assertEquals(expected, solution.minimumSubstringsInPartition(s));
        }

        @Test
        public void testMinimumSubstringsInPartition3() {
            String s = "gnsustwtuijzzzzhfjjgjymmnmkisuccggggggggggruturycplccccbzdedhhhhhhhhhhhhhnnnghiihgbbbbnnnkii";
            int expected = 22;
            Assert.assertEquals(expected, solution.minimumSubstringsInPartition(s));
        }

        @Test
        public void testMinimumSubstringsInPartition4() {
            String s = "aacbcbaccb";
            int expected = 3;
            Assert.assertEquals(expected, solution.minimumSubstringsInPartition(s));
        }

        @Test
        public void testMinimumSubstringsInPartition5() {
            String s = "booppppjjijjirrtsrsrsrrsopmqosmppoqoputuuttututooytttttffyiilmowuwvvnhrrrrohugrqshtjkhqimpqqqqqnololjuuvvqsvvqquvsuvqjbjhdehgdbjsyfffffffiiiiiiiiiiutefehffhfbbvlslsvqvvptwvbbabababbkkhvvotostgguntnuigedfdhsssssssssnnnnnnnmomomooolllodcvjkihhooodwwwpppppppphhkoikgjlmututqqpnnnnnnnnmnmiiiqllsllollnnqrionrswsptnntnusojwwwwwwrrfeccwxwwxxxwfhfuvuuuvvvvvuuuvuvvvvuvuuuppppppppppiiirrrrrrrpbbopbababassuuzxyzxzuuqhiqlrsiqkihruuccoooooooooooooupfqutwqrfowtodpegjxoswqqqqqqqqqqqqqqqqqqqqqqqqqqqtsnnnnnnnnnnnnnnnnddddxxxxxxxxwxwwxwwwxwwxxxxxxxwusssssuswwwwwwwwwwtrrtrttrsttttshfhuquuuwupfffffffffffffcbdgjjjcjccbcdddgcddbcdjuuutsstufffeeeefeefffffyykgovsbbsvdldjvekqaekpfzxzzxxxxxjjjllllllnmmmllnlnwcccccccccccccccccccutxrrvtkggffffyyyyyyyyyilikmklmlkjhiifnyypmlsqolmtqsbabaabbbbabbbbaaaabtttttttttttooooooomnnmpmonmmfgfmoqhnmfriigssflihqrlgfgtgtanniiipbeeeeeeeeeeeeeypmpoeeeddddddedeeddeedeebbbbbbbbbbbbkdijifhdgalkjjjuuuyyyyyyyyyimfgptsmlqkgfoppfyxymfdncjfobkrnscpdigggxxzzzzzzzzzzzzzzxx";
            int expected = 188;
            Assert.assertEquals(expected, solution.minimumSubstringsInPartition(s));
        }
    }
}

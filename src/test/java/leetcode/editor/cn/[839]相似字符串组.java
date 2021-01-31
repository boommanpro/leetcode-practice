package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

class SolutionTest839 {
//如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。 
//
//
// 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "t
//ars"，"rats"，或 "arts" 相似。 
//
// 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同
//一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。 
//
// 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？ 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["tars","rats","arts","star"]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：strs = ["omv","ovm"]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 100 
// 1 <= strs[i].length <= 1000 
// sum(strs[i].length) <= 2 * 104 
// strs[i] 只包含小写字母。 
// strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。 
// 
//
// 
//
// 备注： 
//
// 字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。 
// Related Topics 深度优先搜索 并查集 图 
// 👍 69 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSimilarGroups(String[] strs) {
            int len = strs.length;
            UF uf = new UF(len);
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (isEq(strs[i], strs[j])) {
                        uf.union(i, j);
                    }
                }
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < len; i++) {
                set.add(uf.find(i));
            }
            return set.size();
        }


        public boolean isEq(String str1, String str2) {
            int len = str1.length();
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    cnt++;
                }
                if (cnt > 2) {
                    return false;
                }
            }
            return true;
        }

        public static final class UF {
            private int[] parents;

            public UF(int n) {
                parents = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = i;
                }
            }

            public boolean union(int x, int y) {
                int px = find(x);
                int py = find(y);
                if (px == py) {
                    return false;
                }
                if (px > py) {
                    int temp = px;
                    px = py;
                    py = temp;
                }
                parents[px] = py;
                return true;
            }

            public int find(int v) {
                if (v != parents[v]) {
                    parents[v] = find(parents[v]);
                }
                return parents[v];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
        }
    }
}
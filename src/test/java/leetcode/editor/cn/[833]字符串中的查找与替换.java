package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

class SolutionTest833 {
//你会得到一个字符串 s (索引从 0 开始)，你必须对它执行 k 个替换操作。替换操作以三个长度均为 k 的并行数组给出：indices, sources,
// targets。 
//
// 要完成第 i 个替换操作: 
//
// 
// 检查 子字符串 sources[i] 是否出现在 原字符串 s 的索引 indices[i] 处。 
// 如果没有出现， 什么也不做 。 
// 如果出现，则用 targets[i] 替换 该子字符串。 
// 
//
// 例如，如果 s = "abcd" ， indices[i] = 0 , sources[i] = "ab"， targets[i] = "eee" ，那么
//替换的结果将是 "eeecd" 。 
//
// 所有替换操作必须 同时 发生，这意味着替换操作不应该影响彼此的索引。测试用例保证元素间不会重叠 。 
//
// 
// 例如，一个 s = "abc" ， indices = [0,1] ， sources = ["ab"，"bc"] 的测试用例将不会生成，因为 "ab" 
//和 "bc" 替换重叠。 
// 
//
// 在对 s 执行所有替换操作后返回 结果字符串 。 
//
// 子字符串 是字符串中连续的字符序列。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：s = "abcd", indices = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
//
//输出："eeebffff"
//解释：
//"a" 从 s 中的索引 0 开始，所以它被替换为 "eee"。
//"cd" 从 s 中的索引 2 开始，所以它被替换为 "ffff"。
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", indices = [0,2], sources = ["ab","ec"], targets = ["eee",
//"ffff"]
//输出："eeecd"
//解释：
//"ab" 从 s 中的索引 0 开始，所以它被替换为 "eee"。
//"ec" 没有从原始的 S 中的索引 2 开始，所以它没有被替换。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// k == indices.length == sources.length == targets.length 
// 1 <= k <= 100 
// 0 <= indices[i] < s.length 
// 1 <= sources[i].length, targets[i].length <= 50 
// s 仅由小写英文字母组成 
// sources[i] 和 targets[i] 仅由小写英文字母组成 
// 
//
// Related Topics数组 | 字符串 | 排序 
//
// 👍 139, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public class ReplacePair{
            private int idx;
            private String source;
            private String target;

            public ReplacePair(int idx, String source, String target) {
                this.idx = idx;
                this.source = source;
                this.target = target;
            }
        }

        public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
            ReplacePair[] pair = new ReplacePair[indices.length];
            for (int i = 0; i < indices.length; i++) {
                pair[i] = new ReplacePair(indices[i], sources[i], targets[i]);
            }
            Arrays.sort(pair, Comparator.comparingInt(o -> o.idx));


            StringBuilder ans = new StringBuilder();
            int r = 0;
            for (int i = 0; i < pair.length; i++) {
                String source = pair[i].source;
                int start = pair[i].idx;
                if (start > r) {
                    ans.append(s, r, start);
                    r = start;
                }

                boolean eq = true;
                for (int begin = start; begin < start + source.length(); begin++) {
                    if (begin >= s.length()) {
                        eq = false;
                        break;
                    }
                    if (s.charAt(begin) != source.charAt(begin - start)) {
                        eq = false;
                        break;
                    }
                }
                if (eq) {
                    ans.append(pair[i].target);
                    r = start + source.length();
                }
            }
            ans.append(s, r, s.length());
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("eeebffff",solution.findReplaceString("abcd",new int[]{0,2},new String[]{"a","cd"},new String[]{"eee","ffff"}));
            Assert.assertEquals("eeecd",solution.findReplaceString("abcd",new int[]{0,2},new String[]{"ab","ec"},new String[]{"eee","ffff"}));
            Assert.assertEquals("vbfrssozp", solution.findReplaceString("vmokgggqzp", new int[]{3, 5, 1}, new String[]{"kg", "ggq", "mo"}, new String[]{"s", "so", "bfr"}));
            Assert.assertEquals("abcde", solution.findReplaceString("abcde", new int[]{2,2}, new String[]{"cdef","bc"}, new String[]{"f","fe"}));
        }

    }
}
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest763 {
//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心算法 双指针 
// 👍 278 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Character, Integer> endDict;

        public List<Integer> partitionLabels(String S) {
            int[] dict = new int[26];
            char[] array = S.toCharArray();
            int len = array.length;
            //填充dict
            for (int i = 0; i < len; i++) {
                dict[array[i] - 'a'] = i;
            }
            List<Integer> partition = new ArrayList<>();
            int start = 0, end = 0;
            for (int i = 0; i < len; i++) {
                end = Math.max(end, dict[S.charAt(i) - 'a']);
                if (i == end) {
                    partition.add(end - start + 1);
                    start = end + 1;
                }

            }
            return partition;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertEquals("[9, 7, 8]", solution.partitionLabels("ababcbacadefegdehijhklij").toString());
            Assert.assertEquals("[1, 9]", solution.partitionLabels("caedbdedda").toString());
        }
    }
}
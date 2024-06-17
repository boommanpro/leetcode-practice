package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

class SolutionTest522 {
//给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。
//
// 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
//
// s 的 子序列可以通过删去字符串 s 中的某些字符实现。
//
//
// 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括
//"aebdc"、 "aeb" 和 "" (空字符串)。
//
//
//
//
// 示例 1：
//
//
//输入: strs = ["aba","cdc","eae"]
//输出: 3
//
//
// 示例 2:
//
//
//输入: strs = ["aaa","aaa","aa"]
//输出: -1
//
//
//
//
// 提示:
//
//
// 2 <= strs.length <= 50
// 1 <= strs[i].length <= 10
// strs[i] 只包含小写英文字母
//
//
// Related Topics数组 | 哈希表 | 双指针 | 字符串 | 排序
//
// 👍 233, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLUSlength(String[] strs) {
            Arrays.sort(strs, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.equals(o2)) {
                        return 0;
                    }
                    if (o1.length() != o2.length()) {
                        return o1.length() - o2.length();
                    }
                    return 1;
                }
            });
            int n = strs.length;
            boolean[] status = new boolean[n];
            Arrays.fill(status, true);
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    if (strs[i].equals(strs[j])) {
                        status[i] = false;
                        status[j] = false;
                    }
                    if (mapContains(strs[i], strs[j])) {
                        status[j] = false;
                    }
                }
                if (status[i]) {
                    return strs[i].length();
                }
            }
            if (status[0]) {
                return strs[0].length();
            }
            return -1;
        }

        private boolean mapContains(String A, String B) {
            int p = 0;
            for (int i = 0; i < B.length(); i++) {
                boolean eq = false;
                while (p < A.length() && !eq) {
                    if (A.charAt(p) == B.charAt(i)) {
                        eq = true;
                    }
                    p++;
                }
                if (!eq) {
                    return false;
                }
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
            Assert.assertEquals(3, solution.findLUSlength(new String[]{"aba", "cdc", "eae"}));
            Assert.assertEquals(-1, solution.findLUSlength(new String[]{"aaa", "aaa", "aa"}));
            Assert.assertEquals(-1, solution.findLUSlength(new String[]{"aabbcc", "aabbcc", "c"}));
            Assert.assertEquals(2, solution.findLUSlength(new String[]{"aabbcc", "aabbcc", "cb"}));
            Assert.assertEquals(1, solution.findLUSlength(new String[]{"aabbcc", "aabbcc", "c", "e"}));
            Assert.assertEquals(2, solution.findLUSlength(new String[]{"aabbcc", "aabbcc", "cb", "abc"}));
        }

    }
}

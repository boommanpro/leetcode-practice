package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionTest187 {
//DNA序列 由一系列核苷酸组成，缩写为
// 'A', 'C', 'G' 和
// 'T'.。
//
//
// 例如，
// "ACGAATTCCG" 是一个 DNA序列 。
//
//
// 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
//
// 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
//
//
// 示例 2：
//
//
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 10⁵
// s[i]=='A'、'C'、'G' or 'T'
//
//
// Related Topics位运算 | 哈希表 | 字符串 | 滑动窗口 | 哈希函数 | 滚动哈希
//
// 👍 530, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Map<String, Integer> dict = new HashMap<>();
            int n = s.length();
            List<String> ans = new ArrayList<>();
            for (int i = 10; i <= n; i++) {
                String sub = s.substring(i - 10, i);
                dict.put(sub, dict.getOrDefault(sub, 0) + 1);
                if (dict.get(sub) == 2) {
                    ans.add(sub);
                }
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
        }

    }
}

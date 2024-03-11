package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionTest3076 {
//给你一个数组 arr ，数组中有 n 个 非空 字符串。
//
// 请你求出一个长度为 n 的字符串 answer ，满足：
//
//
// answer[i] 是 arr[i] 最短 的子字符串，且它不是 arr 中其他任何字符串的子字符串。如果有多个这样的子字符串存在，answer[i] 应
//该是它们中字典序最小的一个。如果不存在这样的子字符串，answer[i] 为空字符串。
//
//
// 请你返回数组 answer 。
//
//
//
// 示例 1：
//
//
//输入：arr = ["cab","ad","bad","c"]
//输出：["ab","","ba",""]
//解释：求解过程如下：
//- 对于字符串 "cab" ，最短没有在其他字符串中出现过的子字符串是 "ca" 或者 "ab" ，我们选择字典序更小的子字符串，也就是 "ab" 。
//- 对于字符串 "ad" ，不存在没有在其他字符串中出现过的子字符串。
//- 对于字符串 "bad" ，最短没有在其他字符串中出现过的子字符串是 "ba" 。
//- 对于字符串 "c" ，不存在没有在其他字符串中出现过的子字符串。
//
//
// 示例 2：
//
//
//输入：arr = ["abc","bcd","abcd"]
//输出：["","","abcd"]
//解释：求解过程如下：
//- 对于字符串 "abc" ，不存在没有在其他字符串中出现过的子字符串。
//- 对于字符串 "bcd" ，不存在没有在其他字符串中出现过的子字符串。
//- 对于字符串 "abcd" ，最短没有在其他字符串中出现过的子字符串是 "abcd" 。
//
//
//
//
// 提示：
//
//
// n == arr.length
// 2 <= n <= 100
// 1 <= arr[i].length <= 20
// arr[i] 只包含小写英文字母。
//
//
// 👍 3, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] shortestSubstrings(String[] arr) {
            int n = arr.length;
            String[] ans = new String[n];
            for (int i = 0; i < n; i++) {
                int len = arr[i].length();
                List<String> temp = new ArrayList<>();
                for (int L = 1; L <= len; L++) {
                    for (int p0 = 0; p0 <= len-L; p0++) {
                        String sub = arr[i].substring(p0, p0+L);
                        boolean notContains = true;
                        for (int j = 0; j < n; j++) {
                            if (i != j) {
                                if (arr[j].contains(sub)) {
                                    notContains = false;
                                    break;
                                }
                            }
                        }
                        if (notContains) {
                            temp.add(sub);
                        }
                    }
                    if (!temp.isEmpty()) {
                        break;
                    }
                }
                ans[i] = temp.stream().sorted().findAny().orElse("");
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
            Assert.assertEquals("[ab, , ba, ]", Arrays.toString(solution.shortestSubstrings(new String[]{"cab", "ad", "bad", "c" })));
            Assert.assertEquals("[, , abcd]", Arrays.toString(solution.shortestSubstrings(new String[]{"abc", "bcd", "abcd" })));
            Assert.assertEquals("[g, x, z, r, i, c, h]", Arrays.toString(solution.shortestSubstrings(new String[]{"gfnt","xn","mdz","yfmr","fi","wwncn","hkdy" })));
        }

    }
}

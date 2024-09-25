package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

class SolutionTest2306 {
//给你一个字符串数组 ideas 表示在公司命名过程中使用的名字列表。公司命名流程如下：
//
//
// 从 ideas 中选择 2 个 不同 名字，称为 ideaA 和 ideaB 。
// 交换 ideaA 和 ideaB 的首字母。
// 如果得到的两个新名字 都 不在 ideas 中，那么 ideaA ideaB（串联 ideaA 和 ideaB ，中间用一个空格分隔）是一个有效的公司名字
//。
// 否则，不是一个有效的名字。
//
//
// 返回 不同 且有效的公司名字的数目。
//
//
//
// 示例 1：
//
// 输入：ideas = ["coffee","donuts","time","toffee"]
//输出：6
//解释：下面列出一些有效的选择方案：
//- ("coffee", "donuts")：对应的公司名字是 "doffee conuts" 。
//- ("donuts", "coffee")：对应的公司名字是 "conuts doffee" 。
//- ("donuts", "time")：对应的公司名字是 "tonuts dime" 。
//- ("donuts", "toffee")：对应的公司名字是 "tonuts doffee" 。
//- ("time", "donuts")：对应的公司名字是 "dime tonuts" 。
//- ("toffee", "donuts")：对应的公司名字是 "doffee tonuts" 。
//因此，总共有 6 个不同的公司名字。
//
//下面列出一些无效的选择方案：
//- ("coffee", "time")：在原数组中存在交换后形成的名字 "toffee" 。
//- ("time", "toffee")：在原数组中存在交换后形成的两个名字。
//- ("coffee", "toffee")：在原数组中存在交换后形成的两个名字。
//
//
// 示例 2：
//
// 输入：ideas = ["lack","back"]
//输出：0
//解释：不存在有效的选择方案。因此，返回 0 。
//
//
//
//
// 提示：
//
//
// 2 <= ideas.length <= 5 * 10⁴
// 1 <= ideas[i].length <= 10
// ideas[i] 由小写英文字母组成
// ideas 中的所有字符串 互不相同
//
//
// Related Topics位运算 | 数组 | 哈希表 | 字符串 | 枚举
//
// 👍 89, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long distinctNames(String[] ideas) {
            Map<Character, Set<String>> map = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                map.put((char) ('a' + i), new HashSet<>());
            }
            for (String idea : ideas) {
                map.get(idea.charAt(0)).add(idea.substring(1));
            }
            long ans = 0;
            for (int i = 1; i < 26; i++) {
                for (int j = 0; j < i; j++) {
                    char c1 = (char) ('a' + j);
                    char c2 = (char) ('a' + i);
                    Set<String> set1 = map.get(c1);
                    Set<String> set2 = map.get(c2);
                    Set<String> intersection = new HashSet<>(set1);
                    intersection.retainAll(set2);
                    ans += (long) (set1.size() - intersection.size()) * (set2.size() - intersection.size());
                }
            }
            return ans * 2;
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
        public void testDistinctNamesExample1() {
            String[] ideas = {"coffee", "donuts", "time", "toffee"};
            assertEquals(6, solution.distinctNames(ideas));
        }

        @Test
        public void testDistinctNamesExample2() {
            String[] ideas = {"lack", "back"};
            assertEquals(0, solution.distinctNames(ideas));
        }
    }
}

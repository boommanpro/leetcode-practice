package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest387 {

    //给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
// 案例: 
//
// 
//s = "leetcode"
//返回 0.
//
//s = "loveleetcode",
//返回 2.
// 
//
// 
//
// 注意事项：您可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int firstUniqChar(String s) {
            LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (linkedHashMap.containsKey(c)) {
                    linkedHashMap.put(c, -1);
                    continue;
                }
                linkedHashMap.put(c, i);
            }
            for (Map.Entry<Character, Integer> entry : linkedHashMap.entrySet()) {
                if (entry.getValue() != -1) {
                    return entry.getValue();
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(0, solution.firstUniqChar("leetcode"));
            Assert.assertEquals(2, solution.firstUniqChar("loveleetcode"));
            Assert.assertEquals(-1, solution.firstUniqChar("ll"));
        }
    }
}
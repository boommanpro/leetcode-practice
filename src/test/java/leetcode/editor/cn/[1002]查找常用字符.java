package leetcode.editor.cn;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1002 {
//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 146 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> commonChars(String[] A) {
            return Arrays.stream(A).map(s -> {
                Map<Character, Integer> map = new HashMap<>();
                for (char c : s.toCharArray()) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
                return map;
            }).reduce((dict1, dict2) -> {
                dict1.replaceAll((k, v) -> Math.min(dict1.get(k), dict2.getOrDefault(k, 0)));
                return dict1;
            }).orElse(new HashMap<>()).entrySet().stream().map(entry -> {
                List<String> result = new ArrayList<>();
                Character c = entry.getKey();
                int count = entry.getValue();
                for (int i = 0; i < count; i++) {
                    result.add(c.toString());
                }
                return result;
            }).flatMap((Function<List<String>, Stream<String>>) strings -> strings.stream()).collect(Collectors.toList());

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[e, l, l]", solution.commonChars(new String[]{"bella", "label", "roller"}).toString());
            Assert.assertEquals("[c, o]", solution.commonChars(new String[]{"cool", "lock", "cook"}).toString());
        }
    }
}
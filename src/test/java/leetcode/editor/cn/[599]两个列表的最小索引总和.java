package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

class SolutionTest599 {
//假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
//
// 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
//
// 示例 1:
//
// 输入:
//["Shogun", "Tapioca Express", "Burger King", "KFC"]
//["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
//输出: ["Shogun"]
//解释: 他们唯一共同喜爱的餐厅是“Shogun”。
//
//
// 示例 2:
//
// 输入:
//["Shogun", "Tapioca Express", "Burger King", "KFC"]
//["KFC", "Shogun", "Burger King"]
//输出: ["Shogun"]
//解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
//
//
// 提示:
//
//
// 两个列表的长度范围都在 [1, 1000]内。
// 两个列表中的字符串的长度将在[1，30]的范围内。
// 下标从0开始，到列表的长度减1。
// 两个列表都没有重复的元素。
//
// Related Topics 哈希表

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(list1[i], list);
            }
            for (int i = 0; i < list2.length; i++) {
                List<Integer> list = map.getOrDefault(list2[i], new ArrayList<>());
                list.add(i);
                map.put(list2[i], list);
            }
            return map
                    .entrySet().stream()
                    .filter(e -> e.getValue().size() == 2)
                    .collect(Collectors.groupingBy(e -> e.getValue()
                            .stream().mapToInt(Integer::intValue).sum(), Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                    .entrySet().stream().min(Comparator.comparingInt(Map.Entry::getKey)).map(e -> e.getValue().toArray(new String[]{}))
                    .orElse(new String[]{});
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertArrayEquals(new String[]{"Shogun"}, solution.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}));
            Assert.assertArrayEquals(new String[]{"Shogun"}, solution.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"}));
        }
    }
}
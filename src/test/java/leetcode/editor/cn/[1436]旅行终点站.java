package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
class SolutionTest1436 {
//给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从
//cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
//
// 题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。
//
//
//
// 示例 1：
//
//
//输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
//输出："Sao Paulo"
//解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" ->
//"Lima" -> "Sao Paulo" 。
//
//
// 示例 2：
//
//
//输入：paths = [["B","C"],["D","B"],["C","A"]]
//输出："A"
//解释：所有可能的线路是：
//"D" -> "B" -> "C" -> "A". 
//"B" -> "C" -> "A". 
//"C" -> "A". 
//"A". 
//显然，旅行终点站是 "A" 。
//
//
// 示例 3：
//
//
//输入：paths = [["A","Z"]]
//输出："Z"
//
//
//
//
// 提示：
//
//
// 1 <= paths.length <= 100
// paths[i].length == 2
// 1 <= cityAi.length, cityBi.length <= 10
// cityAi != cityBi
// 所有字符串均由大小写英文字母和空格字符组成。
//
//
// Related Topics数组 | 哈希表 | 字符串
//
// 👍 150, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
    //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String>  inset = new HashSet<>();
        Set<String> outset = new HashSet<>();
        for (List<String> path : paths) {
            inset.add(path.get(1));
            outset.add(path.get(0));
        }
        for (String s : inset) {
            if (!outset.contains(s)) {
                return s;
            }
        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

    @Test
    public void testDestCity() {
        List<List<String>> paths1 = new ArrayList<>();
        paths1.add(new ArrayList<>(Arrays.asList("London", "New York")));
        paths1.add(new ArrayList<>(Arrays.asList("New York", "Lima")));
        paths1.add(new ArrayList<>(Arrays.asList("Lima", "Sao Paulo")));
        assertEquals("Sao Paulo", solution.destCity(paths1));

        List<List<String>> paths2 = new ArrayList<>();
        paths2.add(new ArrayList<>(Arrays.asList("B", "C")));
        paths2.add(new ArrayList<>(Arrays.asList("D", "B")));
        paths2.add(new ArrayList<>(Arrays.asList("C", "A")));
        assertEquals("A", solution.destCity(paths2));

        List<List<String>> paths3 = new ArrayList<>();
        paths3.add(new ArrayList<>(Arrays.asList("A", "Z")));
        assertEquals("Z", solution.destCity(paths3));
    }
    }
}

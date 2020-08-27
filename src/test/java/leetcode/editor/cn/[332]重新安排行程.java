package leetcode.editor.cn;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class SolutionTest332 {
//给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 
//JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。 
//
// 说明: 
//
// 
// 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排
//序更靠前 
// 所有的机场都用三个大写字母表示（机场代码）。 
// 假定所有机票至少存在一种合理的行程。 
// 
//
// 示例 1: 
//
// 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
// 
//
// 示例 2: 
//
// 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。 
// Related Topics 深度优先搜索 图 
// 👍 179 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //开始位置
        private static final String START = "JFK";

        public List<String> findItinerary(List<List<String>> tickets) {
            int n = tickets.size();
            Map<String, List<String>> map = new TreeMap<>();
            for (List<String> ticket : tickets) {
                List<String> temp = map.get(ticket.get(0));
                if (temp == null) {
                    temp = new ArrayList<>();
                }
                temp.add(ticket.get(1));
                map.put(ticket.get(0), temp);
            }
            for (List<String> value : map.values()) {
                Collections.sort(value);
            }
            List<String> path = new ArrayList<>();
            dfs(map, path, START, 0, n);
            return path;
        }

        private boolean dfs(Map<String, List<String>> selectPath, List<String> path, String start, int i, int n) {
            if (i == n) {
                path.add(start);
                return true;
            }

            List<String> nextList = selectPath.get(start);
            if (nextList == null || nextList.isEmpty()) {
                return false;
            }

            int size = nextList.size();
            for (int k = 0; k < size; k++) {
                path.add(start);
                String next = nextList.get(k);
                nextList.remove(k);
                if (dfs(selectPath, path, next, i + 1, n)) {
                    return true;
                }
                nextList.add(k, next);
                path.remove(path.size() - 1);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[JFK, MUC, LHR, SFO, SJC]", solution.findItinerary(ArrayUtils.twoDimension2List(new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}})).toString());
            Assert.assertEquals("[JFK, ATL, JFK, SFO, ATL, SFO]", solution.findItinerary(ArrayUtils.twoDimension2List(new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}})).toString());
            Assert.assertEquals("[JFK, NRT, JFK, KUL]", solution.findItinerary(ArrayUtils.twoDimension2List(new String[][]{{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}})).toString());
        }
    }
}
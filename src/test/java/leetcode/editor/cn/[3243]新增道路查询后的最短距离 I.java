package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest3243 {
//给你一个整数 n 和一个二维整数数组 queries。
//
// 有 n 个城市，编号从 0 到 n - 1。初始时，每个城市 i 都有一条单向道路通往城市 i + 1（ 0 <= i < n - 1）。
//
// queries[i] = [ui, vi] 表示新建一条从城市 ui 到城市 vi 的单向道路。每次查询后，你需要找到从城市 0 到城市 n - 1 的最
//短路径的长度。
//
// 返回一个数组 answer，对于范围 [0, queries.length - 1] 中的每个 i，answer[i] 是处理完前 i + 1 个查询后，
//从城市 0 到城市 n - 1 的最短路径的长度。
//
//
//
// 示例 1：
//
//
// 输入： n = 5, queries = [[2, 4], [0, 2], [0, 4]]
//
//
// 输出： [3, 2, 1]
//
// 解释：
//
//
//
// 新增一条从 2 到 4 的道路后，从 0 到 4 的最短路径长度为 3。
//
//
//
// 新增一条从 0 到 2 的道路后，从 0 到 4 的最短路径长度为 2。
//
//
//
// 新增一条从 0 到 4 的道路后，从 0 到 4 的最短路径长度为 1。
//
// 示例 2：
//
//
// 输入： n = 4, queries = [[0, 3], [0, 2]]
//
//
// 输出： [1, 1]
//
// 解释：
//
//
//
// 新增一条从 0 到 3 的道路后，从 0 到 3 的最短路径长度为 1。
//
//
//
// 新增一条从 0 到 2 的道路后，从 0 到 3 的最短路径长度仍为 1。
//
//
//
// 提示：
//
//
// 3 <= n <= 500
// 1 <= queries.length <= 500
// queries[i].length == 2
// 0 <= queries[i][0] < queries[i][1] < n
// 1 < queries[i][1] - queries[i][0]
// 查询中没有重复的道路。
//
//
// Related Topics广度优先搜索 | 图 | 数组
//
// 👍 15, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 1; i < n; i++) {
                map.computeIfAbsent(i - 1, k -> new ArrayList<>()).add(i);
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int l = queries[i][0];
                int r = queries[i][1];
                map.get(l).add(r);
                ans[i] = calc(map, 0);
            }
            return ans;
        }

        private int calc(Map<Integer, List<Integer>> map, int start) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            int depth = 0;
            while (!queue.isEmpty()) {
                Set<Integer> sets = new HashSet<>();
                int n = queue.size();
                while (n > 0) {
                    int curr = queue.poll();
                    List<Integer> nexts = map.get(curr);
                    if (nexts == null) {
                        return depth;
                    }
                    sets.addAll(nexts);
                    n--;

                }
                queue.addAll(sets);
                depth++;
            }
            return -1;
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
        public void testExample1() {
            int n = 5;
            int[][] queries = {{2, 4}, {0, 2}, {0, 4}};
            int[] expected = {3, 2, 1};
            Assert.assertArrayEquals(expected, solution.shortestDistanceAfterQueries(n, queries));
        }

        @Test
        public void testExample2() {
            int n = 4;
            int[][] queries = {{0, 3}, {0, 2}};
            int[] expected = {1, 1};
            Assert.assertArrayEquals(expected, solution.shortestDistanceAfterQueries(n, queries));
        }

        @Test
        public void testExample3() {
            int n = 11;
            int[][] queries = {{6, 9}, {3, 5}};
            int[] expected = {8, 7};
            Assert.assertArrayEquals(expected, solution.shortestDistanceAfterQueries(n, queries));
        }

        @Test
        public void testVeryLargeQueries() {
            int n = 500;
            int[][] queries = {{0, 2}, {2, 4}, {4, 6}, {6, 8}, {8, 10}, {10, 12}, {12, 14}, {14, 16}, {16, 18}, {18, 20}, {20, 22}, {22, 24}, {24, 26}, {26, 28}, {28, 30}, {30, 32}, {32, 34}, {34, 36}, {36, 38}, {38, 40}, {40, 42}, {42, 44}, {44, 46}, {46, 48}, {48, 50}, {50, 52}, {52, 54}, {54, 56}, {56, 58}, {58, 60}, {60, 62}, {62, 64}, {64, 66}, {66, 68}, {68, 70}, {70, 72}, {72, 74}, {74, 76}, {76, 78}, {78, 80}, {80, 82}, {82, 84}, {84, 86}, {86, 88}, {88, 90}, {90, 92}, {92, 94}, {94, 96}, {96, 98}, {98, 100}, {100, 102}, {102, 104}, {104, 106}, {106, 108}, {108, 110}, {110, 112}, {112, 114}, {114, 116}, {116, 118}, {118, 120}, {120, 122}, {122, 124}, {124, 126}, {126, 128}, {128, 130}, {130, 132}, {132, 134}, {134, 136}, {136, 138}, {138, 140}, {140, 142}, {142, 144}, {144, 146}, {146, 148}, {148, 150}, {150, 152}, {152, 154}, {154, 156}, {156, 158}, {158, 160}, {160, 162}, {162, 164}, {164, 166}, {166, 168}, {168, 170}, {170, 172}, {172, 174}, {174, 176}, {176, 178}, {178, 180}, {180, 182}, {182, 184}, {184, 186}, {186, 188}, {188, 190}, {190, 192}, {192, 194}, {194, 196}, {196, 198}, {198, 200}, {200, 202}, {202, 204}, {204, 206}, {206, 208}, {208, 210}, {210, 212}, {212, 214}, {214, 216}, {216, 218}, {218, 220}, {220, 222}, {222, 224}, {224, 226}, {226, 228}, {228, 230}, {230, 232}, {232, 234}, {234, 236}, {236, 238}, {238, 240}, {240, 242}, {242, 244}, {244, 246}, {246, 248}, {248, 250}, {250, 252}, {252, 254}, {254, 256}, {256, 258}, {258, 260}, {260, 262}, {262, 264}, {264, 266}, {266, 268}, {268, 270}, {270, 272}, {272, 274}, {274, 276}, {276, 278}, {278, 280}, {280, 282}, {282, 284}, {284, 286}, {286, 288}, {288, 290}, {290, 292}, {292, 294}, {294, 296}, {296, 298}, {298, 300}, {300, 302}, {302, 304}, {304, 306}, {306, 308}, {308, 310}, {310, 312}, {312, 314}, {314, 316}, {316, 318}, {318, 320}, {320, 322}, {322, 324}, {324, 326}, {326, 328}, {328, 330}, {330, 332}, {332, 334}, {334, 336}, {336, 338}, {338, 340}, {340, 342}, {342, 344}, {344, 346}, {346, 348}, {348, 350}, {350, 352}, {352, 354}, {354, 356}, {356, 358}, {358, 360}, {360, 362}, {362, 364}, {364, 366}, {366, 368}, {368, 370}, {370, 372}, {372, 374}, {374, 376}, {376, 378}, {378, 380}, {380, 382}, {382, 384}, {384, 386}, {386, 388}, {388, 390}, {390, 392}, {392, 394}, {394, 396}, {396, 398}, {398, 400}, {400, 402}, {402, 404}, {404, 406}, {406, 408}, {408, 410}, {410, 412}, {412, 414}, {414, 416}, {416, 418}, {418, 420}, {420, 422}, {422, 424}, {424, 426}, {426, 428}, {428, 430}, {430, 432}, {432, 434}, {434, 436}, {436, 438}, {438, 440}, {440, 442}, {442, 444}, {444, 446}, {446, 448}, {448, 450}, {450, 452}, {452, 454}, {454, 456}, {456, 458}, {458, 460}, {460, 462}, {462, 464}, {464, 466}, {466, 468}, {468, 470}, {470, 472}, {472, 474}, {474, 476}, {476, 478}, {478, 480}, {480, 482}, {482, 484}, {484, 486}, {486, 488}, {488, 490}, {490, 492}, {492, 494}, {494, 496}, {496, 498}};
            int[] result = solution.shortestDistanceAfterQueries(n, queries);
            Assert.assertEquals(249, result.length);
        }
    }
}

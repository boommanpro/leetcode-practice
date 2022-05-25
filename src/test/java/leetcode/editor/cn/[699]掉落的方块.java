package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

class SolutionTest699 {
//在无限长的数轴（即 x 轴）上，我们根据给定的顺序放置对应的正方形方块。 
//
// 第 i 个掉落的方块（positions[i] = (left, side_length)）是正方形，其中 left 表示该方块最左边的点位置(
//positions[i][0])，side_length 表示该方块的边长(positions[i][1])。 
//
// 每个方块的底部边缘平行于数轴（即 x 轴），并且从一个比目前所有的落地方块更高的高度掉落而下。在上一个方块结束掉落，并保持静止后，才开始掉落新方块。 
//
// 方块的底边具有非常大的粘性，并将保持固定在它们所接触的任何长度表面上（无论是数轴还是其他方块）。邻接掉落的边不会过早地粘合在一起，因为只有底边才具有粘性。
// 
//
// 
//
// 返回一个堆叠高度列表 ans 。每一个堆叠高度 ans[i] 表示在通过 positions[0], positions[1], ..., 
//positions[i] 表示的方块掉落结束后，目前所有已经落稳的方块堆叠的最高高度。 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: [[1, 2], [2, 3], [6, 1]]
//输出: [2, 5, 5]
//解释:
//
//第一个方块 positions[0] = [1, 2] 掉落：
//_aa
//_aa
//-------
//方块最大高度为 2 。
//
//第二个方块 positions[1] = [2, 3] 掉落：
//__aaa
//__aaa
//__aaa
//_aa__
//_aa__
//--------------
//方块最大高度为5。
//大的方块保持在较小的方块的顶部，不论它的重心在哪里，因为方块的底部边缘有非常大的粘性。
//
//第三个方块 positions[1] = [6, 1] 掉落：
//__aaa
//__aaa
//__aaa
//_aa
//_aa___a
//-------------- 
//方块最大高度为5。
//
//因此，我们返回结果[2, 5, 5]。
// 
//
// 
//
// 示例 2: 
//
// 输入: [[100, 100], [200, 100]]
//输出: [100, 100]
//解释: 相邻的方块不会过早地卡住，只有它们的底部边缘才能粘在表面上。
// 
//
// 
//
// 注意: 
//
// 
// 1 <= positions.length <= 1000. 
// 1 <= positions[i][0] <= 10^8. 
// 1 <= positions[i][1] <= 10^6. 
// 
//
// 
// Related Topics 线段树 数组 有序集合 👍 73 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public static class Interval implements Comparable<Interval> {
            private int x;
            private int y;
            private int h;

            public Interval(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public Interval(int x, int y, int h) {
                this.x = x;
                this.y = y;
                this.h = h;
            }

            @Override
            public int compareTo(Interval o) {
                return this.y - o.y;
            }
        }

        public List<Integer> fallingSquares(int[][] positions) {
            TreeSet<Interval> set = new TreeSet<>();
            List<Integer> ans = new ArrayList<>();
            int globalMaxHeight = 0;
            for (int[] position : positions) {
                int x = position[0];
                int y = x + position[1];
                int currHeight = position[1];
                int currMaxHeight = 0;
                Iterator<Interval> iterator = set.tailSet(new Interval(0, x), false).iterator();
                List<Interval> addList = new ArrayList<>();
                while (iterator.hasNext()) {
                    Interval next = iterator.next();
                    if (next.x >= y) {
                        break;
                    }
                    currMaxHeight = Math.max(currMaxHeight, next.h);
                    iterator.remove();
                    if (x > next.x) {
                        addList.add(new Interval(next.x, x, next.h));
                    }
                    if (next.y > y) {
                        addList.add(new Interval(y, next.y, next.h));
                    }
                }
                set.addAll(addList);
                set.add(new Interval(x, y, currHeight + currMaxHeight));
                globalMaxHeight = Math.max(currHeight + currMaxHeight, globalMaxHeight);
                ans.add(globalMaxHeight);
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
            Assert.assertEquals("[2, 5, 5]", solution.fallingSquares(new int[][]{{1, 2}, {2, 3}, {6, 1}}).toString());
            Assert.assertEquals("[100, 100]", solution.fallingSquares(new int[][]{{100, 100}, {200, 100}}).toString());
            Assert.assertEquals("[2, 8, 8]", solution.fallingSquares(new int[][]{{3, 2}, {9, 8}, {4, 4}}).toString());
            Assert.assertEquals("[10, 17, 19, 19, 25]", solution.fallingSquares(new int[][]{{5, 10}, {1, 7}, {1, 2}, {9, 3}, {1, 6}}).toString());
        }

    }
}
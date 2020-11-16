package leetcode.editor.cn;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

class SolutionTest406 {
//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
// Related Topics 贪心算法 
// 👍 657 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (p1, p2) -> {
                if (p1[0] != p2[0]) {
                    return p1[0] - p2[0];
                } else {
                    return p2[1] - p1[1];
                }
            });
            int n = people.length;
            int[][] ans = new int[n][];
            for (int[] person : people) {
                int spaces = person[1] + 1;
                for (int i = 0; i < n; ++i) {
                    if (ans[i] == null) {
                        --spaces;
                        if (spaces == 0) {
                            ans[i] = person;
                            break;
                        }
                    }
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
            Assert.assertEquals("[[5, 0],[7, 0],[5, 2],[6, 1],[4, 4],[7, 1]]", ArrayUtils.twoDimension2String(solution.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));
        }
    }
}
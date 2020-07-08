package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题08_10 {
//编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。 
//
// 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的横坐标为 sr 纵坐标为 sc。需要填充的新颜色为 newColor 。 
//
// 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。 
//
// 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。 
//
// 
//
// 示例： 
//
// 输入：
//image = [[1,1,1],[1,1,0],[1,0,1]] 
//sr = 1, sc = 1, newColor = 2
//输出：[[2,2,2],[2,2,0],[2,0,1]]
//解释: 
//初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
//初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
//注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
// 
//
// 
//
// 提示： 
//
// 
// image 和 image[0] 的长度均在范围 [1, 50] 内。 
// 初始坐标点 (sr,sc) 满足 0 <= sr < image.length 和 0 <= sc < image[0].length 。 
// image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535] 内。 
// 
// Related Topics 深度优先搜索

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int m = image.length;
            int n = image[0].length;
            int sourceColor = image[sr][sc];
            if (sourceColor == newColor) {
                return image;
            }
            int[][] step = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            HashSet<Integer> visited = new HashSet<>();
            Deque<int[]> queue = new LinkedList<>();
            //把开始位置推入,进行四周遍历
            queue.offer(new int[]{sr, sc});
            visited.add(convertValue(sr, sc, m, n));

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    int[] v = queue.poll();
                    size--;
                    int x = v[0];
                    int y = v[1];
                    image[x][y] = newColor;
                    for (int i = 0; i < 4; i++) {
                        int tempX = x + step[i][0];
                        int tempY = y + step[i][1];
                        int tempValue = convertValue(tempX, tempY, m, n);
                        if (tempX >= 0 && tempX < m && tempY >= 0 && tempY < n && image[tempX][tempY] == sourceColor && !visited.contains(tempValue)) {
                            queue.offer(new int[]{tempX, tempY});
                            visited.add(tempValue);
                        }
                    }
                }
            }
            return image;
        }

        private int convertValue(int x, int y, int m, int n) {
            int max = Math.max(m, n);
            return x * max + y;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            int[][] image0 = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
            Assert.assertEquals("[[2, 2, 2],[2, 2, 0],[2, 0, 1]]", ArrayUtils.twoDimension2String(solution.floodFill(image0, 1, 1, 2)));
            int[][] image1 = new int[][]{{0, 0, 0,}, {0, 0, 0}};
            Assert.assertEquals("[[2, 2, 2],[2, 2, 2]]", ArrayUtils.twoDimension2String(solution.floodFill(image1, 0, 0, 2)));

        }
    }
}
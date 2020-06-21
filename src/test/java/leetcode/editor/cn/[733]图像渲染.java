package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

class SolutionTest733 {
//有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。 
//
// 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。 
//
// 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方
//向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。 
//
// 最后返回经过上色渲染后的图像。 
//
// 示例 1: 
//
// 
//输入: 
//image = [[1,1,1],[1,1,0],[1,0,1]]
//sr = 1, sc = 1, newColor = 2
//输出: [[2,2,2],[2,2,0],[2,0,1]]
//解析:
//在图像的正中间，(坐标(sr,sc)=(1,1)),
//在路径上所有符合条件的像素点的颜色都被更改成2。
//注意，右下角的像素没有更改为2，
//因为它不是在上下左右四个方向上与初始点相连的像素点。
//
//
// 注意:
//
//
// image 和 image[0] 的长度在范围 [1, 50] 内。
// 给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
// image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
//
// Related Topics 深度优先搜索

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            //只要和这个颜色相同
            int source = image[sr][sc];
            int m = image.length;
            int n = image[0].length;
            Set<Integer> visited = new HashSet<>();
            visited.add(sr * n + sc);
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{sr, sc});
            int[] dx = new int[]{1, -1, 0, 0};
            int[] dy = new int[]{0, 0, 1, -1};
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                image[x][y] = newColor;
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    if (newX >= 0 && newY >= 0 && newX < m && newY < n && image[newX][newY] == source) {
                        int value = newX * n + newY;
                        if (!visited.contains(value)) {
                            visited.add(value);
                            queue.offer(new int[]{newX, newY});
                        }
                    }
                }
            }
            return image;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[2, 2, 2],[2, 2, 0],[2, 0, 1]]", twoDimensionToString(solution.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
            Assert.assertEquals("[[0, 0, 0],[0, 2, 0]]", twoDimensionToString(solution.floodFill(new int[][]{{0, 0, 0}, {0, 1, 0},}, 1, 1, 2)));
            Assert.assertEquals("[[0, 0, 0],[0, 1, 1]]", twoDimensionToString(solution.floodFill(new int[][]{{0, 0, 0}, {0, 1, 1},}, 1, 1, 1)));
        }


        public String twoDimensionToString(int[][] nums) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < nums.length; i++) {
                sb.append(Arrays.toString(nums[i]));
                if (i != nums.length - 1) {
                    sb.append(",");
                }
            }

            sb.append("]");
            return sb.toString();
        }
    }
}
package leetcode.editor.cn;

import javafx.scene.chart.ValueAxis;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

class SolutionTest427 {
//给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。 
//
// 你需要返回能表示矩阵的 四叉树 的根结点。 
//
// 注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。 
//
// 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性： 
//
// 
// val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False； 
// isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。 
// 
//
// class Node {
//    public boolean val;
//    public boolean isLeaf;
//    public Node topLeft;
//    public Node topRight;
//    public Node bottomLeft;
//    public Node bottomRight;
//} 
//
// 我们可以按以下步骤为二维区域构建四叉树： 
//
// 
// 如果当前网格的值相同（即，全为 0 或者全为 1），将 isLeaf 设为 True ，将 val 设为网格相应的值，并将四个子节点都设为 Null 然后
//停止。 
// 如果当前网格的值不同，将 isLeaf 设为 False， 将 val 设为任意值，然后如下图所示，将当前网格划分为四个子网格。 
// 使用适当的子网格递归每个子节点。 
// 
//
// 
//
// 如果你想了解更多关于四叉树的内容，可以参考 wiki 。 
//
// 四叉树格式： 
//
// 输出为使用层序遍历后四叉树的序列化形式，其中 null 表示路径终止符，其下面不存在节点。 
//
// 它与二叉树的序列化非常相似。唯一的区别是节点以列表形式表示 [isLeaf, val] 。 
//
// 如果 isLeaf 或者 val 的值为 True ，则表示它在列表 [isLeaf, val] 中的值为 1 ；如果 isLeaf 或者 val 的值为
// False ，则表示值为 0 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[0,1],[1,0]]
//输出：[[0,1],[1,0],[1,1],[1,1],[1,0]]
//解释：此示例的解释如下：
//请注意，在下面四叉树的图示中，0 表示 false，1 表示 True 。
//
// 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1
//,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]
//输出：[[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
//
//解释：网格中的所有值都不相同。我们将网格划分为四个子网格。
//topLeft，bottomLeft 和 bottomRight 均具有相同的值。
//topRight 具有不同的值，因此我们将其再分为 4 个子网格，这样每个子网格都具有相同的值。
//解释如下图所示：
//
// 
//
// 示例 3： 
//
// 输入：grid = [[1,1],[1,1]]
//输出：[[1,1]]
// 
//
// 示例 4： 
//
// 输入：grid = [[0]]
//输出：[[1,0]]
// 
//
// 示例 5： 
//
// 输入：grid = [[1,1,0,0],[1,1,0,0],[0,0,1,1],[0,0,1,1]]
//输出：[[0,1],[1,1],[1,0],[1,0],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// n == 2^x 其中 0 <= x <= 6 
// 
// Related Topics 树 数组 分治 矩阵 👍 92 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

    class Solution {
        public Node construct(int[][] grid) {
            return dfs(grid, 0, 0, grid.length, grid.length);
        }

        private Node dfs(int[][] grid, int r0, int c0, int r1, int c1) {
            boolean same = true;
            for (int i = r0; i < r1; i++) {
                for (int j = c0; j < c1; j++) {
                    if (grid[i][j] != grid[r0][c0]) {
                        same = false;
                        break;
                    }
                }
                if (!same) {
                    break;
                }
            }
            //如果全部相等，则为叶子节点
            if (same) {
                return new Node(grid[r0][c0] == 1, true);
            }
            Node node = new Node(
                    true,
                    false,
                    dfs(grid, r0, c0, (r0 + r1) / 2, (c0 + c1) / 2),
                    dfs(grid, r0, (c0 + c1) / 2, (r0 + r1) / 2, c1),
                    dfs(grid, (r0 + r1) / 2, c0, r1, (c0 + c1) / 2),
                    dfs(grid, (r0 + r1) / 2, (c0 + c1) / 2, r1, c1)

            );
            return node;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        @Override
        public String toString() {
            List<List<Boolean>> result = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node curr = queue.poll();
                if (curr == null) {
                    result.add(null);
                } else {
                    result.add(Arrays.asList(curr.isLeaf, curr.val));
                    if (!curr.isLeaf) {
                        queue.add(curr.topLeft);
                        queue.add(curr.topRight);
                        queue.add(curr.bottomLeft);
                        queue.add(curr.bottomRight);
                    }
                }
            }
            return result.stream().map(list -> Optional.ofNullable(list).map(l -> l.stream().map(v -> v ? 1 : 0).collect(Collectors.toList()).toString()).orElse("null")).collect(Collectors.toList()).toString();
        }
    }

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[0, 1], [1, 1], [0, 1], [1, 1], [1, 0], [1, 0], [1, 0], [1, 1], [1, 1]]", solution.construct(new int[][]{
                    {1, 1, 1, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 0, 0, 0, 0}
            }).toString());
            Assert.assertEquals("[[1, 0]]", solution.construct(new int[][]{{0}}).toString());
            Assert.assertEquals("[[1, 1]]", solution.construct(new int[][]{{1, 1}, {1, 1}}).toString());
        }

    }
}
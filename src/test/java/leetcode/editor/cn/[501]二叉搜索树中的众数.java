package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class SolutionTest501 {
//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 138 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    class Solution {
        List<Integer> all;

        public int[] findMode(TreeNode root) {
            if (root == null) {
                return new int[]{};
            }
            all = new ArrayList<>();
            dfs(root);
            Map<Integer, Long> dict = all.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            long calc = 0;
            for (Long value : dict.values()) {
                calc = Math.max(calc, value);
            }
            final long max = calc;
            return dict.entrySet().stream()
                    .filter(e -> e.getValue().equals(max))
                    .map(Map.Entry::getKey)
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

        private void dfs(TreeNode root) {
            if (root != null) {
                dfs(root.left);
                all.add(root.val);
                dfs(root.right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[2]", Arrays.toString(solution.findMode(TreeNode.getTreeNode(new Integer[]{1, null, 2, 2}))));
        }
    }
}
package leetcode.editor.cn;

import lombok.Data;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wangqimeng
 * @date 2020/6/12 18:25
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    /**
     * 通过Integer 数组构建树,编写测试用例使用
     */
    @SuppressWarnings("all")
    public static TreeNode getTreeNode(Integer[] nums) {
        //如果长度为0,返回null
        if (nums == null || nums.length == 0) throw new ArrayStoreException("数组数据异常.数组不能为null or length == 0");
        //创建队列存储数据
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        // 创建一个根节点
        TreeNode root = new TreeNode(nums[0]);
        //在队列尾部插入root节点
        nodeQueue.offer(root);
        //指针当前节点
        TreeNode cur;
        // 记录当前行节点的数量（注意不一定是2的幂，而是上一行中非空节点的数量乘2）
        int lineNodeNum = 2;
        // 记录当前行中数字在数组中的开始位置
        int startIndex = 1;
        // 记录数组中剩余的元素的数量
        int restLength = nums.length - 1;

        while (restLength > 0) {
            //只有最后一行可以不满，其余行必须是满的
            // 若输入的数组的数量是错误的 即restLength-1 < nodeQueue.size()，直接跳出程序
            for (int i = startIndex; i < startIndex + lineNodeNum; i = i + 2) {
                // 说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i == nums.length) {
                    return root;
                }
                cur = nodeQueue.poll();
                if (nums[i] != null) {
                    cur.left = new TreeNode(nums[i]);
                    nodeQueue.offer(cur.left);
                }
                // 同上，说明已经将nums中的数字用完，此时应停止遍历，并可以直接返回root
                if (i + 1 == nums.length) return root;
                if (nums[i + 1] != null) {
                    cur.right = new TreeNode(nums[i + 1]);
                    nodeQueue.offer(cur.right);
                }
            }
            startIndex += lineNodeNum;
            restLength -= lineNodeNum;
            lineNodeNum = nodeQueue.size() * 2;
        }

        return root;

    }
}
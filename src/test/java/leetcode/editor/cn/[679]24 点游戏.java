package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest679 {
//你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。 
//
// 示例 1: 
//
// 输入: [4, 1, 8, 7]
//输出: True
//解释: (8-4) * (7-1) = 24
// 
//
// 示例 2: 
//
// 输入: [1, 2, 1, 2]
//输出: False
// 
//
// 注意: 
//
// 
// 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。 
// 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允
//许的。 
// 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。 
// 
// Related Topics 深度优先搜索 
// 👍 134 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int TARGET = 24;

        private static final double PRECISION = 1e-6;

        public boolean judgePoint24(int[] nums) {
            List<Double> selectPath = new ArrayList<>();
            for (int num : nums) {
                selectPath.add(((double) num));
            }
            return solve(selectPath);
        }

        private boolean solve(List<Double> selectPath) {
            if (selectPath.isEmpty()) {
                return false;
            }
            if (selectPath.size() == 1) {
                return Math.abs(selectPath.get(0) - TARGET) < PRECISION;
            }
            int n = selectPath.size();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //取出要进行操作的两个数
                    if (i != j) {
                        List<Double> tempPath = new ArrayList<>();
                        for (int k = 0; k < n; k++) {
                            //将不进行操作的数进行填充
                            if (k != i && k != j) {
                                tempPath.add(selectPath.get(k));
                            }
                        }

                        //进行 加减乘除四种运算
                        for (int operation = 0; operation < 4; operation++) {

                            if (operation == 0) {
                                tempPath.add(selectPath.get(i) + selectPath.get(j));
                            }else if (operation==1){
                                tempPath.add(selectPath.get(i) - selectPath.get(j));
                            } else if (operation == 2) {
                                tempPath.add(selectPath.get(i) * selectPath.get(j));
                            }else {
                                if (selectPath.get(j) < PRECISION) {
                                    continue;
                                }
                                tempPath.add(selectPath.get(i) / selectPath.get(j));
                            }

                            if (solve(tempPath)) {
                                return true;
                            }
                            tempPath.remove(tempPath.size() - 1);
                        }

                    }
                }
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
            Assert.assertTrue(solution.judgePoint24(new int[]{4, 1, 8, 7}));
            Assert.assertFalse(solution.judgePoint24(new int[]{1, 2, 1, 2}));
        }
    }
}
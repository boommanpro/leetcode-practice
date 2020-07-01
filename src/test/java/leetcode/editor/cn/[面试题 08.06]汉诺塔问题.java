package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionTest面试题08_06 {
//在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只
//能放在更大的盘子上面)。移动圆盘时受到以下限制: 
//(1) 每次只能移动一个盘子; 
//(2) 盘子只能从柱子顶端滑出移到下一根柱子; 
//(3) 盘子只能叠在比它大的盘子上。 
//
// 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。 
//
// 你需要原地修改栈。 
//
// 示例1: 
//
//  输入：A = [2, 1, 0], B = [], C = []
// 输出：C = [2, 1, 0]
// 
//
// 示例2: 
//
//  输入：A = [1, 0], B = [], C = []
// 输出：C = [1, 0]
// 
//
// 提示: 
//
// 
// A中盘子的数目不大于14个。 
// 
// Related Topics 递归

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            if (A == null || B == null || C == null) {
                return;
            }
            move(A.size(), A, B, C);
        }

        private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
            if (n < 1) {
                return;
            }
            move(n - 1, A, C, B);
            Integer num = A.get(A.size() - 1);
            A.remove(num);
            C.add(num);
            move(n - 1, B, A, C);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            List<Integer> C1 = new ArrayList<>();
            solution.hanota(new ArrayList<>(Arrays.asList(2, 1, 0)), new ArrayList<>(), C1);
            Assert.assertEquals("[2, 1, 0]", C1.toString());
            List<Integer> C2 = new ArrayList<>();
            solution.hanota(new ArrayList<>(Arrays.asList(1, 0)), new ArrayList<>(), C2);
            Assert.assertEquals("[1, 0]", C2.toString());
            List<Integer> C3 = new ArrayList<>();
            solution.hanota(new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1, 0)), new ArrayList<>(), C3);
            Assert.assertEquals("[5, 4, 3, 2, 1, 0]", C3.toString());
        }
    }
}
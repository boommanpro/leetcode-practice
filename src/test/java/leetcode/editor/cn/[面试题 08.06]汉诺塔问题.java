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

        private List<Integer> watchA;

        private List<Integer> watchB;

        private List<Integer> watchC;

        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            watchA = A;
            watchB = B;
            watchC = C;
            int n = A.size();
            move(n, A, B, C);
        }

        private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
            //我们将汉诺塔问题分割成 n-1个顶部和 1个底部的递归调用问题
            //因为只能使用栈的思想所以
            //所以我们操作list要像操作栈一样
            //后进先出
            // 每次pop最小的元素 即-> A.remove(A.size-1)
            // 每次push 进入就是A.add()
            if (n == 1) {
                C.add(A.remove(A.size() - 1));
                return;
            }
            //如果n=2的话  需要先把A的0先移动到B  然后把A的1移动到C 再把B移动到C 递归就如下了
            move(n - 1, A, C, B);
            C.add(A.remove(A.size() - 1));
            move(n - 1, B, A, C);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            List<Integer> C0 = new ArrayList<>();
            solution.hanota(new ArrayList<>(Arrays.asList(0)), new ArrayList<>(), C0);
            Assert.assertEquals("[0]", C0.toString());
            List<Integer> C1 = new ArrayList<>();
            solution.hanota(new ArrayList<>(Arrays.asList(1, 0)), new ArrayList<>(), C1);
            Assert.assertEquals("[1, 0]", C1.toString());
            List<Integer> C2 = new ArrayList<>();
            solution.hanota(new ArrayList<>(Arrays.asList(2, 1, 0)), new ArrayList<>(), C2);
            Assert.assertEquals("[2, 1, 0]", C2.toString());
            List<Integer> C3 = new ArrayList<>();
            solution.hanota(new ArrayList<>(Arrays.asList(3, 2, 1, 0)), new ArrayList<>(), C3);
            Assert.assertEquals("[3, 2, 1, 0]", C3.toString());
            List<Integer> C4 = new ArrayList<>();
            solution.hanota(new ArrayList<>(Arrays.asList(4, 3, 2, 1, 0)), new ArrayList<>(), C4);
            Assert.assertEquals("[4, 3, 2, 1, 0]", C4.toString());
            List<Integer> C5 = new ArrayList<>();
            solution.hanota(new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1, 0)), new ArrayList<>(), C5);
            Assert.assertEquals("[5, 4, 3, 2, 1, 0]", C5.toString());
        }
    }
}
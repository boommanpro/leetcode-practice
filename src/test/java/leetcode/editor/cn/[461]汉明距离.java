package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest461 {

    //两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。 
//
// 注意： 
//0 ≤ x, y < 231. 
//
// 示例: 
//
// 
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
// 
// Related Topics 位运算
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int hammingDistance(int x, int y) {
            int dis = x ^ y;
            int cnt = 0;
            while (dis != 0) {
                if ((dis & 1) == 1){
                    cnt++;
                }
                dis >>= 1;
            }
            return cnt;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        //位运算知识link: https://blog.csdn.net/mengzhengjie/article/details/80611422

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.hammingDistance(1, 4));
            Assert.assertEquals(5, solution.hammingDistance(125, 200));

        }
    }
}
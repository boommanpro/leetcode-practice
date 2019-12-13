package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest171 {

    //给定一个Excel表格中的列名称，返回其相应的列序号。
//
// 例如， 
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 示例 1: 
//
// 输入: "A"
//输出: 1
// 
//
// 示例 2: 
//
// 输入: "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 输入: "ZY"
//输出: 701        (Z)26*26+(Y)25
//
// 致谢： 
//特别感谢 @ts 添加此问题并创建所有测试用例。 
// Related Topics 数学
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int titleToNumber(String s) {
            int ans = 0;
            for(int i=0;i<s.length();i++) {
                int num = s.charAt(i) - 'A' + 1;
                ans = ans * 26 + num;
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
            Assert.assertEquals(1, solution.titleToNumber("A"));
            Assert.assertEquals(28, solution.titleToNumber("AB"));
            Assert.assertEquals(701, solution.titleToNumber("ZY"));
            Assert.assertEquals(18302, solution.titleToNumber("AAAX"));

        }
    }
}
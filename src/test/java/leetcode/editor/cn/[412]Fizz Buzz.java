package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest412 {

    //写一个程序，输出从 1 到 n 数字的字符串表示。
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
//
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> fizzBuzz(int n) {
            List<String> result = new ArrayList<>(n);
            for (int i = 1; i <= n; i++) {
                result.add(getNFizzBuzz(i));
            }
            return result;
        }

        private String getNFizzBuzz(int n) {
            boolean multiple3 = n % 3 == 0;
            boolean multiple5 = n % 5 == 0;
            if (!multiple3 && !multiple5) {
                return String.valueOf(n);
            }
            StringBuilder result = new StringBuilder();
            if (multiple3) {
                result.append("Fizz");
            }
            if (multiple5) {
                result.append("Buzz");
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[1, 2, Fizz]", solution.fizzBuzz(3).toString());
        }
    }
}
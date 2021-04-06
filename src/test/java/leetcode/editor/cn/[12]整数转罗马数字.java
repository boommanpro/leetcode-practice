package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest12 {
//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。 
//
// 
//
// 示例 1: 
//
// 
//输入: 3
//输出: "III" 
//
// 示例 2: 
//
// 
//输入: 4
//输出: "IV" 
//
// 示例 3: 
//
// 
//输入: 9
//输出: "IX" 
//
// 示例 4: 
//
// 
//输入: 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 
//输入: 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 3999 
// 
// Related Topics 数学 字符串 
// 👍 531 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Integer, String> dict = new HashMap<>();

        public void initDict() {

            //I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
            //X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
            //C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
            dict.put(1, "I");
            dict.put(2, "II");
            dict.put(3, "III");
            dict.put(4, "IV");
            dict.put(5, "V");
            dict.put(6, "VI");
            dict.put(7, "VII");
            dict.put(8, "VIII");
            dict.put(9, "IX");
            dict.put(10, "X");
            dict.put(20, "XX");
            dict.put(30, "XXX");
            dict.put(40, "XL");
            dict.put(50, "L");
            dict.put(60, "LX");
            dict.put(70, "LXX");
            dict.put(80, "LXXX");
            dict.put(90, "XC");
            dict.put(100, "C");
            dict.put(200, "CC");
            dict.put(300, "CCC");
            dict.put(400, "CD");
            dict.put(500, "D");
            dict.put(600, "DC");
            dict.put(700, "DCC");
            dict.put(800, "DCCC");
            dict.put(900, "CM");
            dict.put(1000, "M");
            dict.put(2000, "MM");
            dict.put(3000, "MMM");
        }

        public String intToRoman(int num) {
            initDict();
            return getV(num - num % 1000) + getV(num % 1000 - num % 100) + getV(num % 100 - num % 10) + getV(num % 10);
        }

        public String getV(int v) {
            return dict.getOrDefault(v, "");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("III", solution.intToRoman(3));
            Assert.assertEquals("IV", solution.intToRoman(4));
            Assert.assertEquals("IX", solution.intToRoman(9));
            Assert.assertEquals("XXVII", solution.intToRoman(27));
            Assert.assertEquals("LVIII", solution.intToRoman(58));
            Assert.assertEquals("MCMXCIV", solution.intToRoman(1994));
            Assert.assertEquals("MMMCMXCIX", solution.intToRoman(3999));
        }
    }
}
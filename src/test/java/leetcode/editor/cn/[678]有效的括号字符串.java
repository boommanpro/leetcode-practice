package leetcode.editor.cn;

import java.util.Stack;

import jdk.nashorn.internal.ir.IfNode;
import org.junit.Assert;
import org.junit.Test;

class SolutionTest678 {

    //给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
//
// 
// 任何左括号 ( 必须有相应的右括号 )。 
// 任何右括号 ) 必须有相应的左括号 ( 。 
// 左括号 ( 必须在对应的右括号之前 )。 
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。 
// 一个空字符串也被视为有效字符串。 
// 
//
// 示例 1: 
//
// 
//输入: "()"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "(*)"
//输出: True
// 
//
// 示例 3: 
//
// 
//输入: "(*))"
//输出: True
// 
//
// 注意: 
//
// 
// 字符串大小将在 [1，100] 范围内。 
// 
// Related Topics 字符串
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean checkValidString0(String s) {
            //l代表左括号比较多，星号作为右括号时左括号的数量
            int l = 0;
            //h代表右括号比较多，星号作为左括号时左括号的数量
            int h = 0;
            for (int i = 0; i < s.length(); i++) {
                char tmp = s.charAt(i);
                if (tmp == '(') {
                    // ( l和h都增加
                    l++;
                    h++;
                } else if (tmp == ')') {
                    // ） 如果l不为空，说明左括号比较多，则l--.同时因为h也是代表左括号的数量，所以相应的h--
                    if (l > 0) {
                        l--;
                    }
                    h--;
                } else if (tmp == '*') {
                    // * 如果l不为空，说明左括号比较多，星号作为右括号则l--.同时h是星号作为左括号，所以h++
                    if (l > 0) {
                        l--;
                    }
                    h++;
                }
                if (h < 0) {
                    // h < 0.说明将*当做左括号也不够，返回false
                    return false;
                }
            }
            //  同时查看l == 0，如果不等于0，说明将星号视为右括号也不够左括号数量。
            return l == 0;
        }

        public boolean checkValidString(String s) {
            Stack<Integer> leftStack = new Stack<>();
            Stack<Integer> anyStack = new Stack<>();


            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case '(':
                        leftStack.add(i);
                        break;
                    case ')':
                        if (!leftStack.isEmpty()) {
                            leftStack.pop();
                        } else if (!anyStack.isEmpty()) {
                            anyStack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case '*':
                        anyStack.add(i);
                    default:
                        break;
                }
            }
            if (leftStack.isEmpty()) {
                return true;
            }
            while (!leftStack.isEmpty()) {
                if (anyStack.isEmpty()) {
                    return false;
                }
                //*(
                if (leftStack.pop() > anyStack.pop()) {
                    return false;
                }
            }
            return true;
        }
    }

    //

//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.checkValidString("()"));
            Assert.assertTrue(solution.checkValidString("(*)"));
            Assert.assertTrue(solution.checkValidString("(*))"));
            Assert.assertTrue(solution.checkValidString("(())**"));
            Assert.assertTrue(solution.checkValidString("(*()"));
            Assert.assertFalse(solution.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        }
    }
}
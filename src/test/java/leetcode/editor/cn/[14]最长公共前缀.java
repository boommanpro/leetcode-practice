package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;
class SolutionTest14 {
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串
    public static
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        //1.找到最短元素的长度
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(str.length(), minLen);
        }
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);

            for (String str : strs) {
                if (c != str.charAt(i)) {
                    return str.substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLen);


    }
}
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("fl",solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
            Assert.assertEquals("",solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
            Assert.assertEquals("",solution.longestCommonPrefix(new String[]{}));
            Assert.assertEquals("",solution.longestCommonPrefix(new String[]{""}));
        }
    }
}
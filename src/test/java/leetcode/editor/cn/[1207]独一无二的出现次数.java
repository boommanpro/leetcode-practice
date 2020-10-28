package leetcode.editor.cn;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1207 {
//给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。 
//
// 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,2,2,1,1,3]
//输出：true
//解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。 
//
// 示例 2： 
//
// 输入：arr = [1,2]
//输出：false
// 
//
// 示例 3： 
//
// 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// -1000 <= arr[i] <= 1000 
// 
// Related Topics 哈希表 
// 👍 61 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean uniqueOccurrences(int[] arr) {
            int[] count = new int[2001];
            for (int i = 0; i < arr.length; i++) {
                count[1000 + arr[i]]++;
            }
            Set<Integer> set = new HashSet<>();
            for (int value : count) {
                if (value == 0)
                    continue;
                if (!set.add(value))//如果存储失败，说明有重复的
                    return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
            Assert.assertFalse(solution.uniqueOccurrences(new int[]{1, 2}));
            Assert.assertTrue(solution.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
        }
    }
}
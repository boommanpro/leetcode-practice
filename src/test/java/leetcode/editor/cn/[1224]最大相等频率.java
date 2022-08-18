package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BinaryOperator;

class SolutionTest1224 {
//给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度： 
//
// 
// 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。 
// 
//
// 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,1,1,5,3,3,5]
//输出：7
//解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数
//字都出现了两次。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
//输出：13
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 👍 164 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEqualFreq(int[] nums) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            TreeMap<Integer, Integer> prefixMap = new TreeMap<>();
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int cnt = cntMap.getOrDefault(num, 0);
                int curr = cnt + 1;
                cntMap.put(num, curr);
                int prefix = prefixMap.getOrDefault(cnt, 0);
                if (prefix == 0 || prefix == 1) {
                    prefixMap.remove(cnt);
                } else {
                    prefixMap.put(cnt, prefix - 1);
                }
                prefixMap.put(curr, prefixMap.getOrDefault(curr, 0) + 1);
                int size = prefixMap.size();
                if (size == 1 || size == 2) {
                    if (size == 1) {
                        Map.Entry<Integer, Integer> entry = prefixMap.firstEntry();
                        if (entry.getKey() == 1 || entry.getValue() == 1) {
                            ans = i;
                        }
                    } else {
                        Map.Entry<Integer, Integer> first = prefixMap.firstEntry();
                        Map.Entry<Integer, Integer> last = prefixMap.lastEntry();
                        if (first.getKey() == 1 && first.getValue() == 1) {
                            ans = i;
                        } else if (last.getKey() - first.getKey() == 1 && last.getValue() == 1) {
                            ans = i;
                        }
                    }
                }
            }

            return ans + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();

            Assert.assertEquals(7, solution.maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}));
            Assert.assertEquals(5, solution.maxEqualFreq(new int[]{1, 1, 1, 2, 2, 1}));
            Assert.assertEquals(4, solution.maxEqualFreq(new int[]{1, 1, 1, 2}));
            Assert.assertEquals(5, solution.maxEqualFreq(new int[]{1, 1, 1, 2, 2}));
            Assert.assertEquals(7, solution.maxEqualFreq(new int[]{2, 2, 1, 1, 5, 3, 3, 5}));
            Assert.assertEquals(13, solution.maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5}));
        }

    }
}
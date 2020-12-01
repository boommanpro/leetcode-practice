package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest128 {
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 
// 👍 620 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Integer, Integer> parents;

        public int longestConsecutive(int[] nums) {
            parents = new HashMap<>();
            for (int num : nums) {
                parents.put(num, num);
            }
            for (int num : nums) {
                union(num, num + 1);
            }
            int max = 0;
            for (int num : nums) {
                max = Math.max(max, find(num) - num + 1);
            }
            return max;
        }

        private boolean union(int x, int y) {
            Integer px = find(x);
            Integer py = find(y);
            if (px == null || py == null) {
                return false;
            }
            if (px.equals(py)) {
                return false;
            }
            parents.put(px, py);
            return true;
        }

        private Integer find(int x) {
            if (!parents.containsKey(x)) {
                return null;
            }
            Integer t = parents.get(x);
            if (t == x) {
                return x;
            }
            parents.put(x, find(t));
            return parents.get(x);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(4, solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
//            Assert.assertEquals(9, solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        }
    }
}
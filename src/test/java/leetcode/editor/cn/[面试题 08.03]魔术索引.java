package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题08_03 {
//魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找
//出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。 
//
// 示例1: 
//
//  输入：nums = [0, 2, 3, 4, 5]
// 输出：0
// 说明: 0下标的元素为0
// 
//
// 示例2: 
//
//  输入：nums = [1, 1, 1]
// 输出：1
// 
//
// 说明: 
//
// 
// nums长度在[1, 1000000]之间 
// 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本 
// 
// Related Topics 数组 二分查找 
// 👍 42 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findMagicIndex(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int l = 0;
            int value = nums[l];
            int n = nums.length;
            while (l != value && value < n) {
                int temp;
                if (value < 0) {
                    temp = nums[l++];
                } else {
                    temp = nums[value];
                }
                if (temp > 0) {
                    l = temp;
                }
                if (l < n) {
                    value = nums[l];
                } else {
                    return -1;
                }
            }
            return l == value ? l : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(22, solution.findMagicIndex(new int[]{-531369933, -469065528, -430059048, -428981853, -319235969, -288076332, -286667432, -282312559, -197049680, -197022263, -174416117, -138027773, -121899023, -111631966, -107567458, -70437707, -52463072, -45519851, -38641451, -15825815, -3835472, -1525043, 22, 566842886, 593757472, 605439236, 619794079, 640069993, 657657758, 718772950, 815849552, 839357142, 936585256, 1006188278, 1042347147, 1057129320, 1062178586, 1069769438}));
            Assert.assertEquals(3, solution.findMagicIndex(new int[]{1, 2, 3, 3, 4}));
            Assert.assertEquals(-1, solution.findMagicIndex(new int[]{1, 2, 3, 4, 5}));
            Assert.assertEquals(0, solution.findMagicIndex(new int[]{0, 2, 3, 4, 5}));
            Assert.assertEquals(1, solution.findMagicIndex(new int[]{1, 1, 1}));
        }
    }
}
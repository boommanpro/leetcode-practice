package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest18 {
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 589 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
            if (nums == null || nums.length < 4) {
                return quadruplets;
            }
            Arrays.sort(nums);
            int length = nums.length;
            for (int i = 0; i < length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                for (int j = i + 1; j < length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                        continue;
                    }
                    int left = j + 1, right = length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            left++;
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return quadruplets;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]", solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0).toString());
            Assert.assertEquals("[[-2, -1, 1, 2], [-1, -1, 1, 1]]", solution.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0).toString());
            Assert.assertEquals("[]", solution.fourSum(new int[]{-491, -468, -450, -415, -414, -374, -357, -333, -305,
                    -292, -274, -272, -271, -258, -241, -240, -227, -217, -196, -184, -161, -120, -116, -110, -110, -98, -92, -47, -27, -10,
                    -8, -7, -4, -1, 19, 30, 53, 62, 64, 65, 137, 138, 145, 160, 178, 179, 209, 221, 243, 270, 279, 283, 290, 291, 305, 308, 322,
                    345, 354, 357, 365, 366, 368, 371, 376, 381, 381, 394, 400, 406, 429, 433, 445, 446, 449, 470, 471, 472}, 2873).toString());
            Assert.assertEquals("[]", solution.fourSum(
                    new int[]{-500, -499, -496, -467, -467, -465, -461, -460, -456, -456, -447, -426,
                            -425, -401, -377, -367, -344, -338, -332, -329, -328, -294, -281, -262, -256,
                            -224, -196, -192, -171, -161, -151, -138, -130, -109, -109, -107, -104, -101,
                            -97, -96, -90, -78, -76, -70, -28, -23, -4, 30, 39, 46, 60, 80, 97, 120, 172,
                            183, 194, 197, 206, 238, 242, 243, 252, 303, 338, 341, 349, 362, 366, 367, 372,
                            393, 400, 403, 406, 411, 416, 454, 457, 460, 497}, -1963).toString());

            Assert.assertEquals("[]", solution.fourSum(
                    new int[]{-496, -487, -446, -421, -420, -411, -409, -400, -374, -353, -322, -317, -293, -290, -289,
                            -279, -278, -260, -258, -257, -253, -247, -226, -198, -192, -182, -178, -174, -170, -163, -150,
                            -145, -140, -115, -69, -58, -50, -40, -21, -16, -13, 5, 5, 39, 39, 43, 45, 83, 83, 94, 106, 107, 117,
                            143, 166, 174, 178, 185, 185, 210, 228, 231, 239, 246, 247, 262, 300, 338, 340, 342, 344, 352, 353,
                            359, 362, 363, 372, 375, 395, 400, 412, 414, 420, 429, 430, 431, 440, 441, 486}, -2468).toString());
        }
    }
}
package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest80 {
//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。 
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 说明： 
//
// 为什么返回数值是整数，但输出的答案是数组呢？ 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// 
//// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,2,2,3]
//输出：5, nums = [1,1,2,2,3]
//解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,1,1,2,3,3]
//输出：7, nums = [0,0,1,1,2,3,3]
//解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的
//元素。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3 * 104 
// -104 <= nums[i] <= 104 
// nums 已按升序排列 
// 
// Related Topics 数组 双指针 
// 👍 416 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int removeDuplicates(int[] nums) {
            int MAX_REPEAT = 1;
            int repeat = 0;
            int p = 0;
            int start = 0;
            int cnt = 0;
            int len = nums.length;
            while (p < len) {
                nums[start] = nums[p];
                start++;
                p++;
                cnt++;
                while (p < len && nums[p - 1] == nums[p]) {
                    repeat++;
                    if (repeat <= MAX_REPEAT) {
                        nums[start] = nums[p];
                        start++;
                        cnt++;
                    }
                    p++;
                }
                repeat = 0;
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            int[] array1 = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
            System.out.println(String.format("before:%s", Arrays.toString(array1)));
            int result1 = solution.removeDuplicates(array1);
            System.out.println(String.format("after:%s", Arrays.toString(array1)));
            Assert.assertEquals(7, result1);

            int[] array2 = new int[]{1, 1, 1, 2, 2, 3};
            System.out.println(String.format("before:%s", Arrays.toString(array2)));
            int result2 = solution.removeDuplicates(array2);
            System.out.println(String.format("after:%s", Arrays.toString(array2)));
            Assert.assertEquals(5, result2);
        }
    }
}
package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest80 {

    //给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 
//
// 示例 1: 
//
// 给定 nums = [1,1,1,2,2,3],
//
//函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,1,2,3,3],
//
//函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//} 
// Related Topics 数组 双指针
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MAX_REPEAT_TIME = 1;

        public int removeDuplicates(int[] nums) {
            int l = 0, r = 1;
            int repeatTime = 0;
            while (r < nums.length) {
                if (nums[l] != nums[r]) {
                    l = l + 1 + repeatTime;
                    nums[l] = nums[r];
                    repeatTime = 0;
                } else {
                    if (repeatTime < MAX_REPEAT_TIME) {
                        repeatTime++;
                        //问题是在这里最后没有替换跑完代码了
                        nums[l + repeatTime] = nums[r];
                    }
                }

                r++;
            }
            return l + 1 + repeatTime;
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
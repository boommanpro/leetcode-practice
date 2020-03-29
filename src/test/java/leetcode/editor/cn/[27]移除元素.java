package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest27 {

    //给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 
//
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 1: 
//
// 给定 nums = [3,2,2,3], val = 3,
    //          i
    //          j
    //1.        2 2 2 3
    //          i
    //            j
    //2.
    //
    //
//
//函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 示例 2: 
//
// 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
//
//函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
//
//注意这五个元素可为任意顺序。
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
// // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
//int len = removeElement(nums, val);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //找到满足条件的放到前面去
        public int removeElement(int[] nums, int val) {
            int i = 0;
            int j = 0;
            while (j < nums.length) {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
                j++;
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            int[] array1 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
            System.out.println(String.format("before:%s", Arrays.toString(array1)));
            int result1 = solution.removeElement(array1, 2);
            System.out.println(String.format("after:%s", Arrays.toString(array1)));
            Assert.assertEquals(5, result1);
            int[] array2 = new int[]{3, 2, 2, 3};
            System.out.println(String.format("before:%s", Arrays.toString(array2)));
            int result2 = solution.removeElement(array2, 3);
            System.out.println(String.format("after:%s", Arrays.toString(array2)));
            Assert.assertEquals(2, result2);
        }
    }
}
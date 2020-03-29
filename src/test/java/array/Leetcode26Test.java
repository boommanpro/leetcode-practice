package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode26Test {

    @Test
    public void leetcode26Test() {
        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(array);
        System.out.println(String.format("result:%s", i));
        System.out.println(Arrays.toString(array));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }

        return i + 1;
    }
}

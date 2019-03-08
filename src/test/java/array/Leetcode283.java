package array;

import org.junit.Test;

import java.util.Arrays;

public class Leetcode283 {

    //     Example:
    //
    //     Input: [0,1,0,3,12]
    //
    //     Output: [1,3,12,0,0]

    @Test
    public void leetcode283Test(){
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(String.format("result:%s", Arrays.toString(nums)));
    }

    public void moveZeroes(int[] nums) {
        int val = 0;
        int position=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[position++] = nums[i];
            }
        }
        for (int i = position; i < nums.length; i++) {
            nums[i] = val;
        }
    }
}

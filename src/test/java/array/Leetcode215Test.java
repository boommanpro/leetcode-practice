package array;

import org.junit.Test;

import java.util.Arrays;

public class Leetcode215Test {

    //     Example 1:
    //
    //     Input: [3,2,1,5,6,4] and k = 2
    //     Output: 5
    //     Example 2:
    //
    //     Input: [3,2,3,1,2,4,5,5,6] and k = 4
    //     Output: 4

    @Test
    public void leetcode215Test(){
        int[] input = new int[]{3, 2, 1, 5, 6, 4};
        int kthLargest = findKthLargest(input, 2);
        System.out.println(String.format(" result: %s\n preview: %s", kthLargest, Arrays.toString(input)));
    }


    //Top K Problem , should use heap

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int findKthLargest1(int[] nums, int k) {
        return 0;
    }
}

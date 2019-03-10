package array;

import org.junit.Test;

public class Leetcode209Test {

    //     Example:
    //
    //     Input: s = 7, nums = [2,3,1,2,4,3]
    //     Output: 2
    //     Explanation: the subarray [4,3] has the minimal length under the problem constraint.

    @Test
    public void leetcode209Test(){

        int[] input = new int[]{2, 3, 1, 2, 4, 3};
        int i = minSubArrayLen(7, input);
        System.out.println(String.format("input result:%s", i));
    }




    public int minSubArrayLen(int s, int[] nums) {
        //slide window

        int[] ans = new int[]{-1, 0, 0};

        int currentSum=0;

        int left = 0;
        int right = 0;

        while (right < nums.length) {

            currentSum += nums[right];

            while (currentSum >= s) {
                if (ans[0] == -1 ) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                if ((right - left + 1) < ans[0]){
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                currentSum -= nums[left++];
            }
            right++;


        }

        return ans[0]==-1?0:ans[0];
    }
}

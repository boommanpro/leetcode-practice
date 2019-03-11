package hashTable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode219Test {

    @Test
    public void leetcode219Test() {

        //      Example 1:
        //
        //      Input: nums = [1,2,3,1], k = 3
        //      Output: true
        //      Example 2:
        //
        //      Input: nums = [1,0,1,1], k = 1
        //      Output: true
        //      Example 3:
        //
        //      Input: nums = [1,2,3,1,2,3], k = 2
        //      Output: false


        boolean b = containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2);

        System.out.println(String.format("result:%s", b));
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {


        Map<Integer, Integer> table = new HashMap<>();
        //找到第一个 之后的一直和第一个比较 判断差值是否小于等于k
        for (int i = 0; i < nums.length; i++) {
            Integer beforePosition = table.get(nums[i]);
            if (beforePosition != null) {
                if (i - beforePosition <= k) {
                    return true;
                }
            }
            table.put(nums[i], i);
        }

        return false;

    }
}

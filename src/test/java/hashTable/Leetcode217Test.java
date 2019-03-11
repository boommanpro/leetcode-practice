package hashTable;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode217Test {
    @Test
    public void leetcode217Test(){

        //     Example 1:
        //
        //     Input: [1,2,3,1]
        //     Output: true
        //     Example 2:
        //
        //     Input: [1,2,3,4]
        //     Output: false
        //     Example 3:
        //
        //     Input: [1,1,1,3,3,4,3,2,4,2]
        //     Output: true

        boolean b = containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2});
        System.out.println(String.format("result:%s",b));

    }


    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return nums.length != collect.size();
    }
}

package hashTable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode136Test {
    @Test
    public void leetcode136Test() {
        int i = singleNumber(new int[]{2, 2, 1});
        System.out.println(i);
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> dictMap = new HashMap<>();
        for (int num : nums) {
            dictMap.put(num, dictMap.getOrDefault(num, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : dictMap.entrySet()) {
            if (entry.getValue()==1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}

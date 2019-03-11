package hashTable;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author BoomManPro
 * @mail 592323211@qq.com
 * @description
 */
public class Leetcode202Test {

    @Test
    public void leetcode202Test() {
        boolean happy = isHappy(19);

        System.out.println(String.format("result:%s",happy));
    }

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> loop = new HashSet<>();


        loop.add(n);
        int sum = 0;
        while (n != 0) {
            int i = n % 10;
            n = n / 10;
            sum += i * i;
            if (n == 0) {
                n = sum;
                sum = 0;
                if (n == 1) {
                    return true;
                }
                if (loop.contains(n)) {
                    return false;
                }
                loop.add(n);
            }

        }
        return false;
    }
}

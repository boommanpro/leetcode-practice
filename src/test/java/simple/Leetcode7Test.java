package simple;

import org.junit.Assert;
import org.junit.Test;

public class Leetcode7Test {


    /**
     * from:https://leetcode.com/problems/reverse-integer/
     *
     * Example 1:
     *
     *   Input: 123
     *   Output: 321
     *   Example 2:
     *
     *   Input: -123
     *   Output: -321
     *   Example 3:
     *
     *   Input: 120
     *   Output: 21
     */
    public int reverse(int x) {
        int result;
        if (x == 0) {
            return 0;
        }
        if (x > 0) {
            result = 1;
        }else {
            result = -1;
        }
        x = Math.abs(x);
        try {
            return result * Integer.parseInt(new StringBuilder(x + "").reverse().toString());
        } catch (Exception e) {
            return 0;
        }
    }

    @Test
    public void reverseTest(){
        Assert.assertEquals(reverse(123),321);
        Assert.assertEquals(reverse(-123),-321);
        Assert.assertEquals(reverse(120),21);
        Assert.assertEquals(reverse(
                1534236469),0);
    }
}

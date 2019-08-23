package test;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:boommanpro@gamil.com">BoomManPro</a>
 * @date 2019/8/23 15:32
 * @created by BoomManPro
 */
public class Leetcode172Test {

    @Test
    public void test() {
        Assert.assertEquals(trailingZeroes(5),1);
    }

    public int trailingZeroes(int n) {
        return  n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}

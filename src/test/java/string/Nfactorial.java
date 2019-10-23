package string;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/**
 * N的阶乘计算
 *
 * @author wangqimeng
 * @date 2019/10/22 20:59
 */
public class Nfactorial {

    public String factorial(int n) {
        int[] result = new int[10001];
        result[0] = 1;
        for (int i = 2; i <= n; i++) {
            int up = 0;
            for (int j = 0; j <= 10000; j++) {
                int s = result[j] * i + up;
                result[j] = s % 10;
                up = s / 10;
            }
        }
        return arrayToString(result);
    }

    private String arrayToString(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int j = result.length - 1; j >= 0; j--) {
            if (result[j] != 0) {
                for (; j >= 0; j--) {
                    sb.append(result[j]);
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void factorialTest() {
        Assert.assertEquals("6", factorial(3));
        Assert.assertEquals("24", factorial(4));
        Assert.assertEquals("120", factorial(5));
    }

    @Test
    public void stringJoinTest() {
        int[] result = new int[]{1, 2, 3, 4, 5};
        String str = Arrays.stream(result).boxed().map(Object::toString).collect(Collectors.joining());
        Assert.assertEquals("12345", str);
    }
}

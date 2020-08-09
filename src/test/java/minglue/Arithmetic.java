package minglue;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Arithmetic {

    /**
     * A[]={1,2,3,4,5}
     * <p>
     * B0=A1*A2*A3*A4*An-1
     * <p>
     * B1=A0*A2*A3*A4*An-1
     */
    public int[] arithmetic(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return arr;
        }
        int length = arr.length;
        int[] cacheBefore = new int[length];
        int[] cacheAfter = new int[length];
        int[] result = new int[length];
        cacheBefore[0] = arr[0];
        cacheAfter[length - 1] = arr[length - 1];
        for (int i = 1; i < length; i++) {
            cacheBefore[i] = arr[i] * cacheBefore[i - 1];
            cacheAfter[length - i - 1] = cacheAfter[length - i] * arr[length - i - 1];
        }
        //预处理 防止溢出
        result[0] = cacheAfter[1];
        result[length - 1] = cacheBefore[length - 2];
        for (int i = 1; i < length - 1; i++) {
            //result[i] = i-1 * i+1
            result[i] = cacheBefore[i - 1] * cacheAfter[i + 1];
        }
        return result;
    }


    @Test
    public void arithmeticTest() {
        int[] array0 = arithmetic(new int[]{1, 2, 3, 4});
        Assert.assertEquals("[24, 12, 8, 6]", Arrays.toString(array0));

        int[] array1 = arithmetic(new int[]{1});
        Assert.assertEquals("[1]", Arrays.toString(array1));

        int[] array2 = arithmetic(new int[]{1, 2});
        Assert.assertEquals("[2, 1]", Arrays.toString(array2));

        int[] array3 = arithmetic(new int[]{1, 2, 3});
        Assert.assertEquals("[6, 3, 2]", Arrays.toString(array3));
    }
}

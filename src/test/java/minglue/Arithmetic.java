package minglue;

import org.junit.Test;

import java.util.Arrays;

public class Arithmetic {
    /**
     *  A[]={1,2,3,4,5}
     *
     *  B0=A1*A2*A3*A4*An-1
     *
     *  B1=A0*A2*A3*A4*An-1
     */

    @Test

    public void arithmeticTest(){
        int[] arithmetic = arithmetic(new int[]{1, 2, 3,4});

        System.out.println(Arrays.toString(arithmetic));
    }

    public int[] arithmetic(int[] arr){

        int length = arr.length;
        int[] cacheBefore = new int[length];
        int[] cacheAfter = new int[length];

        cacheBefore[0] = arr[0];
        cacheAfter[length - 1] = arr[length - 1];

        for (int i = 1; i < length; i++) {
            cacheBefore[i] = cacheBefore[i - 1] * arr[i];
            cacheAfter[length-i-1] = cacheAfter[length-i] * arr[length-i-1];
        }

        arr[0] = cacheAfter[1];
        arr[length - 1] = cacheBefore[length-2];

        for (int i = 1; i < length-1; i++) {
            arr[i]=cacheBefore[i-1]*cacheAfter[i+1];
        }
        return arr;
    }

}

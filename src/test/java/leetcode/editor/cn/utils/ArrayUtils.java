package leetcode.editor.cn.utils;

import java.util.Arrays;

/**
 * @author wangqimeng
 * @date 2020/6/22 16:30
 */
public class ArrayUtils {

    /**
     * 二维数组转string
     */
    public static String twoDimension2String(int[][] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(Arrays.toString(array[i]));
            if (i != array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}

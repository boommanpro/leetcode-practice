package leetcode.editor.cn.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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


    public static String threeDimension2String(int[][][] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(twoDimension2String(array[i]));
            if (i != array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static List<List<Integer>> twoDimension2List(int[][] array) {
        return Arrays.stream(array).map(ints -> Arrays.stream(ints).boxed().collect(Collectors.toList())).collect(Collectors.toList());
    }
}

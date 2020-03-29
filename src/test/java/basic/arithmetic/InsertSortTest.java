package basic.arithmetic;

import org.junit.Assert;
import org.junit.Test;

/**
 * 插入排序
 * @author wangqimeng
 * @date 2019/10/30 15:30
 */
public class InsertSortTest {

    @Test
    public void insertSortTest() {
        int[] array1 = new int[]{5, 4, 3, 2, 1, 0};
        //5 4 3 2 1 0
        //4 5 3 2 1 0
        //3 4 5 2 1 0
        //2 3 4 5 1 0
        //1 2 3 4 5 0
        //0 1 2 3 4 5
        insertSort(array1);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5}, array1);
    }

    //冒泡排序 插入排序 选择排序
    //时间复杂度O(N^2)
    //空间复杂度O(1)

    //插入排序思想
    public void insertSort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            int temp = array[i];
            for (; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }


}

package basic.arithmetic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangqimeng
 * @date 2019/10/30 16:08
 */
public class SelectSortTest {

    @Test
    public void selectSortTest() {
        int[] array1 = new int[]{5, 4, 3, 2, 1, 0};
        selectSort(array1);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5}, array1);
    }

    //选择排序
    //找出小的不断放到前面
    public void selectSort(int[] array) {
        int i, j, index;
        for (i = 0; i < array.length; i++) {
            index = i;
            for (j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            swap(array, i, index);
        }
    }

    private void swap(int[] array, int a, int b) {
        int c = array[a];
        array[a] = array[b];
        array[b] = c;
    }
}

package basic.arithmetic;

import org.junit.Assert;
import org.junit.Test;

/**
 * 冒泡排序
 *
 * @author wangqimeng
 * @date 2019/10/30 15:56
 */
public class BubblingSortTest {

    @Test
    public void bubblingSortTest() {
        int[] array1 = new int[]{5, 4, 3, 2, 1, 0};
        bubblingSort(array1);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5}, array1);


        int[] array2 = new int[]{5, 4, 3, 2, 1, 0};
        compare(array2);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5}, array2);
    }

    /**
     * 比较相邻的元素。如果第一个比第二个大,就交换他们两个。
     * 对每一对相邻元素做同样的工作,从开始第一对到结尾的最后一对。
     * 在这一点,最后的元素应该会是最大的数。 针对所有的元素重复以上的步骤,除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤,直到没有任何一对数字需要比较。”
     */
    private void bubblingSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    swap(array, j + 1, j);
                }
            }
        }
    }

    //这种是把小的放到前面 比较排序把。。。
    private void compare(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[i]) {
                    swap(array, i, j);
                }
            }
        }
    }

    private void swap(int[] array, int a, int b) {
        int c = array[a];
        array[a] = array[b];
        array[b] = c;
    }
}

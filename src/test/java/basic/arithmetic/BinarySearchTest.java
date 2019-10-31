package basic.arithmetic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangqimeng
 * @date 2019/10/31 15:23
 */
public class BinarySearchTest {

    @Test
    public void binarySearchTest() {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Assert.assertEquals(0, binarySearch(array, 1));
        Assert.assertEquals(1, binarySearch(array, 2));
        Assert.assertEquals(2, binarySearch(array, 3));
        Assert.assertEquals(3, binarySearch(array, 4));
        Assert.assertEquals(4, binarySearch(array, 5));
        Assert.assertEquals(5, binarySearch(array, 6));
        Assert.assertEquals(6, binarySearch(array, 7));
        Assert.assertEquals(7, binarySearch(array, 8));
        Assert.assertEquals(8, binarySearch(array, 9));
        Assert.assertEquals(9, binarySearch(array, 10));
        Assert.assertEquals(10, binarySearch(array, 11));

    }

    public int binarySearch(int[] array, int k) {
        if (array == null || array[array.length - 1] < k) {
            return -1;
        }
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (array[mid] == k) {
                return mid;
            } else if (array[mid] < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}

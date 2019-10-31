package basic.arithmetic;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @link https://www.jianshu.com/p/33cffa1ce613
 * @author wangqimeng
 * @date 2019/10/31 10:17
 */
public class MergeSortTest {

    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(N)，归并排序需要一个与原数组相同长度的数组做辅助来排序
     * 稳定性：归并排序是稳定的排序算法，temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
     *
     * 这行代码可以保证当左右两部分的值相等的时候，先复制左边的值，这样可以保证值相等的时候两个元素的相对位置不变。
     */
    @Test
    public void mergeSortTest(){
        int[] array = new int[]{5, 4, 3, 2, 1, 0};
        sort(array, 0, array.length - 1);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5}, array);
    }

    /**
     * 归并排序
     */
    public static void sort(int[] arr, int L, int R) {
        if(L == R) {
            return;
        }
        //计算mid
        int mid = L + ((R - L) >> 1);
        //排序左边
        sort(arr, L, mid);
        //排序右边
        sort(arr, mid + 1, R);
        //进行合并
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while(p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while(p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while(p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for(i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }


}

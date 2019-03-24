package basic;

import org.junit.Test;

import java.util.Arrays;

public class HeapSortTest {

    @Test
    public void heapSortTest() {
        int[] arr = {2, 9, 5, 8, 4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void heapSort(int[] arr) {

        int length = arr.length;

        //1.先建立一个大顶堆出来

        //将乱序数据先构建成大顶堆 需要按照自下向上 从右向左顺序
        for (int i = (length - 1 - 1) / 2; i >= 0; i--) {
            adjustHeap(arr, i, length);
        }
        //2.不断取出最上面的元素 使其与末尾未排序元素交换
        for (int i = length - 1; i >= 0; i--) {
            //交换元素
            swap(arr, 0, i);
            //只有顶部元素不满足大顶堆 遂堆顶部元素调整堆
            adjustHeap(arr, 0, i);
        }
    }

    public void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k + 1] > arr[k]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = temp;


    }


    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}

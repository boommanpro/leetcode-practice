package basic;


import org.junit.Test;

import java.util.Arrays;

public class QuickSort {


    // 快速排序，a是数组，n表示数组的大小



    @Test
    public void quickSortTest() {
        int[] arr = {2, 9, 5, 8, 4};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public  void quickSort(int[] a) {
        quickSortInternally(a, 0, a.length-1);
    }


    // 快速排序递归函数，p,r为下标
    private  void quickSortInternally(int[] arr, int p, int r) {
        if (p >= r){
            return;
        }
        int q = partition(arr, p, r); // 获取分区点
        quickSortInternally(arr, p, q - 1);
        quickSortInternally(arr, q + 1, r);
    }


    private  int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (arr[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        swap(arr, i, r);
        return i;

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
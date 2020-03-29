package basic.arithmetic;

import org.junit.Test;

import java.util.Arrays;

public class HeapSortTest {

    @Test
    public void heapSortTest() {
        int[] arr = {2, 9, 5, 8, 4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序的思路
     * 1.将原数据构建成大顶堆
     */
    public void heapSort(int[] arr) {

        int length = arr.length;

        //1.先建立一个大顶堆出来

        //将乱序数据先构建成大顶堆 需要按照自下向上 从右向左顺序
        //找到第一个非叶子节点
        for (int i = (length - 1 - 1) / 2; i >= 0; i--) {
            adjustHeap(arr, i, length);
        }
        //2.不断取出最上面的元素 使其与末尾未排序元素交换
        for (int i = length - 1; i > 0; i--) {
            //交换元素
            swap(arr, 0, i);
            //只有顶部元素不满足大顶堆 遂堆顶部元素调整堆
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整堆内容
     *
     * @param arr    数据array
     * @param i      调整的位置
     * @param length 数组长度
     *
     * 算法是如何调整堆的?
     *
     */
    public void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        //当前节点一定是非叶子节点,先把当前的值保存下来
        //第一次k=其左孩子 其右孩子就是k+1
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            //如果右孩子存在并且右孩子大于左孩子 k++
            if (k + 1 < length && arr[k + 1] > arr[k]) {
                k++;
            }
            //因为最终是和temp交换位置  所以要一直和temp做比较
            if (arr[k] > temp) {
                arr[i] = arr[k];
                //i最终是最小位置 被交换的位置
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

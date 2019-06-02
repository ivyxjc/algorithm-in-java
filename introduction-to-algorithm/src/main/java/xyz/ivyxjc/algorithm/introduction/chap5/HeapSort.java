package xyz.ivyxjc.algorithm.introduction.chap5;


import xyz.ivyxjc.algorithm.common.HeapUtils;

/**
 * @author Ivyxjc
 * @since 5/19/2018
 */
public class HeapSort {

    public static void main(String[] args) {

    }

    final void exchange(int[] arr, int p, int q) {
        int num = arr[p];
        arr[p] = arr[q];
        arr[q] = num;
    }

    public void heapSort(int[] arr, int heapSize) {
        buildMaxHeap(arr);
        HeapUtils.isMaxHeap(arr, arr.length - 1);
        int[] res = new int[arr.length];
        int copyHeapSize = heapSize;
        for (int i = heapSize; i >= 2; i--) {
            exchange(arr, i, 1);
            copyHeapSize--;
            maxHeapify(arr, 1, copyHeapSize);
        }
    }

    private void buildMaxHeap(int[] arr) {
        int heapSize = arr.length - 1;
        for (int i = heapSize / 2; i >= 1; i--) {
            maxHeapify(arr, i, heapSize);
        }
    }

    /**
     * 根节点的左右节点的子树都是最大堆，但是根节点arr[p]可能小于其左右节点
     */
    private void maxHeapify(int[] arr, int p, int heapSize) {
        int left = p << 1;
        int right = (p << 1) + 1;
        int largest = p;
        if (left <= heapSize && arr[left] > arr[p]) {
            largest = left;
        }
        if (right <= heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != p) {
            exchange(arr, p, largest);
            maxHeapify(arr, largest, heapSize);
        }
    }
}

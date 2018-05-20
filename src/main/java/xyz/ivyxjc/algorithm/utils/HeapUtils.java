package xyz.ivyxjc.algorithm.utils;

/**
 * @author Ivyxjc
 * @since 5/19/2018
 */
public class HeapUtils {

    /**
     * heap的下标从1开始，所以arr.length>=heapSize+1;
     */
    public static boolean isMaxHeap(int[] arr, int heapSize) {
        return isMaxHeap(arr, 1, heapSize);
    }

    private static boolean isMaxHeap(int[] arr, int p, int heapSize) {
        int left = p << 1;
        int right = (p << 1) + 1;

        if (left <= heapSize) {
            if (arr[left] <= arr[p]) {
                if (!isMaxHeap(arr, left, heapSize)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (right <= heapSize) {
            if (arr[right] <= arr[p]) {
                return isMaxHeap(arr, right, heapSize);
            } else {
                return false;
            }
        }
        return true;
    }
}

package xyz.ivyxjc.algorithm.introduction.chap7;

import java.util.Random;
import xyz.ivyxjc.algorithm.common.ArrayUtilsIvy;


/**
 * @author Ivyxjc
 * @since 5/20/2018
 */
public class QuickSort {

    private Random mRandom = new Random();

    /**
     * 使用的是左闭右开
     */
    public void quickSort(int[] arr, int left, int right) {
        if (right == left) {
            return;
        }
        int randMain = Math.abs(mRandom.nextInt() % (right - left)) + left;
        ArrayUtilsIvy.exchange(arr, randMain, right - 1);
        if (left < right) {
            int partition = partition(arr, left, right);
            //System.out.println(left+"  "+right+"  "+partition);
            quickSort(arr, left, partition);
            quickSort(arr, partition + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int x = arr[right - 1];
        int j = right - 1;
        for (int i = left; i < j; ) {
            if (arr[i] <= x) {
                i++;
            } else {
                j--;
                ArrayUtilsIvy.exchange(arr, i, j);
            }
        }
        ArrayUtilsIvy.exchange(arr, j, right - 1);
        return j;
    }

    private int randomPartition(int[] arr, int left, int right) {
        int randMain = Math.abs(mRandom.nextInt() % (right - left)) + left;
        ArrayUtilsIvy.exchange(arr, randMain, right - 1);
        return partition(arr, left, right);
    }
}
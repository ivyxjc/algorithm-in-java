package xyz.ivyxjc.algorithm.introduction.chap5;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import xyz.ivyxjc.algorithm.common.ArrayUtilsIvy;
import xyz.ivyxjc.algorithm.common.HeapUtils;

/**
 * @author Ivyxjc
 * @since 5/19/2018
 */

public class HeapSortTest {

    private static Method maxHeapifyMethod;
    private static Method buildMaxHeapMethod;
    private static Random sRandom = new Random();

    @BeforeClass
    public static void init() throws NoSuchMethodException {
        maxHeapifyMethod =
            HeapSort.class.getDeclaredMethod("maxHeapify", int[].class, int.class, int.class);
        maxHeapifyMethod.setAccessible(true);
        buildMaxHeapMethod = HeapSort.class.getDeclaredMethod("buildMaxHeap", int[].class);
        buildMaxHeapMethod.setAccessible(true);
    }

    /**
     * 仅有一个测例，未必完全
     */
    @Test
    public void testMaxHeapify() throws InvocationTargetException, IllegalAccessException {
        int[] arr = new int[] {0, 16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        HeapSort heapSort = new HeapSort();
        arr[1] = 4;
        maxHeapifyMethod.invoke(heapSort, arr, 1, arr.length - 1);
        boolean bool = HeapUtils.isMaxHeap(arr, arr.length - 1);
        Assert.assertTrue(bool);
    }

    @Test
    public void testBuildMaxHeap() throws InvocationTargetException, IllegalAccessException {
        int[] arr = ArrayUtilsIvy.buildArray(1000);
        HeapSort heapSort = new HeapSort();
        buildMaxHeapMethod.invoke(heapSort, arr);
        boolean bool = HeapUtils.isMaxHeap(arr, arr.length - 1);
        Assert.assertTrue(bool);
    }

    @Test
    public void testHeapSortBasic() {
        for (int i = 0; i < 8; i++) {
            int size = (int) Math.pow(10.0, (double) i);
            int[] arr = ArrayUtilsIvy.buildArray(size);
            arr[0] = Integer.MIN_VALUE;
            HeapSort heapSort = new HeapSort();
            long t1 = System.nanoTime();
            heapSort.heapSort(arr, arr.length - 1);
            long t2 = System.nanoTime();
            Assert.assertTrue(ArrayUtils.isSorted(arr));
            System.out.println(String.format("size %s costs %d ns", arr.length, t2 - t1));
        }
    }

    @Test
    public void testHeapSort() {
        for (int i = 0; i < 8; i++) {
            int size = sRandom.nextInt() % ((int) Math.pow(10.0, (double) i));
            size = Math.abs(size) + (int) Math.pow(10.0, (double) i);
            if (i == 0) {
                size = 1;
            }
            int[] arr = ArrayUtilsIvy.buildArray(size);
            arr[0] = Integer.MIN_VALUE;
            HeapSort heapSort = new HeapSort();
            long t1 = System.nanoTime();
            heapSort.heapSort(arr, arr.length - 1);
            long t2 = System.nanoTime();
            Assert.assertTrue(ArrayUtils.isSorted(arr));
            System.out.println(String.format("size %s costs %d ns", arr.length, t2 - t1));
        }
    }

    @Test
    public void testQuickSort() {
        for (int i = 0; i < 9; i++) {
            int[] arr = ArrayUtilsIvy.buildArray((int) Math.pow(10.0, (double) i));
            arr[0] = Integer.MIN_VALUE;
            long t1 = System.nanoTime();
            Arrays.sort(arr);
            long t2 = System.nanoTime();
            System.out.println(String.format("size %s costs %d ns", arr.length, t2 - t1));
        }
    }

    @Test
    public void tess() {
        System.out.println(new Random().nextInt(8));
        System.out.print(new Random().nextInt());
    }
}

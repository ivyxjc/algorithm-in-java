package xyz.ivyxjc.algorithm.common;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivyxjc
 * @since 5/19/2018
 */
public class TestHeapUtils {

    @Test
    public void testIsMaxHeap1() {
        int[] a = new int[] {0, 16, 14, 10, 8, 7, 9, 3, 2, 4, 8};
        boolean bool = HeapUtils.isMaxHeap(a, a.length - 1);
        Assert.assertFalse(bool);
    }

    @Test
    public void testIsMaxHeap2() {
        int[] a = new int[] {0, 16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        boolean bool = HeapUtils.isMaxHeap(a, a.length - 1);
        Assert.assertTrue(bool);
    }

    @Test
    public void testIsMaxHeap3() {
        int[] a = new int[] {0, 1};
        boolean bool = HeapUtils.isMaxHeap(a, a.length - 1);
        Assert.assertTrue(bool);
    }
}

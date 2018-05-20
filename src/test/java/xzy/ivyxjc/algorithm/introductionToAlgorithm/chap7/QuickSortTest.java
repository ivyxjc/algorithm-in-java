package xzy.ivyxjc.algorithm.introductionToAlgorithm.chap7;

import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;
import xyz.ivyxjc.algorithm.introductionToAlgoritms.chap7.QuickSort;
import xyz.ivyxjc.algorithm.utils.ArrayUtilsIvy;

/**
 * @author Ivyxjc
 * @since 5/20/2018
 */
public class QuickSortTest {

    public static Random sRandom = new Random();

    //@Test
    //public void testPartition(){
    //    int[] arr=new int[]{1,5,7,8,3,5,2,7,8,4,5};
    //    //arr=new int[]{1,4};
    //    QuickSort quickSort=new QuickSort();
    //    int i=quickSort.partition(arr,0,arr.length);
    //    System.out.println(Arrays.toString(arr));
    //    System.out.println(i);
    //}

    @Test
    public void testQuickSortBasic() {
        for (int i = 0; i < 8; i++) {
            int size = (int) Math.pow(10.0, (double) i);
            int[] arr = ArrayUtilsIvy.buildArray(size);
            arr[0] = Integer.MIN_VALUE;
            QuickSort quickSort = new QuickSort();
            long t1 = System.nanoTime();
            quickSort.quickSort(arr, 0, arr.length);
            long t2 = System.nanoTime();
            Assert.assertTrue(ArrayUtils.isSorted(arr));
            System.out.println(String.format("size %s costs %d ns", arr.length, t2 - t1));
        }
    }

    @Test
    public void testRandomCosts() {
        long t1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            int randMain = Math.abs(sRandom.nextInt() % (10000 - 0)) + 1;
        }
        long t2 = System.nanoTime();
        System.out.println(String.format("costs %d ns", t2 - t1));
    }
}

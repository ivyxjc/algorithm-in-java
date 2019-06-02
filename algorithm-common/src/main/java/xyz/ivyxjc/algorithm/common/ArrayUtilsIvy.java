package xyz.ivyxjc.algorithm.common;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

/**
 * @author Ivyxjc
 * @since 5/19/2018
 */
public class ArrayUtilsIvy {

    @NotNull
    public static int[] buildArray(int n) {
        int[] array = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    public static void exchange(int[] arr, int p, int q) {
        int num = arr[p];
        arr[p] = arr[q];
        arr[q] = num;
    }
}

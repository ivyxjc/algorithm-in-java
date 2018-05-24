package xyz.ivyxjc.algorithm.codeforces.level_a;

import java.util.Scanner;

/**
 * @author Ivyxjc
 * @since 5/24/2018
 */

/**
 * easy; math
 */
public class _486A_CalculatingFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        if (n % 2 == 0) {
            System.out.println(n / 2);
        } else {
            System.out.println((n - 1) / 2 - n);
        }
    }
}

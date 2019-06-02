package xyz.ivyxjc.algorithm.codeforces.level_a;

import java.util.Scanner;

/**
 * @author Ivyxjc
 * @since 5/24/2018
 */

/**
 * east; math
 */
public class _318A_EvenOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        if (n % 2 == 0) {
            if (k <= n / 2) {
                System.out.println(2 * k - 1);
            } else {
                System.out.println(2 * k - n);
            }
        } else {
            if (k <= n / 2 + 1) {
                System.out.println(2 * k - 1);
            } else {
                System.out.println(2 * k - n - 1);
            }
        }
    }
}

package xyz.ivyxjc.algorithm;

/**
 * @author Ivyxjc
 * @since 5/19/2018
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Ivyxjc
 * @since 5/18/2018
 */
public class Main {

    /**
     * 直接运用公式计算矩阵的算法，时间复杂度为$O(n^{3})$
     *
     * n*n矩阵与n*n矩阵相乘的公式
     * $$ c_{ij}  = \sum_{k=1}^{n} a_{ik} \cdot  b_{kj} $$
     *
     * @param a 矩阵a
     * @param b 矩阵b
     */
    public static int[][] calculate(int n, int[][] a, int[][] b) {
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] = c[i][j] = a[i][k] + b[k][j];
                }
            }
        }
        return c;
    }

    static class QuickReader {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /** call this method to initialize reader for InputStream */
        public static void init(InputStream input) {
            reader = new BufferedReader(
                new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        public static boolean hasNext() {
            return tokenizer.hasMoreTokens();
        }

        /** get next word */
        public static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer(
                    reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}


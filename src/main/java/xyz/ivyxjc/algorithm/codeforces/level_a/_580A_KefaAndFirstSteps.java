package xyz.ivyxjc.algorithm.codeforces.level_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author Ivyxjc
 * @since 5/24/2018
 */

/**
 * easy; dp
 */
public class _580A_KefaAndFirstSteps {

    /**
     * 140ms,1900KB
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        QuickReader.init(System.in);
        int num = QuickReader.nextInt();
        int[] nums = new int[num];
        int[] dp = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = QuickReader.nextInt();
        }
        dp[0] = 1;
        for (int i = 1; i < num; i++) {
            if (nums[i] < nums[i - 1]) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num; i++) {
            if (dp[i] >= max) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}

class QuickReader {
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

package xyz.ivyxjc.algorithm.codeforces.level_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ivyxjc
 * @since 5/24/2018
 */
public class _208A_Dubstep {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        if (chars.length < 3) {
            System.out.println(input);
            return;
        }

        boolean flag = true;
        int lastK = 0;
        for (int i = 0; i < chars.length - 2; ) {
            if (chars[i] == 'W' && chars[i + 1] == 'U' && chars[i + 2] == 'B') {
                i = i + 3;
                lastK = i;
                if (flag) {
                    sb.append(" ");
                }
                flag = false;
            } else {
                flag = true;
                sb.append(chars[i]);
                i++;
                lastK = i;
            }
        }
        if (chars[chars.length - 3] == 'W'
            && chars[chars.length - 2] == 'U'
            && chars[chars.length - 1] == 'B') {

        } else {
            for (int i = lastK; i < chars.length; i++) {
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString().trim());
    }
}

//package xyz.ivyxjc.algorithm;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
///**
// * @author Ivyxjc
// * @since 5/18/2018
// */
//public class QuickReader {
//    static BufferedReader reader;
//    static StringTokenizer tokenizer;
//
//    /** call this method to initialize reader for InputStream */
//    public static void init(InputStream input) {
//        reader = new BufferedReader(
//            new InputStreamReader(input));
//        tokenizer = new StringTokenizer("");
//    }
//
//    public static boolean hasNext(){
//        return tokenizer.hasMoreTokens();
//    }
//
//    /** get next word */
//    public static String next() throws IOException {
//        while (!tokenizer.hasMoreTokens()) {
//            //TODO add check for eof if necessary
//            tokenizer = new StringTokenizer(
//                reader.readLine());
//        }
//        return tokenizer.nextToken();
//    }
//
//    public static int nextInt() throws IOException {
//        return Integer.parseInt(next());
//    }
//
//    public static double nextDouble() throws IOException {
//        return Double.parseDouble(next());
//    }
//}
//

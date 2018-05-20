package xzy.ivyxjc.algorithm.introductionToAlgorithm.chap4;

import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.Assert;
import org.junit.Test;
import xyz.ivyxjc.algorithm.introductionToAlgoritms.chap4.MatrixCalculator;

/**
 * @author Ivyxjc
 * @since 5/18/2018
 */
public class MatrixCalculateTest {
    private static Random sRandom = new Random();

    public double[][] buildMatrix(int n) {
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sRandom.nextDouble() * 100;
            }
        }
        return matrix;
    }

    @Test
    public void testPureCalculate() {
        for (int i = 0; i < 100; i++) {
            int n = Math.abs(sRandom.nextInt() % 100) + 1;
            if (i == 0) {
                n = 1;
            }
            MatrixCalculator matrixCalculator = new MatrixCalculator();
            double[][] a = buildMatrix(n);
            double[][] b = buildMatrix(n);
            RealMatrix am = MatrixUtils.createRealMatrix(a);
            RealMatrix bm = MatrixUtils.createRealMatrix(b);
            double[][] expected = am.multiply(bm).getData();
            double[][] c = matrixCalculator.pureCalculate(n, a, b);
            for (int j = 0; j < n; j++) {
                Assert.assertArrayEquals(expected[j], c[j], 0.001);
            }
        }
    }

    @Test
    public void testRecursiveCalculate() {
        for (int i = 0; i < 100; i++) {
            int n = Math.abs(sRandom.nextInt() % 100) + 1;
            if (i == 0) {
                n = 5;
            }
            MatrixCalculator matrixCalculator = new MatrixCalculator();
            double[][] a = buildMatrix(n);
            double[][] b = buildMatrix(n);
            RealMatrix am = MatrixUtils.createRealMatrix(a);
            RealMatrix bm = MatrixUtils.createRealMatrix(b);
            double[][] expected = am.multiply(bm).getData();
            double[][] res = new double[n][n];
            //matrixCalculator.recursiveCalculate(res,a,b,0,0,n,n);
            for (int j = 0; j < n; j++) {
                System.out.println(ArrayUtils.toString(res[j]));
            }
            ArrayUtils.toString(res[0]);

            for (int j = 0; j < n; j++) {
                Assert.assertArrayEquals(expected[j], res[j], 0.001);
            }
        }
    }
}

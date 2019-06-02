package xyz.ivyxjc.algorithm.introduction.chap4;

/**
 * @author Ivyxjc
 * @since 5/18/2018
 */
public class MatrixCalculator {

    /**
     * 直接运用公式计算矩阵的算法，时间复杂度为$O(n^{3})$
     *
     * n*n矩阵与n*n矩阵相乘的公式
     * $$ c_{ij}  = \sum_{k=1}^{n} a_{ik} \cdot  b_{kj} $$
     *
     * @param a 矩阵a
     * @param b 矩阵b
     */
    public double[][] pureCalculate(int n, double[][] a, double[][] b) {
        double[][] c = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    /**
     * 递归地将n*n矩阵分解为4个n/2*n/2的矩阵，时间复杂度为$O(n^3)$
     *
     * $$
     * \begin{bmatrix}
     * C_{11} & C_{12}\\\\
     * C_{21} & C_{22}
     * \end{bmatrix}
     * =
     * \begin{bmatrix}
     * A_{11} & A_{12}\\\\
     * A_{21} & A_{22}
     * \end{bmatrix}
     * \cdot
     * \begin{bmatrix}
     * B_{11} & B_{12}\\\\
     * B_{21} & B_{22}
     * \end{bmatrix}
     * $$
     *
     * @param n
     * @param a
     * @param b
     * @return
     */
    //public double[][] recursiveCalculate(int n,double[][] a,double[][] b){
    //    if(n==1){
    //        double[][] tmp=new double[1][1];
    //        tmp[0][0]=a[0][0]*b[0][0];
    //        return tmp;
    //    }
    //    double[][] a11=new double[][];
    //    double[][] a12=new double[][];
    //    double[][] a21=new double[][];
    //    double[][] a22=new double[][];
    //
    //
    //}
    //
    //public void recursiveCalculate(double[][] res,double[][] a,double[][]b, int row1,int col1,int row2,int col2){
    //    if(row1==row2-1||row1==row2){
    //        res[row1][col1]=a[row1][col1]*b[row1][col1];
    //        return;
    //    }else{
    //        int rowMid=row1+(row2-row1)/2;
    //        int colMid=col1+(col2-col1)/2;
    //        recursiveCalculate(res,a,b,row1,col1,rowMid,colMid);
    //        rorecursiveCalculate(res,a,b,row1,colMid,rowMid,col2);
    //
    //        recursiveCalculate(res,a,b,rowMid,col1,row2,colMid);
    //        recursiveCalculate(res,a,b,row1,colMid,rowMid,col2);
    //        recursiveCalculate(res,a,b,rowMid,colMid,row2,col2);
    //    }
    //}
}

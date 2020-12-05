package 牛客题霸.数组;

/**
 * Created by xieli on 2020/12/5.
 */
public class 顺时针旋转矩阵NC18 {

    public int[][] rotateMatrix(int[][] mat, int n) {
        // 先以对角线（左上 - 右下）为轴进行翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // 再对每一行以中点为轴进行翻转
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }

        return mat;
    }

}

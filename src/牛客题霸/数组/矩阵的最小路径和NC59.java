package 牛客题霸.数组;

/**
 * Created by xieli on 2020/12/4.
 */
public class 矩阵的最小路径和NC59 {

    public int minPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i == 0)
                    matrix[i][j] += matrix[i][j - 1];
                else if (j == 0)
                    matrix[i][j] += matrix[i - 1][j];
                // 注意，此题是 “最小” 的路径和
                else
                    matrix[i][j] += Math.min(matrix[i][j - 1], matrix[i - 1][j]);
            }
        }

        return matrix[m - 1][n - 1];
    }

}

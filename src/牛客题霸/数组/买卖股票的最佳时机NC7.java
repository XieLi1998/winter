package 牛客题霸.数组;

/**
 * Created by xieli on 2020/11/30.
 */


public class 买卖股票的最佳时机NC7 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (prices == null || n == 0)
            return 0;

        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                // 此处必须注意要跳过这次判定
                continue;
            }

            // 注意！！！推导状态方程一定要加上交易次数 k 的限制
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }

        return dp[n - 1][0];
    }

}

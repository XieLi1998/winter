package 牛客题霸.数组;

/**
 * Created by xieli on 2020/11/24.
 */
public class 斐波那契数列NC65 {

    //递归，时间复杂度：O(2^n)
    public int Fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    //动态规划
    public int Fibonacci_2(int n) {
        if (n == 0)
            return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        //此处注意 n=1 是 dp[2] 的越界处理
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    //动态规划，空间优化
    public int Fibonacci_3(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        int pre = 1, cur = 1;
        int[] dp = new int[n + 1];
        for (int i = 3; i <= n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}

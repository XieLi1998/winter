package 牛客题霸.数组;

/**
 * Created by xieli on 2020/11/25.
 */
public class 缺失数字NC101 {

    /**
     * 找缺失数字
     *
     * @param a int整型一维数组 给定的数字串
     * @return int整型
     */
    // 数学方法：缺失一个数，数组长度就是最大的数
    public int solve(int[] a) {
        // write code here
        int len = a.length;
        int res = (0 + len) * (len + 1) / 2;
        for (int num : a)
            res -= num;
        return res;
    }

    // 位运算：相同数字异或两次必然得0且顺序无关，
    // 先用0把1~n-1异或一遍再把数组元素异或一遍得到的就是丢失数字
    public int solve_2(int[] a) {
        // write code here
        int len = a.length;
        int res = 0;
        for (int i = 1; i <= len; i++) {
            res ^= i;
        }
        for (int num : a)
            res ^= num;
        return res;
    }

}

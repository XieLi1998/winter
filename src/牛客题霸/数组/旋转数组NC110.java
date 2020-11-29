package 牛客题霸.数组;

/**
 * Created by xieli on 2020/11/29.
 */
public class 旋转数组NC110 {

    /**
     * 旋转数组
     *
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */


    /**
     * 1.暴力，时间复杂度：O(n * m)， 空间复杂度：O(1)
     * 旋转 m 次，每次将数组旋转一个元素
     */
    public int[] solve_1(int n, int m, int[] a) {
        int temp, previous;
        for (int i = 0; i < m; i++) {
            previous = a[a.length - 1];
            for (int j = 0; j < a.length; j++) {
                temp = a[j];
                a[j] = previous;
                previous = temp;
            }
        }
        return a;
    }

    /**
     * 2.使用额外的数组：时间复杂度：O(n)， 空间复杂度：O(n)
     * 使用一个额外的数组将每个元素放到正确的位置上，(i + k) % 数组长度,
     * 然后把新的数组拷贝到原数组中
     */
    public int[] solve_2(int n, int m, int[] a) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[(i + m) % n] = a[i];
        }
        for (int i = 0; i < n; i++) {
            a[i] = dp[i];
        }
        return a;
    }

    /**
     * 3.环状替换, 时间复杂度：O(n), 空间复杂度：O(1)
     * <p>
     * https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-yuan-di-huan-wei-xiang-xi-tu-jie/
     */
    public int[] solve_3(int n, int m, int[] a) {
        m = m % n;
        int count = 0;      //记录交换的次数，n 个同学一共需要交换 n 次
        for (int start = 0; count < n; start++) {
            int cur = start;  //从 0 位置开始换位置
            int pre = a[cur];
            do {
                int next = (cur + m) % n;
                int temp = a[next];     //来到角落...
                a[next] = pre;
                pre = temp;
                cur = next;
                count++;
            } while (start != cur);    //循环暂停，回到起始位置，角落无人

        }

        return a;
    }

    /**
     * 4. 使用反转, 时间复杂度：O(n), 空间复杂度：O(1)
     * 旋转数组 k 次，k % n 个尾部元素会被移动到头部，剩下的元素会被向后移动
     * <p>
     * 先将所有元素反转，然后反转前 k 个元素，再反转后面 n - k 个元素
     */
    public int[] solve_4(int n, int m, int[] a) {
        m = m % n;
        reverse(a, 0, n - 1);
        reverse(a, 0, m - 1);
        reverse(a, m, n - 1);
        return a;
    }

    public void reverse(int[] num, int start, int end) {
        while (start < end) {
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
    }

}

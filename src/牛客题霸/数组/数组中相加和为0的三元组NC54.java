package 牛客题霸.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xieli on 2020/11/28.
 */
public class 数组中相加和为0的三元组NC54 {

    /*
     *  排序 + 双指针
     *  1. 特判，数组为 null 或者长度小于 3，返回[]
     *  2. 对数组进行排序
     *  3. 遍历排序后的数组：
     *      a. 若 num[i] > 0，后面不可能有 3 个数相加等于 0，结束遍历
     *      b. 跳过重复元素
     *      c. 左指针 L = i + 1, 右指针 R = n - 1, L < R
     *
     *  时间复杂度：O(n^2)，数组排序 O(NlogN), 遍历数组 O(n), 双指针遍历 O(n)
     *  空间复杂度：O(1)
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int len = num.length;
        if (num == null || len < 3)
            return res;

        Arrays.sort(num);

        for (int i = 0; i < len; i++) {
            if (num[i] > 0)
                break;
            if (i > 0 && num[i] == num[i - 1])
                continue;
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = num[i] + num[L] + num[R];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
//                    list.add(num[i]);
//                    list.add(num[L]);
//                    list.add(num[R]);
                    Collections.addAll(list, num[i], num[L], num[R]);
                    res.add(list);

                    // 注意，此处需要处理跳过重复元素
                    while (L < R && num[L] == num[L + 1]) L++;
                    while (L < R && num[R] == num[R - 1]) R++;
                    L++;
                    R--;

                } else if (sum < 0) L++;
                else if (sum > 0) R--;

            }
        }

        return res;
    }

}

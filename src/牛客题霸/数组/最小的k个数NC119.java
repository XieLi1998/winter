package 牛客题霸.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by xieli on 2020/11/27.
 */
public class 最小的k个数NC119 {

    /*
     *   1. 快排,时间复杂度 O(n)
     *      不需要对整个数组进行 O(NlogN) 的排序
     *      直接通过快排切分好第 K 小的数(下标为 k - 1)，那么它左边的数就是比它小的另外 k - 1 个数
     */
    public int[] GetLeastNumbers(int[] input, int k) {
        if (k == 0 || input.length == 0)
            return new int[0];
        // 最后一个参数表示我们要找的是下标为 k - 1 的数
        return quickSearch(input, 0, input.length - 1, k - 1);
    }

    public int[] quickSearch(int[] num, int low, int high, int k) {
        // 每快排切分一次，找到下标为 j 的元素，如果 j 恰好等于 k 就返回 j 以及 j 左边所有的数
        int j = partition(num, low, high);
        if (j == k) {
            return Arrays.copyOf(num, j + 1);
        }

        // 否则根据下标 j 与 k 的大小关系来决定继续切分左段还是右段
        return j > k ? quickSearch(num, low, j - 1, k) : quickSearch(num, j + 1, high, k);
    }

    // 快排切分，返回下标 j，使得比 num[j] 小的都在左边，比 num[j] 大的都在右边
    private int partition(int[] num, int low, int high) {
        int v = num[low];
        int i = low, j = high + 1;
        while (true) {
            while (++i <= high && num[i] < v) ;
            while (--j >= low && num[j] > v) ;
            if (i >= j)
                break;
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        num[low] = num[j];
        num[j] = v;
        return j;
    }

    /*
     *   2. 大根堆(前 K 小) / 小根堆(前 K 大)
     *      大根堆，每次 poll 出最大的数，那堆中保留的就是前 K 小，时间复杂度 O(NlogK)
     *      注意不是小根堆，小根堆需要把全部的元素都入堆，时间复杂度是 O(NlogN)
     */
    public int[] GetLeastNumbers_2(int[] input, int k) {
        if (k == 0 || input.length == 0)
            return new int[0];

        // 默认是小根堆，每次 poll 出最小的数
        // 大根堆需要重写比较器
        Queue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int num : input) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.offer(num);
                pq.poll();
            }
        }

        int[] res = new int[k];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }

        return res;
    }

}

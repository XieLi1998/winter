package 牛客题霸.数组;

/**
 * Created by xieli on 2020/12/2.
 */
public class 在转动过的有序数组中寻找目标值NC48 {

    /**
     *
     * @param A int整型一维数组
     * @param target int整型
     * @return int整型
     */


    /**
     * 思路一： 将 旋转数组查找目标值 转化成 有序数组查找目标值
     * <p>
     * 例如 target = 5, 目标值在左半段，因此在
     * [4, 5, 6, 7, inf, inf, inf] 这个有序数组里找就行了;
     * 例如 target = 1, 目标值在右半段，因此在
     * [-inf, -inf, -inf, -inf, 0, 1, 2] 这个有序数组里找就行了;
     */
    public int search(int[] A, int target) {
        int lo = 0, hi = A.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target)
                return mid;

            // 先根据 num[0] 与 target 的关系判断目标值在左半段还是右半段
            if (target >= A[0]) {
                // 目标值在左半段，若 mid 在右半段，则将 mid 索引的值改成 inf
                if (A[mid] < A[0]) {
                    A[mid] = Integer.MAX_VALUE;
                }
            } else {
                // 目标值在右半段，若 mid 在左半段，则将 mid 索引的值改成 -inf
                if (A[mid] >= A[0]) {
                    A[mid] = Integer.MIN_VALUE;
                }
            }

            if (A[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }


    /**
     * 思路二： 二分查找，分段讨论
     */
    public int search_2(int[] A, int target) {
        int lo = 0, hi = A.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target)
                return mid;

            //先根据 num[mid] 与 num[lo] 的关系判断 mid 是在左段还是右段
            if (A[mid] >= A[lo]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target <= A[hi] && target > A[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}

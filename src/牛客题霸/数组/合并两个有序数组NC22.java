package 牛客题霸.数组;

/**
 * Created by xieli on 2020/11/24.
 */
public class 合并两个有序数组NC22 {

    public void merge(int A[], int m, int B[], int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;

        while (len1 >= 0 && len2 >= 0) {
            A[len--] = A[len1] > B[len2] ? A[len1--] : B[len2--];
        }

        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(B, 0, A, 0, len2 + 1);
    }

}

package 牛客题霸.数组;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by xieli on 2020/12/5.
 */
public class 加起来和为目标值的组合NC46 {

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        int len = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 排序
        Arrays.sort(num);

        Deque<Integer> path = new ArrayDeque<>();
        dfs(num, len, 0, target, path, res);

        return res;
    }

    /**
     * @param num    候选数组
     * @param len    冗余变量
     * @param begin  从候选数组的 begin 位置开始搜索
     * @param target
     * @param path   从根节点到叶子节点的路径
     * @param res
     */
    private void dfs(int[] num, int len, int begin, int target, Deque<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 大剪枝
            if (target - num[begin] < 0) {
                break;
            }

            // 小剪枝，相同的值直接跳过
            if (i > begin && num[i] == num[i - 1]) {
                continue;
            }

            path.addLast(num[i]);

            dfs(num, len, i + 1, target - num[i], path, res);

            path.removeLast();
        }
    }

    // leetcode:
    // https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/


}

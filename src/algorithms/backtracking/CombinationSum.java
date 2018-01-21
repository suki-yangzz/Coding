package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Combination Sum II
 * Each number in C may only be used once in the combination.
 * 在这里我们还是需要在每一次for循环前做一次判断，因为虽然一个元素不可以重复使用，但是如果这个元素重复出现是允许的，
 * 但是为了避免出现重复的结果集，我们只对于第一次得到这个数进行递归，接下来就跳过这个元素了，
 * 因为接下来的情况会在上一层的递归函数被考虑到，这样就可以避免重复元素的出现。 Each number in C may only be used
 * once in the combination. I 是The same repeated number may be chosen from C unlimited number of times.
 * 1.长度标准：无（固定）
 * 2.可选的范围：从start开始到最后一个数
 * 3.往前走一步：temp加入这个数，remain再减去
 * 4.后退一步：temp减去这个数
 * 5.特别的case：剩下的小于0直接return
 * 6.关于重复：11 和1 在第一个1用了以后，第二个1就不用了
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        dfs2(candidates, target, 0, temp, res);
        return res;
    }
    public void dfs2(int[] candidates, int remain, int begin,List<Integer> temp, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        if (remain < 0)
            return;
        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1])//去重复
                continue;
            temp.add(candidates[i]);
            dfs2(candidates, remain - candidates[i], i + 1, temp, res);//所以在1中，这里的下一个还是i
            temp.remove(temp.size() - 1);
        }
    }
}

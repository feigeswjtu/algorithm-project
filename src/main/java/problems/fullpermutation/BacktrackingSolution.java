package problems.fullpermutation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author feigeswjtu.cyf
 * @version $Id: BacktrackingSolution.java, v 0.1 2021-02-07 10:10 feigeswjtu.cyf Exp $$
 */
public class BacktrackingSolution implements FullPermutationSolution {

    /**
     * 数组的全排序
     *
     * @param arrays
     * @return
     */
    @Override
    public List<List<Integer>> permute(int[] arrays) {
        List<List<Integer>> result = new ArrayList<>();
        int length = arrays.length;
        if (length == 0) {
            return new ArrayList<>();
        }

        Deque<Integer> path = new ArrayDeque<>();

        boolean[] used = new boolean[length];

        dfs(arrays, length, 0, path, used, result);
        return result;
    }

    private void dfs(int[] arrays, int len, int depth, Deque<Integer> path, boolean[] used,
        List<List<Integer>> result) {
        if (depth == len) {
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(arrays[i]);
            used[i] = true;

            dfs(arrays, len, depth + 1, path, used, result);
            path.removeLast();
            used[i] = false;
        }
    }
}
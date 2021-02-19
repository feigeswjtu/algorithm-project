package problems.fullpermutation;

import java.util.List;

/**
 * @author feigeswjtu.cyf
 * @version $Id: FullPermutationSolution.java, v 0.1 2021-02-07 10:09 feigeswjtu.cyf Exp $$
 */
public interface FullPermutationSolution {
    /**
     * 数组的全排序
     * @param arrays
     * @return
     */
    List<List<Integer>> permute(int[] arrays);
}
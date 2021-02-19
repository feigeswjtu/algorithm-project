package problems.fullpermutation;

import java.util.List;

/**
 * 数组全排列
 *
 * @author feigeswjtu.cyf
 * @version $Id: Main.java, v 0.1 2021-02-07 10:08 feigeswjtu.cyf Exp $$
 */
public class Main {
    public static void main(String[] args) {
        int[] arrays = {1,2,3,4};
        BacktrackingSolution solution = new BacktrackingSolution();
        List<List<Integer>> result = solution.permute(arrays);
        System.out.println(result);
    }
}
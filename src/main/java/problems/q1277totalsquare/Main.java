package problems.q1277totalsquare;

import org.testng.Assert;

/**
 * q1277_统计全为1的正方形子矩阵个数
 *
 * @author feigeswjtu.cyf
 * @version $Id: Main.java, v 0.1 2021-02-05 16:21 feigeswjtu.cyf Exp $$
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new DynamicProgrammingSolution();
        int[][] matrix =
            {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
            };
        int i = solution.totalSquare(matrix);
        Assert.assertEquals(i, 15);
        System.out.println("统计全为1的正方形子矩阵个数: " + i);
    }
}
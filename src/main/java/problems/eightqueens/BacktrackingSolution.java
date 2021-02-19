package problems.eightqueens;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 回溯解法，此方法不判断对角线是否有皇后
 *
 * @author feigeswjtu.cyf
 * @version $Id: BacktrackingSolution.java, v 0.1 2021-02-07 10:27 feigeswjtu.cyf Exp $$
 */
public class BacktrackingSolution implements EightQueensSolution {
    /**
     * 八皇后摆法数量
     *
     * @param queensCount
     * @return
     */
    @Override
    public int countMethod(int queensCount) {
        if (queensCount == 0) {
            return 0;
        }

        if (queensCount == 1) {
            return 1;
        }

        // 摆法总数量
        AtomicInteger totalCount = new AtomicInteger(0);

        // 列是否已占用
        boolean[] colsUsed = new boolean[queensCount];

        // 摆放个数
        int putCount = 0;

        // 回溯法
        dfs(queensCount, putCount, colsUsed, totalCount);

        return totalCount.get();
    }

    /**
     * 回溯法遍历
     *
     * @param queensCount
     * @param putCount
     * @param colsUsed
     * @param totalCount
     */
    private void dfs(int queensCount, int putCount, boolean[] colsUsed, AtomicInteger totalCount) {
        for (int i = 0; i < queensCount; i++) {
            if (!colsUsed[i]) {
                colsUsed[i] = true;
                putCount++;

                if (putCount == queensCount) {
                    totalCount.addAndGet(1);
                    colsUsed[i] = false;
                    return;
                }

                dfs(queensCount, putCount, colsUsed, totalCount);

                putCount--;
                colsUsed[i] = false;

            }
        }

    }

}
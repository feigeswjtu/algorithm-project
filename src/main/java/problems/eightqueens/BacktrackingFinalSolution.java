package problems.eightqueens;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 回溯解法
 *
 * @author feigeswjtu.cyf
 * @version $Id: BacktrackingSolution.java, v 0.1 2021-02-07 10:27 feigeswjtu.cyf Exp $$
 */
public class BacktrackingFinalSolution implements EightQueensSolution {
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

        List<MatrixLocation> putList = new ArrayList<>();

        // 回溯法
        dfs(queensCount, putList, totalCount);

        return totalCount.get();
    }

    /**
     * 回溯法遍历
     *
     * @param queensCount
     * @param putList
     * @p aram totalCount
     */
    private void dfs(int queensCount, List<MatrixLocation> putList, AtomicInteger totalCount) {
        for (int i = 0; i < queensCount; i++) {
            MatrixLocation currentLocation = new MatrixLocation();
            currentLocation.setRow(putList.size() + 1);
            currentLocation.setCol(i);

            if (!canHit(currentLocation, putList)) {
                putList.add(currentLocation);

                if (putList.size() == queensCount) {
                    totalCount.addAndGet(1);
                    putList.remove(putList.size() - 1);
                    return;
                }

                dfs(queensCount, putList, totalCount);
                putList.remove(putList.size() - 1);
            }
        }

    }

    /**
     * 判断是否可以攻击
     *
     * @param currentLocation
     * @param putList
     * @return
     */
    private boolean canHit(MatrixLocation currentLocation, List<MatrixLocation> putList) {
        for (MatrixLocation putLocation : putList) {
            int rowDistance = Math.abs(currentLocation.getRow() - putLocation.getRow());
            int colDistance = Math.abs(currentLocation.getCol() - putLocation.getCol());

            if (rowDistance == 0 || colDistance == 0 || rowDistance == colDistance) {
                return true;
            }
        }

        return false;

    }

}
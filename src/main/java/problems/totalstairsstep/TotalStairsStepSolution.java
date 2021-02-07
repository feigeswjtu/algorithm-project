package problems.totalstairsstep;

/**
 * @author feigeswjtu.cyf
 * @version $Id: TotalStairsStepSolution.java, v 0.1 2021-02-04 13:35 feigeswjtu.cyf Exp $$
 */
public class TotalStairsStepSolution {
    /**
     * 最多楼梯步长，动态规划写法
     * @return
     */
    public int totalStairsStep(int stairHeight){
        // 楼梯高度为0时
        if (stairHeight == 0){
            return 0;
        }

        // 楼梯高度为1时
        if (stairHeight == 1){
            return 1;
        }

        // 楼梯高度为2时
        if (stairHeight == 2){
            return 2;
        }

        int beforeOneStepCount = 1;
        int beforeTwoStepCount = 2;

        int currentStepCount = 0;

        for (int step = 3; step <= stairHeight; step++){
            currentStepCount = beforeOneStepCount + beforeTwoStepCount;
            beforeOneStepCount = beforeTwoStepCount;
            beforeTwoStepCount = currentStepCount;
        }
        return currentStepCount;
    }
}
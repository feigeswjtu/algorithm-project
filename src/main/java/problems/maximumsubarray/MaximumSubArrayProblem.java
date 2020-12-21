package problems.maximumsubarray;

/**
 * 求最大子数组
 *
 * @author chenyafei
 * @version 1.0
 * @date 19/03/2018 16:42
 */

public class MaximumSubArrayProblem {
    /**
     * 主函数入口
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[] {2, 4, -7, 5, 2, -1, 2, -4, 3};
        MaximumSubArrayService maximumSubArrayService = new MaximumSubArrayServiceImplV3();
        int maximumSubArrayValue = maximumSubArrayService.findMaximumSubArrayValue(array);
        System.out.println(maximumSubArrayValue);

    }
}

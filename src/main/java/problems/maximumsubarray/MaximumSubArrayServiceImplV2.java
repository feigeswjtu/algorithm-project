package problems.maximumsubarray;

/**
 * 最大子数组V2版本
 * <li>两层循环，上次的结果不需要重复计算<li/>
 *
 * @author feigeswjtu.cyf
 * @version $Id: MaximumSubArrayServiceImplV1.java, v 0.1 2020-12-21 17:54 feigeswjtu.cyf Exp $$
 */
public class MaximumSubArrayServiceImplV2 implements MaximumSubArrayService {
    /**
     * 查找最大子数组的值
     *
     * @param array
     * @return
     */
    @Override
    public int findMaximumSubArrayValue(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("入参错误");
        }

        int thisSum = 0;
        int maxSum = array[0];
        int length = array.length;
        for (int i = 0; i < length; i++) {
            thisSum = 0;
            for (int j = i; j < length; j++) {
                thisSum += array[j];
                if (thisSum > maxSum) { maxSum = thisSum; }
            }
        }
        return maxSum;

    }
}
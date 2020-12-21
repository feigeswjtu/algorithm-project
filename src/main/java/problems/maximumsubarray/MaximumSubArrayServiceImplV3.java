/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package problems.maximumsubarray;

/**
 * 最大子数组V3版本
 * <li>1层循环，拿第一个数字作为基准数据<li/>
 *
 * @author feigeswjtu.cyf
 * @version $Id: MaximumSubArrayServiceImplV1.java, v 0.1 2020-12-21 17:54 feigeswjtu.cyf Exp $$
 */
public class MaximumSubArrayServiceImplV3 implements MaximumSubArrayService {
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

        int baseMaxSum = array[0];

        int thisSum = 0;
        int maxSum = 0;
        int length = array.length;
         /*如果累加和出现小于0的情况，
           则和最大的子序列肯定不可能包含前面的元素，
           这时将累加和置0，从下个元素重新开始累加  */
        for (int i = 0; i < length; i++) {
            thisSum += array[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < baseMaxSum) {
                thisSum = 0;
            }
        }
        return maxSum;

    }
}
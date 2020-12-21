/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package problems.maximumsubarray;

/**
 * 最大子数组V1版本
 * <li>暴力查询，3层循环<li/>
 *
 * @author feigeswjtu.cyf
 * @version $Id: MaximumSubArrayServiceImplV1.java, v 0.1 2020-12-21 17:54 feigeswjtu.cyf Exp $$
 */
public class MaximumSubArrayServiceImplV1 implements MaximumSubArrayService {
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

        //暴力查找，3层循环
        int maxSum = array[0];
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int thisSum = 0;
                for (int k = i; k <= j; k++) {
                    thisSum += array[k];
                }

                if (thisSum > maxSum) { maxSum = thisSum; }
            }
        }
        return maxSum;

    }
}
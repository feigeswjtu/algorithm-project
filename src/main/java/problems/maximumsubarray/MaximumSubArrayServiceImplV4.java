package problems.maximumsubarray;

/**
 * 最大子数组V4版本
 * <li>分治法<li/>
 *
 * @author feigeswjtu.cyf
 * @version $Id: MaximumSubArrayServiceImplV1.java, v 0.1 2020-12-21 17:54 feigeswjtu.cyf Exp $$
 */
public class MaximumSubArrayServiceImplV4 implements MaximumSubArrayService {
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

        return maximumSubArrayValue(array, 0, array.length - 1);
    }

    /**
     * 子数组最大值
     *
     * @param array
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    int maximumSubArrayValue(int array[], int leftIndex, int rightIndex) {
        int middleIndex = (leftIndex + rightIndex) >> 1;

        // 如果左右值相等则等于中间值
        if (leftIndex >= rightIndex) {
            return array[middleIndex];
        }

        // 左边最大值
        int leftMax = maximumSubArrayValue(array, leftIndex, middleIndex);

        // 右边最大值
        int rightMax = maximumSubArrayValue(array, middleIndex + 1, middleIndex);

        // 左右最大值
        int mMaxTmp = 0;
        int mMax = leftMax;

        for (int i = middleIndex; i >= leftIndex; --i) {
            mMaxTmp += array[i];
            mMax = max2(mMaxTmp, mMax);
        }

        for (int i = middleIndex + 1; i <= rightIndex; ++i) {
            mMaxTmp += array[i];
            mMax = max2(mMaxTmp, mMax);
        }

        return max3(leftMax, mMax, rightMax);

    }

    /**
     * 2个数字中的最大值
     *
     * @param a
     * @param b
     * @return
     */
    int max2(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * 3个数字中的最大值
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    int max3(int a, int b, int c) {
        a = a > b ? a : b;
        return a > c ? a : c;
    }

}
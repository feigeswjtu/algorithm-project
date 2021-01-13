package sort;

/**
 * @author feigeswjtu.cyf
 * @version $Id: CountSort.java, v 0.1 2021-01-12 16:58 feigeswjtu.cyf Exp $$
 */
public class CountOptSort implements ISort {
    /**
     * 实现排序接口
     *
     * @param data
     */
    @Override
    public int[] sort(int[] data) {
        // 求最大值和最小值
        int maxValue = data[0];
        int minValue = data[0];
        for (int value : data) {
            if (value > maxValue) {
                maxValue = value;
            }
            if (value < minValue) {
                minValue = value;
            }

        }

        // 创建统计数据组并统计对应元素的个数
        int[] countArray = new int[maxValue - minValue + 1];

        for (int i = 0; i < data.length; i++) {
            countArray[data[i] - minValue]++;
        }

        // 统计数组做变形，后面的元素等于前面的元素之和
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] sortedArray = new int[data.length];

        // 倒序遍历原始数组，从统计数组里找到正确位置，并输出到结果数组里
        for (int i = data.length - 1; i >= 0; i--) {
            sortedArray[countArray[data[i] - minValue]-1] = data[i];
            countArray[data[i] - minValue]--;
        }
        return sortedArray;
    }
}
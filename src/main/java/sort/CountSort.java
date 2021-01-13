package sort;

/**
 * @author feigeswjtu.cyf
 * @version $Id: CountSort.java, v 0.1 2021-01-12 16:58 feigeswjtu.cyf Exp $$
 */
public class CountSort implements ISort {
    /**
     * 实现排序接口
     *
     * @param data
     */
    @Override
    public int[] sort(int[] data) {
        // 求最大值
        int maxValue = maxValue(data);
        // 中间数组
        int[] countArray = new int[maxValue + 1];

        for (int i = 0; i < data.length; i++) {
            countArray[data[i]]++;
        }
        // 遍历数组
        int[] sortedArray = new int[data.length];
        int index = 0;

        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;

    }

    /**
     * @return
     */
    private int maxValue(int[] data) {

        int max = data[0];
        for (int value : data) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序算法
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class BucketSort implements ISort {
    /**
     * 实现排序接口
     *
     * @param data
     */
    @Override
    public int[] sort(int[] data) {
        // 求最大值和最小值，并得到差值d
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
        int d = maxValue - minValue;

        // 初始化桶
        int bucketNum = data.length;
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(bucketNum);

        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        // 遍历原始数组，并将每个元素放入桶中
        for (int i = 0; i < data.length; i++) {
            int num = (int)(1D * (data[i] - minValue) * (bucketNum - 1) / d);
            bucketList.get(num).add(data[i]);
        }

        // 对每个桶单独排序
        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }

        // 输出全部元素
        int[] sortedArray = new int[data.length];

        int index = 0;

        for (LinkedList<Integer> integers : bucketList) {
            for (Integer s : integers) {
                sortedArray[index] = s;
                index ++;
            }
        }
        return sortedArray;





    }
}
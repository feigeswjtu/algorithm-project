package sort;

/**
 * 桶排序算法
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class BucketSort implements ISort {
    /**
     * 排序
     *
     * @param data
     * @return
     */
    @Override
    public int[] sort(int[] data) {
        int maxValue = max(data);
        int[] dataTmp = new int[maxValue];
        for (int i = 0; i < dataTmp.length; i++) {
            dataTmp[i] = -1;
        }
        for (int i = 0; i < data.length; i++) {
            if (dataTmp[data[i]] > 0) {
                dataTmp[data[i]] += 1;
            } else {
                dataTmp[data[i]] = 1;
            }
        }
        int index = 0;
        for (int i = 0; i < dataTmp.length; i++) {
            if (dataTmp[i] > 0) {
                int count = dataTmp[i];
                for (int j = 0; j < count; j++) {
                    data[index] = i;
                    index++;
                }
            }
        }

        return data;
    }

    /**
     * 找最大值
     *
     * @param data
     * @return
     */
    private int max(int[] data) {
        int maxValue = data[0];
        for (int i = 1; i < data.length; i++) {
            if (maxValue < data[i]) {
                maxValue = data[i];
            }
        }
        return maxValue + 1;
    }
}

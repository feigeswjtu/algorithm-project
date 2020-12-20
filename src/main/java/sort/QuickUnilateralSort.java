package sort;

/**
 * 快速排序算法(无两层循环)
 *
 * 复杂度: Q(n*log(n))
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class QuickUnilateralSort implements ISort {
    private int[] data;

    @Override
    public int[] sort(int[] data) {
        this.data = data;
        quickSort(0, data.length - 1);
        return this.data;
    }

    /**
     * 快速排序
     *
     * @param startIndex
     * @param endIndex
     */
    private void quickSort(int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int i = partition(startIndex, endIndex);

        quickSort(startIndex, i - 1);
        quickSort(i + 1, endIndex);
    }

    /**
     * 分区排序
     *
     * @param startIndex
     * @param endIndex
     * @return
     */
    private int partition(int startIndex, int endIndex) {
        int tmp = data[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (data[i] < tmp) {
                mark++;
                swap(data, mark, i);
            }

        }

        data[startIndex] = data[mark];
        data[mark] = tmp;
        return mark;
    }
}

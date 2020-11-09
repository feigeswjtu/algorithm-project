package sort;

import java.util.Stack;

import sort.model.SortIndex;

/**
 * 无递归快速排序算法
 *
 * 复杂度: Q(n*log(n))
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class QuickNoRecursiveSort implements ISort {
    private int[] data;

    /**
     * 排序
     * @param data
     * @return
     */
    @Override
    public int[] sort(int[] data) {
        this.data = data;
        quickSort(0, data.length - 1);
        return this.data;
    }

    /**
     * 快速排序
     * @param startIndex
     * @param endIndex
     */
    private void quickSort(int startIndex, int endIndex) {
        Stack<SortIndex> indexStack = new Stack<>();

        if (startIndex >= endIndex) {
            return;
        }

        indexStack.push(new SortIndex(startIndex, endIndex));
        while (!indexStack.isEmpty()) {
            SortIndex popIndex = indexStack.pop();

            int pivotIndex = partition(popIndex.getStartIndex(), popIndex.getEndIndex());
            if (popIndex.getStartIndex() < pivotIndex - 1) {
                indexStack.push(new SortIndex(popIndex.getStartIndex(), pivotIndex - 1));
            }
            if (popIndex.getEndIndex() > pivotIndex + 1) {
                indexStack.push(new SortIndex(pivotIndex + 1, popIndex.getEndIndex()));
            }
        }
    }

    /**
     * 分区排序
     *
     * @param startIndex
     * @param endIndex
     * @return
     */
    private int partition(int startIndex, int endIndex) {
        int i = startIndex;
        int j = endIndex;
        int tmp = data[i];

        while (i < j) {
            //从右边开始移动的原因是左边第一个是关键值，肯定不会大于关键值
            while (data[j] >= tmp && i < j) {
                j--;
            }
            data[i] = data[j];
            while (data[i] <= tmp && i < j) {
                i++;
            }
            data[j] = data[i];
        }
        data[i] = tmp;
        return i;
    }
}

package sort;

import java.util.Arrays;

/**
 * @author feigeswjtu.cyf
 * @version $Id: HeepSort.java, v 0.1 2021-01-12 13:55 feigeswjtu.cyf Exp $$
 */
public class HeepSort implements ISort {
    /**
     * 实现排序接口
     *
     * @param data
     */
    @Override
    public int[] sort(int[] data) {
        for (int i = (data.length - 2) / 2; i >= 0; i--) {
            downAjust(data, i, data.length);
        }
        System.out.println(Arrays.toString(data));

        for (int i = data.length - 1; i > 0; i--) {
            swap(data, i, 0);
            downAjust(data, 0, i);
        }

        return data;
    }

    /**
     * 下沉调整
     *
     * @param array
     * @param parentIndex
     * @param length
     */
    private void downAjust(int[] array, int parentIndex, int length) {
        // 保存父节点值，最后赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;

        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }

            // 父节点大于任何一个孩子节点，直接跳出循环
            if (temp >= array[childIndex]) {
                break;
            }

            // 无须真正交换
            array[parentIndex] = array[childIndex];

            parentIndex = childIndex;

            childIndex = 2 * childIndex + 1;

        }
        array[parentIndex] = temp;
    }
}
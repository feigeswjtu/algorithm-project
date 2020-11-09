package sort;

/**
 * 优化冒泡排序
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class BubbleOptSort implements ISort {
    /**
     * 排序
     * @param data
     * @return
     */
    @Override
    public int[] sort(int[] data) {
        // 定义个标识表示是否进行下次循环，为true时，继续循环，false时表示已就绪退出循环
        boolean flag = true;
        for (int i = 1; i < data.length && flag; i++) {
            flag = false;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                    flag = true;
                }
            }
        }
        return data;
    }
}

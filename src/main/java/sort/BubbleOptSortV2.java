package sort;

/**
 * 优化冒泡排序第二版
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class BubbleOptSortV2 implements ISort {
    @Override
    public int[] sort(int[] data) {
        // 记录最后一次交换的位置
        int lastExchangeIndex = 0;

        // 无序数列的边界，每次只需要比较到这里就可以了
        int sortBorder = data.length - 1;
        // 定义个标识表示是否进行下次循环，为true时，继续循环，false时表示已就绪退出循环
        boolean flag = true;
        for (int i = 1; i < data.length && flag; i++) {
            flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                    flag = true;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
        }
        return data;
    }
}

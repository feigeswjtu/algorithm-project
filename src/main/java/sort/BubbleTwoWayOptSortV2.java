package sort;

/**
 * 优化双向冒泡排序（鸡尾酒排序）
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class BubbleTwoWayOptSortV2 implements ISort {
    @Override
    public int[] sort(int[] data) {
        // 定义个标识表示是否进行下次循环，为true时，继续循环，false时表示已就绪退出循环
        boolean flag = true;
        // 一半的长度
        int helfLenght = data.length / 2;

        // 记录最后一次交换的位置
        int leftLastExchangeIndex = 0;

        // 无序数列的边界，每次只需要比较到这里就可以了
        int leftSortBorder = data.length - 1;

        // 记录最后一次交换的位置
        int rightLastExchangeIndex = data.length - 1;

        // 无序数列的边界，每次只需要比较到这里就可以了
        int rightSortBorder = 0;

        // 外循环从0开始到数组最后一个元素的位置
        for (int i = 0; i < helfLenght && flag; i++) {
            flag = false;
            // 从0到data.length - i - 1，也就是说内循环从0到逐步减小的位置下标
            for (int j = i; j < leftSortBorder; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                    flag = true;
                    leftLastExchangeIndex = j;
                }
            }
            leftSortBorder = leftLastExchangeIndex;
            // 内循环从data.length-i-2到0，也就是说内循环从大到逐步减小的位置下标
            for (int j = data.length - i - 2; j - 1 >= rightSortBorder; j--) {
                if (data[j] < data[j - 1]) {
                    swap(data, j, j - 1);
                    flag = true;
                    rightLastExchangeIndex = j;

                }
            }
            rightSortBorder = rightLastExchangeIndex;
        }
        return data;
    }
}

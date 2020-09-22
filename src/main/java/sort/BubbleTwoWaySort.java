package sort;

/**
 * 双向冒泡排序（鸡尾酒排序）
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class BubbleTwoWaySort implements ISort {
    @Override
    public int[] sort(int[] data) {
        // 一半的长度
        int helfLenght = data.length / 2;

        // 外循环从0开始到数组最后一个元素的位置
        for (int i = 0; i < helfLenght; i++) {
            // 从0到data.length - i - 1，也就是说内循环从0到逐步减小的位置下标
            for (int j = i; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                }
            }
            // 内循环从data.length-i-2到0，也就是说内循环从大到逐步减小的位置下标
            for (int j = data.length - i - 2; j - 1 >= i; j--) {
                if (data[j] < data[j - 1]) {
                    swap(data, j, j - 1);
                }
            }
        }
        return data;
    }
}

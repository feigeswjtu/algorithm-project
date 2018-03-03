package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 冒泡排序
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class BubbleSort implements ISort{
    @Override
    public int[] sort(int[] data) {
        // 外循环从0开始到数组最后一个元素的位置
        for (int i = 0; i < data.length; i++){
            // 内循环从0到data.length - i - 1，也就是说内循环从0到逐步减小的位置下标
            for (int j = 0; j < data.length - i - 1; j++){
                if(data[j] > data[j + 1]){
                    swap(data, j, j + 1);
                }
            }
        }
        return data;
    }
}

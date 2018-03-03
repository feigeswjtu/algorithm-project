package sort;

/**
 * 冒泡排序
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class BubbleOptSort implements ISort{
    @Override
    public int[] sort(int[] data) {
        boolean flag = true;
        for (int i = 1; i < data.length && flag; i++){
            for (int j = 0; j < data.length - i - 1; j++){
                if(data[j] > data[j + 1]){
                    swap(data, j, j + 1);
                    flag = true;
                }
            }
        }
        return data;
    }
}

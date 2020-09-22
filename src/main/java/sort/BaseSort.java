package sort;

/**
 * 基础排序算法
 * 最差的排序算法，必须经过完整的两次循环
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class BaseSort implements ISort{
    @Override
    public int[] sort(int[] data) {
        for (int i = 0; i < data.length; i++){
            for (int j = i + 1; j < data.length; j++){
                if(data[j] < data[i]){
                    swap(data, j, i);
                }
            }
        }
        return data;
    }
}

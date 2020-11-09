package sort;

/**
 * 选择排序算法
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class SelectionSort implements ISort{
    /**
     * 排序
     * @param data
     * @return
     */
    @Override
    public int[] sort(int[] data) {
        for(int i = 0; i < data.length; i++){
            int k = i;
            for(int j = k + 1; j < data.length; j++){
                if(data[k] > data[j]){
                    k = j;
                }
            }
            if(k != i){
                swap(data, k, i);
            }

        }
        return data;
    }
}

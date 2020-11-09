package sort;

/**
 * 插入排序
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class InsertionSort implements ISort{
    /**
     * 排序
     * @param data
     * @return
     */
    @Override
    public int[] sort(int[] data) {
        for (int i = 1; i < data.length; i++){
            for (int j = i; j > 0; j--){
               if(data[j] < data[j-1]){
                   swap(data, j, j-1);
               }
            }
        }
        return data;
    }
}

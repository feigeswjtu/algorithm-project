package sort;

/**
 * 选择排序
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class InsertionSort implements ISort{
    @Override
    public int[] sort(int[] data) {
        //从第二个元素开始算起
        for (int i = 1; i < data.length; i++){
            //对比的元素
            int tmp = data[i];
            for (int j = i; j > 0; j--){
                //如果前一个值小于对比的元素，进行交换
               if(data[j] < data[j-1]) {
                   data[j] = data[j - 1];
                   data[j - 1] = tmp;
               }
            }
        }
        return data;
    }
}

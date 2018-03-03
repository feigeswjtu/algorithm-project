package sort;

/**
 * 基础排序算法
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class QuickSort implements ISort{
    private int []data;
    @Override
    public int[] sort(int[] data) {
        this.data = data;
        quitSort(0, data.length - 1);
        return this.data;
    }

    private void quitSort(int left, int right){
        int i = left;
        int j = right;
        int tmp = data[i];
        if(left >= right){
            return;
        }

        while(i < j){
            //从右边开始移动的原因是左边第一个是关键值，肯定不会大于关键值
            while (data[j] >= tmp && i<j){
               j--;
            }
            data[i] = data[j];
            while (data[i] <= tmp && i<j){
               i++;
            }
            data[j] = data[i];
        }
        data[i] = tmp;
        quitSort(left, i-1);
        quitSort(i+1, right);
    }
}

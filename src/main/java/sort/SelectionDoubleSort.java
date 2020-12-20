package sort;

/**
 * 基础排序算法
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class SelectionDoubleSort implements ISort{
    @Override
    public int[] sort(int[] data) {
        //最左边的元素下标
        int left = 0;
        //最右边的元素下标
        int right = data.length - 1;
        while(left < right){
            int min=left;
            int max=right;
            for(int j = left; j <= right; j++){
                //找出最小值的坐标
                if(data[j] < data[min]){
                    min = j;
                }
                //找出最大值的坐标
                if(data[j] > data[max]){
                    max = j;
                }
            }
            //如果最小值有变化，交换
            if(left != min){
                swap(data, left, min);
            }
            //如果最大值有变化，交换
            if(right != max){
                swap(data, right, max);
            }
            //左边坐标右移一位
            left++;
            //左边坐标左移一位
            right--;
        }
        return data;
    }
}

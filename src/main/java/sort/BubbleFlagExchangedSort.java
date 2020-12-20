package sort;

/**
 * 冒泡排序
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class BubbleFlagExchangedSort implements ISort{
    @Override
    public int[] sort(int[] data) {
        //设置一个标志
        boolean flag = true;
        int k = data.length - 2;
        int lastExchange = 0;
        for (int i = 1; i < data.length; i++){
            //每次循环都初始化为true
            flag = true;
            //只循环到最后交换的位置
            for (int j = 0; j < k; j++){
                if(data[j] > data[j + 1]){
                    swap(data, j, j + 1);
                    //如果有数据交换，flag置为false
                    flag = false;
                    //记录最后交换的位置
                    lastExchange = j;
                }
            }
            k = lastExchange;
            //如果没有数据交换，直接退出循环
            if(flag){
                break;
            }
        }
        return data;
    }
}

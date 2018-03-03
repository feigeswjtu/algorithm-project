package sort;

import java.util.List;

public interface ISort {
    //核心接口
    int[] sort(int []data);
    //交换
    default void swap(int[] data, int i, int j){
        data[i] = data[i] ^ data[j];
        data[j] = data[i] ^ data[j];
        data[i] = data[i] ^ data[j];
    }
    // 打印数组
    default void print(int [] data){
        System.out.println("");
        for(int i = 0; i < 50; i++){
            System.out.print(data[i]);
            System.out.print(", ");
        }
        System.out.println("");
    }
}

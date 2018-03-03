package array;

/**
 * Created by Administrator on 2017/7/17.
 */
public class SearchService {
    int arraySearch(int []a, int key){
        for (int i=0; i<a.length; i++){
            if(key == a[i]){
                return i;
            }
        }
        return -1;
    }
    //优化查找算法
    int arraySearch2(int []a, int key){
        int tmp = a[0];
        if(a[0] == key){
            return 0;
        }else {
            a[0] = key;
        }
        int i = a.length - 1;
        while (a[i] != key){
            i--;
        }
        a[0] = tmp;
        if(i == 0){
            return -1;
        }else {
            return i;
        }
    }

    //二分查找算法
    int binarySearch(int []a, int key){
        int low = 0;
        int high = a.length - 1;
        int i = 0;
        while (low < high){
            i = (low + high)/2;
            //优化的折半查找
            //i = low + (high - low)*(key -a[low])/(a[high] - a[low]);
            if(a[i] == key){
                return i;
            }else if (a[i] < high){
                low = i;
            }else {
                high = i;
            }
        }
        return -1;
    }


}

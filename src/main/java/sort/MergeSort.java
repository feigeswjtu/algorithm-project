package sort;

/**
 * 归并排序算法
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class MergeSort implements ISort{
    private int[] tmpData;

    /**
     * 排序
     * @param data
     * @return
     */
    @Override
    public int[] sort(int[] data) {//自顶而下的排序算法
        this.tmpData = new int[data.length];
        for(int grap = 1; grap < data.length; grap *= 2){
            for (int low = 0; low < data.length - grap; low += grap * 2){
                merge(data, low, low + grap - 1, Math.min(low + grap * 2 - 1, data.length - 1));
            }
        }
       return data;
    }
//    @Override
//    public int[] sort(int []data){
//
//        this.tmpData = new int[data.length];
//        sortSelf(data, 0, data.length - 1);
//        return data;
//    }
//
//    public void sortSelf(int []data, int low, int high){
//        if(low >= high)return;
//        int mid = (high + low)/2;
//        sortSelf(data, low, mid);
//        sortSelf(data, mid + 1, high);
//        merge(data, low, mid, high);
//    }

    /**
     * 合并
     *
     * @param data
     * @param low
     * @param mid
     * @param high
     */
    private void merge(int []data, int low, int mid, int high){
        int i = low;
        int j = mid + 1;
        for(int k = low; k <= high; k++){
            tmpData[k] = data[k];
        }
        for (int k = low; k <= high; k++){
            if (i > mid){
                data[k] = tmpData[j++];
            }else if(j > high){
                data[k] = tmpData[i++];
            }else if(tmpData[j] < tmpData[i]){
                data[k] = tmpData[j++];
            }else {
                data[k] = tmpData[i++];
            }
        }
        print(data);
    }
//可行，效率较低
//    private void merge(int []data, int low, int mid, int high){
//        int indexI = low;
//        int indexJ = mid;
//        int index = 0;
//        while(indexI < mid && indexJ < high){
//            if(data[indexI] < data[indexJ]){
//                tmpData[index] = data[indexI];
//                indexI++;
//            }else {
//                tmpData[index] = data[indexJ];
//                indexJ++;
//            }
//            index++;
//        }
//        while (indexI < mid){
//            tmpData[index] = data[indexI];
//            index++;
//            indexI++;
//        }
//        while (indexJ < high){
//            tmpData[index] = data[indexJ];
//            index++;
//            indexJ++;
//        }
//        for(index = 0; index < high - low; index++){
//            data[low + index] = tmpData[index];
//        }
//        print(data);
//        int i =1;
//    }

}

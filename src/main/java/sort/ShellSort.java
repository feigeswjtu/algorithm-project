package sort;

/**
 * 希尔排序
 *
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class ShellSort implements ISort {
    /**
     * 排序
     *
     * @param data
     * @return
     */
    @Override
    public int[] sort(int[] data) {
        //设定希尔增量为{n/2,(n/2)/2...1}
        for(int grap = data.length/2; grap > 0; grap /= 2) {
            // 按照增量分割数组
            for (int i = 0; i < data.length; i = i + grap) {
                //循环处理
                for (int j = i; j > 0; j = j - grap) {
                    if (data[j] < data[j - 1]) {
                        swap(data, j, j - 1);
                    }
                }
            }
        }
        return data;
    }
}

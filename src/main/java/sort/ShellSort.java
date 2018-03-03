package sort;

/**
 * 选择排序
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class ShellSort implements ISort{
    @Override
    public int[] sort(int[] data) {
        for(int grap = data.length/2; grap > 0; grap--) {
            for (int i = 0; i < data.length; i = i + grap) {
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

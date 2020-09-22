package sort;

public interface ISort {
    /**
     * 实现排序接口
     */
    int[] sort(int[] data);

    /**
     * 交换数据
     *
     * @param data
     * @param i
     * @param j
     */
    default void swap(int[] data, int i, int j) {
        data[i] = data[i] ^ data[j];
        data[j] = data[i] ^ data[j];
        data[i] = data[i] ^ data[j];
    }

    /**
     * 打印数据
     * @param data
     */
    default void print(int[] data) {
        System.out.println("");
        for (int i = 0; i < 50; i++) {
            System.out.print(data[i]);
            System.out.print(", ");
        }
        System.out.println("");
    }
}

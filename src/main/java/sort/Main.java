package sort;

public class Main {
    public static void main(String[] args) {
        // 初始化一个排序类
        ISort sort = new QuickNoRecursiveSort();
        //初始化数组
        int[] data = {42, 41, 14, 14, 27, 24, 0, 3, 25, 2, 42, 11, 20, 9, 41, 37, 9, 1, 10, 16, 28, 19, 12, 39, 11, 19, 6, 26, 44, 4, 21, 10, 40, 27, 43, 35, 41, 42, 17, 17, 9, 32, 35, 0, 30, 40, 16, 32, 32, 48};
        //排序
        sort.sort(data);
        //打印排序结果
        sort.print(data);

    }
}

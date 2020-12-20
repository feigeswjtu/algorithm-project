package sort;

import java.util.Stack;

/**
 * 基础排序算法
 * 复杂度: Q(n*n)
 * 稳定性: 稳定排序算法
 * 空间复杂度: Q(1)
 */
public class QuickNoRecursiveSort implements ISort{
    private int []data;
    @Override
    public int[] sort(int[] data) {
        this.data = data;
        quitSort(0, data.length - 1);
        return this.data;
    }

    private void quitSort(int left, int right){
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while(!stack.empty()) {
            int rightTmp = stack.pop();
            int leftTmp = stack.pop();
            int i = leftTmp;
            int j = rightTmp;
            int tmp = data[i];
            while (i < j) {
                //从右边开始移动的原因是左边第一个是关键值，肯定不会大于关键值
                while (data[j] >= tmp && i < j) {
                    j--;
                }
                data[i] = data[j];
                while (data[i] <= tmp && i < j) {
                    i++;
                }
                data[j] = data[i];
            }
            data[i] = tmp;
            // 交换右边
            if(leftTmp < i - 1){
                stack.push(leftTmp);
                stack.push(i-1);
            }
            if(i + 1 < rightTmp){
                stack.push(i+1);
                stack.push(rightTmp);
            }
        }
    }
}

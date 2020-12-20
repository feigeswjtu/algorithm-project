package problems;

/**
 * 求最大子数组
 *
 * @author chenyafei
 * @version 1.0
 * @date 19/03/2018 16:42
 */

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] array = new int[]{2,4,-7,5,2,-1,2,-4,3};
        System.out.println(function3(array));

    }
    //暴力查找，3层循环
    private static int function1(int[] array){
        int thisSum = 0;
        int maxSum = 0;
        int length = array.length;
        for(int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                thisSum = 0;
                for (int k = i; k <= j; k++)
                    thisSum += array[k];

                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        return maxSum;
    }

    //根据前一次计算的值来计算后一次，少一次循环
    private static int function2(int[] array){
        int thisSum = 0;
        int maxSum = 0;
        int length = array.length;
        for(int i = 0; i < length; i++) {
            thisSum = 0;
            for (int j = i; j < length; j++) {
                thisSum += array[j];
                if (thisSum > maxSum)
                    maxSum = thisSum;
            }
        }
        return maxSum;

    }

    private static int function3(int[] array) {
        int thisSum = 0;
        int maxSum = 0;
        int length = array.length;
        for(int i = 0; i < length; i++) {
            thisSum += array[i];
            if(thisSum > maxSum)
                maxSum = thisSum;
        /*如果累加和出现小于0的情况，
           则和最大的子序列肯定不可能包含前面的元素，
           这时将累加和置0，从下个元素重新开始累加  */
            else if(thisSum< 0)
                thisSum= 0;
        }
        return maxSum;
    }
}

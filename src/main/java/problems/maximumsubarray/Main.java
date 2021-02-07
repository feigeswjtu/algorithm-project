package problems.maximumsubarray;

/**
 * 最大子数组实现
 *
 * @author feigeswjtu.cyf
 * @version $Id: Main.java, v 0.1 2021-02-05 16:05 feigeswjtu.cyf Exp $$
 */
public class Main {
    public static void main(String[] args) {
        MaximumSubArrayService subArrayService = new DynamicProgrammingServiceImpl();
        int[] array = {-2, -1, -3, 4, -1, 2, 1, -5, 4};
        int maximumSubArrayValue = subArrayService.findMaximumSubArrayValue(array);
        System.out.println(maximumSubArrayValue);
    }
}
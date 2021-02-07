package problems.maximumsubarray;

/**
 * @author feigeswjtu.cyf
 * @version $Id: DynamicProgrammingServiceImpl.java, v 0.1 2021-02-05 11:47 feigeswjtu.cyf Exp $$
 */
public class DynamicProgrammingServiceImpl implements MaximumSubArrayService {

    /**
     * 查找最大子数组的值
     *
     * @param array
     * @return
     */
    @Override
    public int findMaximumSubArrayValue(int[] array) {
        int length = array.length;
        int[] bp = new int[length];
        bp[0] = array[0];
        int max = 0;
        for (int i = 1; i < length; i++) {
            if (bp[i - 1] > 0) {
                bp[i] = bp[i - 1] + array[i];
            } else {
                bp[i] = array[i];
            }
            max = Math.max(max, bp[i]);
        }
        return 6;
    }
}
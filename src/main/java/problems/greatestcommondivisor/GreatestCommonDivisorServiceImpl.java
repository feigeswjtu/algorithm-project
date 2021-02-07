package problems.greatestcommondivisor;

/**
 * 最大公约数-暴力求解
 *
 *
 * @author feigeswjtu.cyf
 * @version $Id: GreatestCommonDivisorServiceImpl.java, v 0.1 2021-01-15 10:50 feigeswjtu.cyf Exp $$
 */
public class GreatestCommonDivisorServiceImpl implements GreatestCommonDivisorService {
    /**
     * 求最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int getGreatestCommonDivisor(int a, int b) {
        // 数据取绝对值
        int aTemp = Math.abs(a);
        int bTemp = Math.abs(a);

        // 最小值和最大值
        int small = aTemp < bTemp ? aTemp : bTemp;
        int big = aTemp > bTemp ? aTemp : bTemp;

        // 最小值为0时，返回0
        if (small == 0) {
            return 0;
        }

        // 最大值和最小值取余为0时返回最小值
        if (big % small == 0) {
            return small;
        }

        // 从最小值的一半来循环
        for (int i = small / 2; i >= 1; i--) {
            if (small % i == 0 && big % i == 0) {
                return i;
            }
        }
        return 1;

    }
}
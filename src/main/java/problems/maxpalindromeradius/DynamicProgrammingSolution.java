package problems.maxpalindromeradius;

/**
 * 动态规划算法
 *
 * @author feigeswjtu.cyf
 * @version $Id: DynamicProgrammingSolution.java, v 0.1 2021-02-04 11:38 feigeswjtu.cyf Exp $$
 */
public class DynamicProgrammingSolution implements MaxPalindromeRadiusSolution {

    /**
     * 最大回文
     *
     * @param s
     * @return
     */
    @Override
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int length = s.length();

        boolean[][] dp = new boolean[length][length];
        int left = 0;
        int right = 0;

        for (int i = length - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < length; j++) {
                //小于3是因为aba一定是回文
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && right - left < j - i) {
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left, right+1);
    }
}
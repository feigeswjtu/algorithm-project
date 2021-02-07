package problems.longestvalidbracket;

/**
 * 动态规划解法
 *
 * @author feigeswjtu.cyf
 * @version $Id: DynamicProgrammingSolution.java, v 0.1 2021-02-05 10:32 feigeswjtu.cyf Exp $$
 */
public class DynamicProgrammingSolution implements LongestValidBracketSolution {
    /**
     * 最长有效括号
     *
     * @param s
     * @return
     */
    @Override
    public int longestValidBracket(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int length = s.length();
        int dp[] = new int[length];

        int maxLength = 0;

        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            }

            if (s.charAt(i) == ')') {
                if (i - 2 >= 0 && s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
package problems.longestvalidbracket;

/**
 * 双指针计数解法
 *
 * @author feigeswjtu.cyf
 * @version $Id: DynamicProgrammingSolution.java, v 0.1 2021-02-05 10:32 feigeswjtu.cyf Exp $$
 */
public class CountSolution implements LongestValidBracketSolution {
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

        int leftLength = 0;
        int rightLength = 0;

        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                leftLength += 1;
            } else {
                rightLength += 1;
            }
            if (leftLength == rightLength) {
                maxLength = Math.max(maxLength, rightLength);
            }

            if (rightLength > leftLength) {
                leftLength = 0;
                rightLength = 0;
            }
        }
        leftLength = 0;
        rightLength = 0;

        for (int i = length -1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                leftLength += 1;
            } else {
                rightLength += 1;
            }
            if (leftLength == rightLength) {
                maxLength = Math.max(maxLength, rightLength);
            }

            if (leftLength > rightLength) {
                leftLength = 0;
                rightLength = 0;
            }
        }

        return maxLength * 2;
    }
}
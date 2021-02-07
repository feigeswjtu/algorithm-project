package problems.maxpalindromeradius;

/**
 * 最大回文半径
 *
 * @author feigeswjtu.cyf
 * @version $Id: Main.java, v 0.1 2021-02-04 11:29 feigeswjtu.cyf Exp $$
 */
public class Main {
    public static void main(String[] args) {
        MaxPalindromeRadiusSolution solution = new DynamicProgrammingSolution();
        String s = solution.longestPalindrome("abcdcef");
        System.out.println(s);
    }
}
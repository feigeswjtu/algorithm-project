package problems.longestvalidbracket;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Main.java, v 0.1 2021-02-05 10:56 feigeswjtu.cyf Exp $$
 */
public class Main {
    public static void main(String[] args) {
        LongestValidBracketSolution solution = new DynamicProgrammingSolution();
        int i = solution.longestValidBracket("()()()");
        System.out.println(i);

        i = solution.longestValidBracket("()())()");
        System.out.println(i);

        i = solution.longestValidBracket("()()(()");
        System.out.println(i);


        i = solution.longestValidBracket(")()())(())(((())))");
        System.out.println(i);
    }
}
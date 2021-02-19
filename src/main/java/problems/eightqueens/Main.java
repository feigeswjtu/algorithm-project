package problems.eightqueens;

/**
 * 八皇后问题
 *
 * @author feigeswjtu.cyf
 * @version $Id: Main.java, v 0.1 2021-02-07 10:24 feigeswjtu.cyf Exp $$
 */
public class Main {
    public static void main(String[] args) {
        EightQueensSolution eightQueensSolution = new BacktrackingFinalSolution();

        System.out.println(eightQueensSolution.countMethod(8));
    }
}
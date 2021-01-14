package problems.minstack;

/**
 * @author feigeswjtu.cyf
 * @version $Id: MinStack.java, v 0.1 2021-01-14 11:03 feigeswjtu.cyf Exp $$
 */
public interface MinStack {
    /**
     * 入栈
     *
     * @param integer
     */
    void push(Integer integer);

    /**
     * 出栈
     *
     * @return
     */
    Integer pop();

    /**
     * 获取最小值
     *
     * @return
     */
    Integer getMin();

}
package problems.minstack;

import java.util.Stack;

/**
 * @author feigeswjtu.cyf
 * @version $Id: MinStackImpl.java, v 0.1 2021-01-14 11:05 feigeswjtu.cyf Exp $$
 */
public class MinStackImpl implements MinStack {
    private Stack<Integer> wholeStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /**
     * 入栈
     *
     * @param integer
     */
    @Override
    public void push(Integer integer) {
        wholeStack.push(integer);
        if (integer == null) {return;}

        if (minStack.isEmpty()) {
            minStack.push(integer);
            return;
        }

        Integer peekValue = minStack.peek();
        if (integer.compareTo(peekValue) < 0) {
            minStack.push(integer);
        }
    }

    /**
     * 出栈
     *
     * @return
     */
    @Override
    public Integer pop() {
        if (wholeStack.size() == 0) {
            return null;
        }

        Integer popInteger = wholeStack.pop();
        if (popInteger == null) {return null;}

        Integer peek = minStack.peek();

        if (minStack.isEmpty()) {
            return popInteger;
        }

        if (peek == null) {
            return popInteger;
        }

        if (peek == popInteger) {
            minStack.pop();
        }

        return popInteger;
    }

    /**
     * 获取最小值
     *
     * @return
     */
    @Override
    public Integer getMin() {
        if (minStack.isEmpty()) {
            return null;
        }
        return minStack.peek();
    }
}
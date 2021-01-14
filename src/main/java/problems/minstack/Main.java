package problems.minstack;

import org.testng.Assert;

/**
 * @author feigeswjtu.cyf
 * @version $Id: Main.java, v 0.1 2021-01-14 11:12 feigeswjtu.cyf Exp $$
 */
public class Main {
    public static void main(String[] args) {

        // 测试入栈值: 4, 9, 7, 3
        // 出栈 3
        MinStack minStack = new MinStackImpl();
        Integer pop = minStack.pop();
        Assert.assertNull(pop);

        Integer min = minStack.getMin();
        Assert.assertNull(min);

        minStack.push(4);

         min = minStack.getMin();
        Assert.assertEquals(min.intValue(), 4);

        minStack.push(9);

        min = minStack.getMin();
        Assert.assertEquals(min.intValue(), 4);

        minStack.push(7);

        min = minStack.getMin();
        Assert.assertEquals(min.intValue(), 4);

        minStack.push(3);

        min = minStack.getMin();
        Assert.assertEquals(min.intValue(), 3);

         pop = minStack.pop();
        Assert.assertEquals(pop.intValue(), 3);

        min = minStack.getMin();
        Assert.assertEquals(min.intValue(), 4);
    }
}
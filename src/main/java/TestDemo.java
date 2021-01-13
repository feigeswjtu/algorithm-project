import java.lang.reflect.Method;

/**
 * @author feigeswjtu.cyf
 * @version $Id: TestDemo.java, v 0.1 2021-01-04 17:22 feigeswjtu.cyf Exp $$
 */
public class TestDemo {
    public static void main(String[] args) {
        Class<?>[] classes = Character.class.getClasses();
        for (Class<?> aClass : classes) {
            System.out.println(aClass.getName());


        }
        System.out.println("====================");
        Class<?>[] declaredClasses = Character.class.getDeclaredClasses();
        for (Class<?> declaredClass : declaredClasses) {
            System.out.println(declaredClass.getName());

        }
    }
}
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-05-23
 * Time:23:46
 */
public class Test {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("TestEnum");
            Constructor<?> constructor=c.getDeclaredConstructor(int.class,String.class);
            constructor.setAccessible(true);

            TestEnum testEnum=(TestEnum) constructor.newInstance(1,"白色");

            System.out.println(testEnum);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-05-23
 * Time:20:37
 */
public class ReflectClassDemo {
    //实例化对象
    public static void reflectNewInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> c = Class.forName("Student");

        Student student = (Student)c.newInstance();
        System.out.println(student);
    }

    //调用私有构造方法
    public static void reflectPrivateConstructor() {
        try {
            Class<?> c = Class.forName("Student");
            Constructor<?> constructor = c.getDeclaredConstructor(String.class,int.class);

            constructor.setAccessible(true);
            Student student = (Student) constructor.newInstance("zhangsan",19);
            System.out.println(student);


        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //反射属性
    public static void reflectPrivateField(){
        Class<?> c = null;
        try {
            c = Class.forName("Student");
            Student student = (Student)c.newInstance();

            Field field = c.getDeclaredField("name");
            field.setAccessible(true);
            field.set(student,"abc");

            System.out.println(student);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }


    }

    //反射私有的方法
    public static void reflectPrivateMethod(){
        try {
            Class<?> c = Class.forName("Student");
            Student student = (Student) c.newInstance();

            Method method = c.getDeclaredMethod("eat",String.class);

            method.setAccessible(true);
            method.invoke(student,"gaobo");

            System.out.println(student);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        reflectPrivateConstructor();
        reflectPrivateField();
        reflectPrivateMethod();
    }


    public static void main1(String[] args) {
        try {
            reflectNewInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

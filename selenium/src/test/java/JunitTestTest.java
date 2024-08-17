import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class JunitTestTest {

    @Test
    public void test1() {
        System.out.println("111");
    }

    @Test
    public void test2() {
        System.out.println("222");
    }

    @Ignore
    void ignore1() {
        System.out.println("ignore1   ");
    }

    @BeforeAll
    public static void befor1() {
        //所有测试方法前会执行一遍 总共执行一遍
        System.out.println("befor1   test");
    }

    @AfterAll
    public static void after1() {
        //所有测试方法后会执行一遍 总共执行一遍
        System.out.println("after1  test");
    }

    @BeforeEach
    public void befor2() {
        //几个test注解 就执行几遍
        System.out.println("befor2  test");
    }

    @AfterEach
    public void after2() {
        //几个test注解 就执行几遍
        System.out.println("after2  test");
    }
}
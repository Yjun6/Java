/**
 * Created with IntelliJ IDEA.
 * Description:枚举类
 * User:Yu
 * Date:2023-05-23
 * Time:23:48
 */
public enum TestEnum {
    REN(0,"红色"),BLACK(1,"蓝色"),GREEN(2,"绿色");

    public int ordinal;
    public String color;

    @Override
    public String toString() {
        return "TestEnum{" +
                "ordinal=" + ordinal +
                ", color='" + color + '\'' +
                '}';
    }

    TestEnum(int ordinal, String color){

    }

    public static void main(String[] args) {
        TestEnum[] testEnums = TestEnum.values();
        for (TestEnum n:testEnums) {
            System.out.println(n+"  "+n.ordinal());
        }

        System.out.println(TestEnum.valueOf("REN"));

        System.out.println(REN.compareTo(BLACK));

    }

    public static void main1(String[] args) {
        TestEnum testEnum1= TestEnum.REN;
        TestEnum testEnum2 = TestEnum.BLACK;
        TestEnum testEnum3 = TestEnum.GREEN;
    }
}

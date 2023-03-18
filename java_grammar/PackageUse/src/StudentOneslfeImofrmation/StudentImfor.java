package StudentOneslfeImofrmation;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-18
 * Time:16:04
 */
public class StudentImfor {
    public String name;//姓名
    public int age;//年龄
    private String address;//地址 私有

    public StudentImfor() {
    }

    public StudentImfor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

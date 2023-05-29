/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-05-29
 * Time:9:47
 */
public class Employee {
    private Integer id;//编号
    private String name;//姓名
    private String sex;//性别
    private Integer age;//年龄
    private String position;//工作岗位
    private Double salary;//工资
    private String phone;//电话
    private String address;//地址

    public Employee(Integer id, String name, String sex,
                    Integer age, String position, Double salary,
                    String phone, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.phone = phone;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

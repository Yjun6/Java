package cn.newdream.entity;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-01
 * Time:18:58
 */
public class Officers {
    private Integer id;//编号
    private String name;//名字
    private String office;//职位
    private String number;//执法证号
    private String department;//所属部门
    private String jpg;//图片链接

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

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJpg() {
        return jpg;
    }

    public void setIpg(String Jpg) {
        this.jpg = jpg;
    }
}

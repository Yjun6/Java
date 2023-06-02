package cn.newdream.entity;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-06-01
 * Time:23:23
 */
public class Responsibilities {
    private Integer id;//编号
    private String type;//权力类型
    private String name;//名称
    private String basis;//依据
    private String matters;//责任事项
    private String basis_matters;//责任事项依据
    private String division;//责任处室
    private String matter_range;//追责对象范围
    private String remark;//备注信息

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis;
    }

    public String getMatters() {
        return matters;
    }

    public void setMatters(String matters) {
        this.matters = matters;
    }

    public String getBasis_matters() {
        return basis_matters;
    }

    public void setBasis_matters(String basis_matters) {
        this.basis_matters = basis_matters;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getMatter_range() {
        return matter_range;
    }

    public void setMatter_range(String matter_range) {
        this.matter_range = matter_range;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

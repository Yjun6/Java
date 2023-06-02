package cn.newdream.entity;

/**
 * Created with IntelliJ IDEA.
 * Description:内设机构
 * User:Yu
 * Date:2023-06-02
 * Time:15:00
 */
public class Institutions {
    int id;//编号
    String name;//机构名称
    String time;//时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

package dao;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * Description: 通过这个类的对象，表示一条Blog表中的记录
 * Description: 这个类的属性要和Bolg表的列匹配
 * User:Yu
 * Date:2023-10-15
 * Time:22:05
 */
public class Blog {
    private int blogId;
    private String title;
    private String content;
    private int userId;
    /* sql中有 timestamp 类型, 还有 datetime 类型 */
    // sql里的timestamp只有4字节，在2038年之后就不够用了
    // java的timestamp是可以使用的
    private Timestamp postTime;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", postTime=" + postTime +
                '}';
    }
}

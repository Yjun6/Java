package Test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Stu implements Comparable<Stu>{
    String name;
    int age;
    double score;

    public Stu(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Test.Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Stu o) {
        return o.age - this.age;
    }
}
public class Test {
    public static void main(String[] args) {
        Stu[] stu = new Stu[3];
        stu[0] = new Stu("邹雨洁", 19, 79.5);
        stu[1] = new Stu("欧泽辉", 20, 89.3);
        stu[2] = new Stu("黄志文", 18, 84.2);
        System.out.println("排序前" + Arrays.toString(stu));
        Arrays.sort(stu);
        System.out.println("排序后" + Arrays.toString(stu));

    }
}
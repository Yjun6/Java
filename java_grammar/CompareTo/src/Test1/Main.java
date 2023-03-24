package Test1;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-24
 * Time:21:02
 */

class Stu {
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
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

class AgeComparetor implements Comparator<Stu>{

    @Override
    public int compare(Stu s1,Stu s2){
        return s1.age - s2.age;
    }
}

public class Main {

    public static void main(String[] args) {
        Stu[] stu = new Stu[3];
        stu[0] = new Stu("邹雨洁", 19, 79.5);
        stu[1] = new Stu("欧泽辉", 20, 89.3);
        stu[2] = new Stu("黄志文", 18, 84.2);

        AgeComparetor ageComparetor = new AgeComparetor();
        int ret = ageComparetor.compare(stu[0], stu[1]);
        System.out.println(ret);

    }
}

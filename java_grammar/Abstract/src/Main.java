/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

abstract class Tree{
    public String variety;//品种
    public static String ascription;//归属

    public Tree(String variety) {
        this.variety = variety;
    }

    static{
        ascription = "中国特有";
    }

    public abstract void flower();//开花
    public abstract void sprout();//发芽
}

class Peach extends Tree{
    String name;

    public Peach(String variety, String name) {
        super(variety);
        this.name = name;
    }

    @Override
    public void flower() {
        System.out.println(this.name+"在开花");
    }

    @Override
    public void sprout() {
        System.out.println(this.name+"在发芽");
    }
}

public class Main {
    public static void main(String[] args) {
        Peach peach = new Peach("正交", "桃花树");
        peach.flower();
        peach.sprout();
    }
}
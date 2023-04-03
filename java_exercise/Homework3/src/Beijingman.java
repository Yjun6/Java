/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-03
 * Time:16:15
 */
public class Beijingman extends Chinese {
    public void beijingOpera(){
        System.out.println("北京欢迎你");
    }

    @Override
    public void speakHello() {
        System.out.println("北京人说普通话");
    }

    @Override
    public void averageHeight() {
        System.out.println("北京人的平均身高是：172.5厘米");
    }

    @Override
    public void averageWeight() {
        System.out.println("北京人的平均体重是：74公斤");
    }
}

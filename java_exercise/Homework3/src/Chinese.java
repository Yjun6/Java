/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-03
 * Time:16:15
 */
public class Chinese extends People{
    public void chinaGongfu(){
        System.out.println("中国人会中国功夫");
    }

    @Override
    public void speakHello() {
        System.out.println("您好");
    }

    @Override
    public void averageHeight() {
        System.out.println("中国人的平均身高是：168.78厘米");
    }

    @Override
    public void averageWeight() {
        System.out.println("中国人的平均体重是：125斤");
    }
}

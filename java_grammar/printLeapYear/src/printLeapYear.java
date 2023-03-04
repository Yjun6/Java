/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-04
 * Time:22:40
 */
public class printLeapYear {
    public static void main(String[] args) {
        //输出 1000 - 2000 之间所有的闰年
        System.out.println("1000-2000年之间的闰年有：");
        for(int i = 1000; i <= 2000; i++){
            if(i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)){
                System.out.print(i + " ");
            }
            if(i == 1100 || i == 1200 || i == 1300
                    || i == 1400 || i == 1500 || i == 1600
                    || i == 1700 || i == 1800 || i == 1900){
                System.out.println();
            }
        }
        System.out.println();
    }
}

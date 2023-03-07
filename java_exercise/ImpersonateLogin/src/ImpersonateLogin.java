import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-05
 * Time:13:52
 */
public class ImpersonateLogin {
    public static void main(String[] args) {
        //编写代码模拟三次密码输入的场景。
        //最多能输入三次密码，密码正确，提示“登录成功”,
        // 密码错误， 可以重新输入，最多输入三次。三次均错，则提示退出程序
        Scanner scan = new Scanner(System.in);
        int num = 0;//记录用户密码输入错误的次数

        while(true){
            if(num == 3){
                System.out.println("您输入密码错误次数已达3次，登录失败....");
                System.out.println("退出程序");
                break;
            }

            String password = scan.nextLine();
            String pwd = "21040540124";
            //比较登录密码
            //equals 相等返回true 否则false
            if( password.equals(pwd) ){
                System.out.println("登录成功");
                break;
            }else{
                num++;
                System.out.println("您的密码错误，请重新输入，您还有" + (3 - num) + "次机会：");
            }
        }
    }
}

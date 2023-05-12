/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

public class Main {
    public static void main(String args[]){
        String name = "张三";
        String birthday = "1989.10.06";
        String website = "http://www.zhangsan.com";
        String height = "185cm";
        String weight = "72kg";

        System.out.printf("简历中的姓名是否姓张："+name.startsWith("张")+"\n");
        System.out.printf("出生日期："+birthday+"\n");
        System.out.printf("个人网站："+website+"\n");
        System.out.printf("身高是否大于180cm：");
        if(Integer.parseInt(height.substring(0,3)) > 180){
            System.out.printf("true"+"\n");
        }
        else{
            System.out.printf("false"+"\n");
        }
        System.out.printf("体重是否小于75kg：");
        if(Integer.parseInt(weight.substring(0,2)) < 75){
            System.out.printf("true"+"\n");
        }
        else{
            System.out.printf("false"+"\n");
        }
    }
}

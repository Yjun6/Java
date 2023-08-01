import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-01
 * Time:14:22
 */
public class Main8 {
    static long sum1 = 0;//偶数和
    static long sum2 = 0;//奇数和
    public static void main(String[] args) throws InterruptedException {
        long time1 = System.currentTimeMillis();
        //创建随机数数组
        Random random = new Random();
        int num = 1000_0000;
        int [] n = new int[num];
        for(int i=0;i<num;i++){
            n[i] = random.nextInt() % 100 + 1;
        }
        //线程
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(int i=0;i<num;i+=2){
                    sum1 += n[i];
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for(int i=1;i<num;i+=2){
                    sum2 += n[i];
                }
            }
        };

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long time2 = System.currentTimeMillis();
        System.out.println("总耗时为："+(time2-time1));
        System.out.println("sum1="+sum1);
        System.out.println("sum2="+sum2);
        System.out.println(sum1+sum2);


    }
}



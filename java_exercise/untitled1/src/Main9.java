import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-01
 * Time:14:43
 */
public class Main9 {
    public static void main(String[] args) throws InterruptedException {
        // 记录开始时间
        long start = System.currentTimeMillis();

        // 1. 给定一个很长的数组 (长度 1000w), 通过随机数的方式生成 1-100 之间的整数.
        int total = 1000_0000;
        int [] arr = new int[total];
        // 构造随机数，填充数组
        Random random = new Random();
        for (int i = 0; i < total; i++) {
            int num = random.nextInt(100) + 1;
            arr[i] = num;
        }


        // 2. 实现代码, 能够创建两个线程, 对这个数组的所有元素求和.
        // 3. 其中线程1 计算偶数下标元素的和, 线程2 计算奇数下标元素的和.
        // 实例化操作类
        SumOperator operator = new SumOperator();
        // 定义具体的执行线程
        Thread t1 = new Thread(() -> {
            // 遍历数组，累加偶数下标
            for (int i = 0; i < total; i += 2) {
                operator.addEvenSum(arr[i]);
            }
        });

        Thread t2 = new Thread(() -> {
            // 遍历数组，累加奇数下标
            for (int i = 1; i < total; i += 2) {
                operator.addOddSum(arr[i]);
            }
        });

        // 启动线程
        t1.start();
        t2.start();
        // 等待线程结束
        t1.join();
        t2.join();

        // 记录结束时间
        long end = System.currentTimeMillis();
        // 结果
        System.out.println("结算结果为 = " + operator.result());
        System.out.println("总耗时 " + (end - start) + "ms.");
    }
}

// 累加操作用这个类来完成
class SumOperator {
    long evenSum;
    long oddSum;

    public void addEvenSum (int num) {
        evenSum += num;
    }

    public void addOddSum (int num) {
        oddSum += num;
    }

    public long result() {
        System.out.println("偶数和：" + evenSum);
        System.out.println("奇数和：" + oddSum);
        return evenSum + oddSum;
    }
}
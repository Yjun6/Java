import java.util.Scanner;

/**
 * Created by arrow on 11/19/17.
 */
class Question {
    public static int jumpTimes(int N, int M) {
        // jump数组表示调到jump[i]所用的最大步数
        int[] jump = new int[M + 1];

        // 初始化jump数组为-1
        for (int i = N; i <= M; ++i) {
            jump[i] = -1;
        }

        int step = 1;
        jump[N] = 0;

        // printState(jump, N);
        while (jump[M] == -1) {
            int max_step = Integer.MIN_VALUE;

            for (int cur = N; cur <= M; ++cur) {
                if (jump[cur] > max_step)
                    max_step = jump[cur];

                if (jump[cur] < step - 1)
                    continue;
                // 找到step-1步所能走到的石板
                else if (jump[cur] == step - 1) {

                    for (int k = 2; k <= Math.sqrt(cur); ++k) {
                        // System.out.println("cur = " + cur + ", k = " + k);
                        // 找到约数k，更新jump数组
                        if (cur % k == 0) {
                            if (cur + k <= M && jump[cur + k] == -1) jump[cur + k] = step;
                            if (cur + cur / k <= M && jump[cur + cur / k] == -1) jump[cur + cur / k] = step;
                        }
                    }
                } else {
                    continue;
                }
            }

            // 当前步数和jump数组中最大的步数相差2，
            // 等价于是找不到step-1步所能走到的石板了，因为越界了，所以循环结束
            if (step - max_step > 1)
                break;

            step++;
            // printState(jump, N);
        }

        // printState(jump, N);
        return jump[M];
    }

    // 打印状态数组
    private static void printState(int[] jump, int N) {
        System.out.println("JUMP");
        for (int i = N; i < jump.length; ++i) {
            System.out.printf("%5d ", i);
        }
        System.out.println();
        for (int i = N; i < jump.length; ++i) {
            System.out.printf("%5d ", jump[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int result = jumpTimes(N, M);
        System.out.println(result);
    }
}

package com;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-17
 * Time:16:30
 */

class Number implements Runnable{
    final int SMA = -1, LAR = 1, SUC = 8;

    int real = 0, guess = 0, min = 0, max = 100, message = SMA;
    boolean pleaseGuess = false;
    boolean isGiveNumber = false;
    Thread giveNumberThread, guessNumberThread;

    @Override
    public void run() {
        for(int count = 1; true ;count++) {
            setMessage(count);
            if( message == SUC)
                return;
        }
    }

    Number() {
        giveNumberThread= new Thread(this);
        guessNumberThread= new Thread(this);

    }

    public synchronized void setMessage(int count) {
        if(Thread.currentThread() == giveNumberThread && isGiveNumber == false) {
            //生成1至100之间的数
            Random random = new Random();
            real = random.nextInt(100) + 1;

            System.out.println("随机给你一个1至100之间的数，猜猜是多少？");
            isGiveNumber = true;
            pleaseGuess = true;
        }
        if(Thread.currentThread() == giveNumberThread) {
            while(pleaseGuess)
                try  {
                    wait();  //让出CPU使用权，让另一个线程开始猜数
                }
                catch(InterruptedException e){

                }

            //结束等待后，根据另一个线程的猜测给出提示
            if(real > guess)  {
                message = SMA;
                System.out.println("你猜小了");
            }
            else if(real < guess) {
                message = LAR;
                System.out.println("你猜大了");
            }
            else {
                message = SUC;
                System.out.println("恭喜，你猜对了");
            }
            pleaseGuess=true;
        }

        if(Thread.currentThread() == guessNumberThread && isGiveNumber == true) {
            while(pleaseGuess == false)
                try {
                    wait();
                }
                catch(InterruptedException e){

                }
            if(message == SMA) {
                min = guess;
                guess = ( min + max ) / 2;
                System.out.println("我第"+count+"次猜这个数是:"+guess);
            }
            else if(message==LAR) {
                max=guess;
                guess=(min+max)/2;
                System.out.println("我第"+count+"次猜这个数是:"+guess);
            }
            pleaseGuess=false;
        }
        notifyAll();
    }

}

public class Main {
    public static void main(String[] args) {
        Number number = new Number();
        number.giveNumberThread.start();
        number.guessNumberThread.start();
    }
}

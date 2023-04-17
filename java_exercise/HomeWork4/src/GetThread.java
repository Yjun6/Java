/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-17
 * Time:16:01
 */
public class GetThread extends Thread {
    Letter letter;
    char cStart = 'a';
    char cEnd = 'z';
    int sleepL = 1000;

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    public void setSleepL (int sleepL) {
        this.sleepL = sleepL;
    }

    @Override
    public void run() {
        char c = cStart;
        while(true){
            letter.setC(c);
            System.out.printf("显示字符为：%c\n",letter.getC());
            try{
                sleep(sleepL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                c = (char)(c+1);
                if(c > cEnd){
                    c = cStart;
                }
            }
        }
    }
}

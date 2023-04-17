import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-04-17
 * Time:16:10
 */
public class InputThread extends Thread{
    Scanner scanner;
    Letter letter;
    int score = 0;

    public InputThread() {
        scanner = new Scanner(System.in);
    }

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    @Override
    public void run() {
        while(true){
            String line = scanner.nextLine();
            char c = line.charAt(0);
            if(c == letter.getC()){
                score++;
                System.out.printf("输入正确，目前分数是：%d\n",score);
            }else{
                System.out.printf("输入错误，目前分数是：%d\n",score);
            }
            if(c == '#'){
                System.exit(0);
            }
        }
    }
}

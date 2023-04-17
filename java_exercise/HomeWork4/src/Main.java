import sun.security.x509.IPAddressName;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("键盘练习，输入‘#’表示结束");
        System.out.println("输入显示的字符后，按回车键");
        Letter letter = new Letter();
        GetThread getThread = new GetThread();
        InputThread inputThread = new InputThread();

        getThread.setLetter(letter);
        getThread.setSleepL(3200);

        inputThread.setLetter(letter);

        getThread.start();
        inputThread.run();
    }
}
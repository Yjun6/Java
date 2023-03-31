/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-03-30
 * Time:18:25
 */

public class LoginException extends Exception{
    LoginException(String m){
        super(m);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}



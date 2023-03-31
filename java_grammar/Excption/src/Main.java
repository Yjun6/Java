/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class Login{
    private String name;
    private String pwd;

    public static void login(String name, String pwd) throws LoginException, LoginPwdException{
        if(!name.equals("zouyujie")){
            throw new LoginException("登录账号异常!");
        }
        if(!pwd.equals("200310")){
            throw new LoginPwdException("登录密码有误！");
        }
        System.out.println("登录成功！");
    }
}
public class Main {
    public static void main(String[] args){
        try{
            Login.login("zouyujie","20031");
        }catch(LoginException ex){
            ex.printStackTrace();
        }catch (LoginPwdException ex){
            ex.printStackTrace();
        }finally {
            System.out.println("over!");
        }
    }
}
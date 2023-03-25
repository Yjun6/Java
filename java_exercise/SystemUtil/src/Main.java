/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

public class Main {

    public static boolean isAdmin(String userId) {
        return userId.toLowerCase() == "admin";
    }
    public static void main(String[] args){
        System.out.println(isAdmin("Admin"));
    }
}
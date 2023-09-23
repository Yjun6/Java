/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-09-23
 * Time:11:43
 */
public class LK_202 {
    public static void main(String[] args) {
        LK_202 r = new LK_202();
        System.out.println(r.isHappy(19));
    }
    public boolean isHappy(int n) {
        int f = ret(n);
        int r = ret(f);
        while(f != r) {
            f = ret(f);
            r = ret(r);
            r = ret(r);
        }
        if(f == 1) {
            return true;
        } else {
            return false;
        }
    }
    private int ret(int n) {
        int tmp = 10;
        int ret = 0;
        while(n > 0) {
            ret += (n % tmp)*(n % tmp);
            n /= 10;
        }
        return ret;
    }
}
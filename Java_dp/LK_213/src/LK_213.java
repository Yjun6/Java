/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-07-13
 * Time:21:07
 */
public class LK_213 {
    public static void main(String[] args) {
        int[] arr = {0};
        LK_213 n = new LK_213();
        System.out.println(n.rob(arr));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int f,g;
        f = nums[0]+func(nums,2,n-2);
        g = func(nums,1,n-1);
        return Math.max(f,g);
    }
    public int func(int[] nums,int n,int m){
        if(n > m) return 0;
        int len = nums.length;
        int[] f = new int[len];
        int[] g = new int[len];
        f[n] = nums[n];
        for(int i=n+1;i<=m;i++){
            f[i] = g[i-1]+nums[i];
            g[i] = Math.max(f[i-1],g[i-1]);
        }
        return  Math.max(f[m],g[m]);
    }
}
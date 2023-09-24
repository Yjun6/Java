import java.util.Scanner;

class Main1 {
    public static void main(String[] args) {
        int n = 10;
        int[] num = {1,2,1,2,1,2,1,2,1,1};
        int  i = 0;
        int r = 1;
        for(i = 1; i < n; i++) {
            if(num[i-1]<num[i]) {
                while(i<n && num[i-1]<=num[i]) {
                    i++;
                }
                r++;
            } else if(num[i-1]>num[i]){
                while(i<n && num[i-1]>=num[i]) {
                    i++;
                }
                r++;
            }
        }
        System.out.println(r);
    }
}
class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        int cnt = 1;
        for(int i=1;i<n-1;i++){
            if(a[i]>a[i-1]&&a[i]>a[i+1]||a[i]<a[i-1]&&a[i]<a[i+1]){
                cnt++;
                if(n-3!=i){
                    i++;
                }
            }
        }
        System.out.println(cnt);

        int[] list = {1,2,3,54,2,2,4,6,7,54,4,84,23423};
        int len = list.length;
        int[] tmp = new int[len];
    }
}


class A {
    public static void a() {
        System.out.println("hello");
    }
    public static void main(String[] args) {
        A a = null;
        a.a();
    }
}









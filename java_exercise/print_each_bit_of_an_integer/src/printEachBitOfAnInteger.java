import java.util.Scanner;

public class printEachBitOfAnInteger {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int UserInput = scan.nextInt();

        if (UserInput == 0) {
            System.out.println(UserInput);
        }else{
            //排除掉0
            while((UserInput % 10) == 0){
                UserInput /= 10;
            }

            while(UserInput != 0) {
                System.out.print(UserInput % 10);
                UserInput /= 10;
            }
        }


    }
}
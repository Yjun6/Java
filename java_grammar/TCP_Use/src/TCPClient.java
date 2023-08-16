import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-16
 * Time:13:34
 */

//客户端
public class TCPClient {
    private Socket socket = null;
    TCPClient(String ip, int port) throws IOException {
        socket = new Socket(ip,port);
    }
    public void start(){
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()){
            while(true){
                //1.获取控制台输入的信息
                System.out.print("->");
                String request = scanner.next();
                //2.构造请求对象，发给服务器
                PrintWriter writer = new PrintWriter(outputStream);
                writer.println(request);
                writer.flush();
                //3.从服务器获取响应
                Scanner scanner1 = new Scanner(inputStream);
                String response = scanner1.next();
                //4.打印到控制台
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TCPClient client = new TCPClient("127.0.0.1",2023);
        client.start();
    }
}

package UDP_server_client;

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
 * Date:2023-08-17
 * Time:19:59
 */

//客户端
public class Client {
    private Socket socket = null;
    //传入的参数是服务器的ip和端口号
    Client(String ip, int port) throws IOException {
        //在这里已经建立好了连接
        socket = new Socket(ip,port);
    }
    public void start() throws IOException {
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()){
           while(true){
               //1.输入
               System.out.print("->");
               String request = scanner.next();
               //2.发送
               PrintWriter writer = new PrintWriter(outputStream);
               writer.println(request);
               writer.flush();
               //3.接收
               Scanner scanner1 = new Scanner(inputStream);
               String response = scanner1.next();
               //4.显示
               System.out.println(response);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("127.0.0.1",4399);
        client.start();
    }
}


















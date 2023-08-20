package TCP_server_client;

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
 * Date:2023-08-20
 * Time:21:44
 */
public class Client2 {
    private Socket socket = null;
    Client2(String ip,int port) throws IOException {
        socket = new Socket(ip,port);
    }
    public void start() throws IOException {
        System.out.println("客户端2号启动");
        Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()){
            while(true){
                System.out.print("->");
                String request = scanner.next();
                PrintWriter writer = new PrintWriter(outputStream);
                writer.println(request);
                writer.flush();
                Scanner scanner1 = new Scanner(inputStream);
                String response = scanner1.next();
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Client2 client2 = new Client2("127.0.0.1",4399);
        client2.start();
    }

}

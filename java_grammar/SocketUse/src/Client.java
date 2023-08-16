import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-14
 * Time:21:58
 */

//客户端
public class Client {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;
    public Client(String ip,int port) throws SocketException {
        serverIp = ip;
        serverPort = port;
        socket = new DatagramSocket();
    }

    public void start() throws IOException {
        System.out.println("客户端启动！");
        Scanner scanner = new Scanner(System.in);
        while(true){
            //1.读取用户输入
            System.out.print("->");
            String request = scanner.next();
            //2.构造请求 发给服务器
            DatagramPacket packet = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(serverIp),serverPort);
            socket.send(packet);
            //3.接收响应，分析响应
            DatagramPacket packet1 = new DatagramPacket(new byte[2048],2048);
            socket.receive(packet1);
            String response = new String(packet1.getData(),0,packet1.getLength());
            //4.做出回应
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("127.0.0.1",2000);
        client.start();
    }
}

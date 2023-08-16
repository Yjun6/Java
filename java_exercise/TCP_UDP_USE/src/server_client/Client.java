package server_client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-15
 * Time:12:02
 */

//回显服务器
//客户端
public class Client {
    DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;
    Client(String ip,int port) throws SocketException {
        serverIp = ip;
        serverPort = port;
        socket = new DatagramSocket();
    }
    //实现交互功能
    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("客户端启动！");
        while(true){
            //1.等待用户输入
            System.out.print("->");
            String request = scanner.next();
            //2.构造请求，把请求发给服务器
            DatagramPacket packet = new DatagramPacket(request.getBytes(),0,request.getBytes().length,
                    InetAddress.getByName(serverIp),serverPort);
            socket.send(packet);
            //3.读取服务器响应，解析内容
            DatagramPacket packet1 = new DatagramPacket(new byte[2048], 2048);
            socket.receive(packet1);
            String response = new String(packet1.getData(),0,packet1.getLength());
            //4.显示到屏幕上
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("127.0.0.1",2023);
        client.start();
    }
}

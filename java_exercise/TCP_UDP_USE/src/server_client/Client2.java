package server_client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-16
 * Time:12:57
 */

//客户端
public class Client2 {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;
    Client2(String serverIp,int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            //1.控制台获取请求
            System.out.print("->");
            String request = scanner.next();
            //2.构造请求对象，发送给服务器
            DatagramPacket packet1 = new DatagramPacket(request.getBytes(),0,request.getBytes().length,
                    InetAddress.getByName(serverIp),serverPort);
            socket.send(packet1);
            //3.接收响应，并解析
            DatagramPacket packet2 = new DatagramPacket(new byte[2048],2048);
            socket.receive(packet2);
            String response = new String(packet2.getData(),0,packet2.getLength());
            //4.打印到控制台
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        Client2 client2 = new Client2("127.0.0.1",2023);
        client2.start();
    }
}

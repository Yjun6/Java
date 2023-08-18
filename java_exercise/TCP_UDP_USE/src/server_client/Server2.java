package server_client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-16
 * Time:12:57
 */

//服务器
public class Server2 {
    private DatagramSocket socket = null;
    public Server2(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
       while(true){
           //1.接收请求并解析
           DatagramPacket packet1 = new DatagramPacket(new byte[2048],2048);
           socket.receive(packet1);
           String request = new String(packet1.getData(),0,packet1.getLength());
           //2.根据请求给出响应
           String response = process(request);
           //3.发送响应给客户端
           DatagramPacket packet2 = new DatagramPacket(response.getBytes(),0,response.getBytes().length,
                   packet1.getSocketAddress());
           socket.send(packet2);
           //记录日志
           System.out.println("request: "+request+" response: "+response);
       }
    }

    public String process(String s){
        return s;
    }

    public static void main(String[] args) throws IOException {
        Server2 server2 = new Server2(2023);
        server2.start();
    }
}








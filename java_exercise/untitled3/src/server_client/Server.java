package server_client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-15
 * Time:12:09
 */

//服务器
public class Server {
    DatagramSocket socket = null;
    //port是端口号
    Server(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    //实现交互功能
    public void start() throws IOException {
        System.out.println("服务器启动！");
        while(true){
            //1.接收请求，并且解析
            DatagramPacket packet = new DatagramPacket(new byte[2048],2048);
            socket.receive(packet);
            String request = new String(packet.getData(),0,packet.getLength());
            //2.根据请求计算出回应
            String response = process(request);
            //3.讲响应返回客户端
            DatagramPacket packet1 = new DatagramPacket(response.getBytes(),response.getBytes().length,
                    packet.getSocketAddress());
            socket.send(packet1);
            //记录日志
            System.out.printf("[%s:%d] req:%s, resp:%s\n",packet.getAddress().toString(),
                    packet.getPort(),request,response);
        }
    }
    private String process(String s){
        return s;
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(2023);
        server.start();
    }
}
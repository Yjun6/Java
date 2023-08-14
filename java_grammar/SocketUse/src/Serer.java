import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-14
 * Time:19:28
 */

//服务器
public class Serer {
    private DatagramSocket socket = null;
    //传入的是服务器要绑定的端口
    public Serer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    //使用方法启动服务器
    public void start() throws IOException {
        System.out.println("服务器启动!");
        while(true){
            //1.接收请求，并解析
            DatagramPacket packet = new DatagramPacket(new byte[2048],2048);
            socket.receive(packet);
            String request = new String(packet.getData(),0,packet.getLength());
            //2.根据请求，计算出响应
            String response = process(request);
            //3.把响应返回客户端
            DatagramPacket packet1 = new DatagramPacket(response.getBytes(),response.getBytes().length,
                    packet.getSocketAddress());
            socket.send(packet1);
            //记录日志
            System.out.printf("[%s:%d] req: %s, resp: %s\\n",packet.getAddress().toString(),
                    packet.getPort(),request,response);
        }
    }

    public String process(String s){
        return s;
    }

    public static void main(String[] args) throws IOException {
        Serer serer = new Serer(2000);
        serer.start();
    }
}

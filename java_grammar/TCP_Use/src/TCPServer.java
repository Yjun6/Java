import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-16
 * Time:13:34
 */

//服务器
public class TCPServer {
    private ServerSocket serverSocket = null;
    public TCPServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动！");
        while(true){
            //1.建立连接
            Socket socket = serverSocket.accept();
            //2.处理连接
            processConnection(socket);
        }
    }
    private void processConnection(Socket socket) throws IOException {
        //记录日志
        System.out.printf("[ip:%s\tport:%d] 客户端上线\n",
                socket.getInetAddress().toString(),socket.getPort());
        //读取请求，计算响应，返回响应 三步走
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()){
            while(true) {
                //1.获取请求
                Scanner scanner = new Scanner(inputStream);
                if(!scanner.hasNext()){
                    System.out.printf("[ip:%s\tport:%d] 客户端下线\n",
                            socket.getInetAddress().toString(),socket.getPort());
                    break;
                }
                String request = scanner.next();
                //2.计算响应
                String response = process(request);
                //3.返回
                PrintWriter writer = new PrintWriter(outputStream);
                writer.println(response);
                writer.flush();
                //记录日志
                System.out.printf("[ip:%s\tport:%d] req:%s,resp:%s\n",
                        socket.getInetAddress().toString(),socket.getPort(),
                        request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
    public String process(String s) {
        return s;
    }

    public static void main(String[] args) throws IOException {
        TCPServer server = new TCPServer(2023);
        server.start();
    }
}









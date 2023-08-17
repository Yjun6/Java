package UDP_server_client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-17
 * Time:20:00
 */

//服务器
public class Server {
    private ServerSocket serverSocket = null;
    Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    //线程池
    ExecutorService service = Executors.newCachedThreadPool();
    public void start() throws IOException {
        System.out.println("服务器启动");
        while(true){
            //1.建立连接
            Socket socket = serverSocket.accept();
           service.submit(new Runnable() {
               @Override
               public void run() {
                   //2.解析连接
                   try {
                       processConnaction(socket);
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           });
        }
    }
    public void processConnaction(Socket socket) throws IOException {
        //1.获取请求
        try (InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()){
            System.out.printf("[%s:%d] 客户端上线\n",socket.getInetAddress().toString(),socket.getPort());
            while (true){
                Scanner scanner = new Scanner(inputStream);
                if(!scanner.hasNext()){
                    System.out.printf("[%s:%d] 客户端下线\n",socket.getInetAddress().toString(),socket.getPort());
                    break;
                }
                String request = scanner.next();
                //2.计算响应
                String response = process(request);
                //3.返回响应
                PrintWriter writer = new PrintWriter(outputStream);
                writer.println(response);
                writer.flush();
                //记录日志
                System.out.printf("[%s:%d] req:%s,rep:%s\n",socket.getInetAddress().toString(),socket.getPort(),
                        request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }

    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(4399);
        server.start();
    }
}











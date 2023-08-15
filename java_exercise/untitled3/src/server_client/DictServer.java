package server_client;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-15
 * Time:23:01
 */

//词典 服务器
public class DictServer extends Server{

    Map<String,String> map = new HashMap<>();
    DictServer(int port) throws SocketException {
        super(port);
        map.put("cat","小猫");
        map.put("dog","小狗");
        map.put("TCP","网络协议之一");
    }

    @Override
    public String process(String request){
        return map.getOrDefault(request,"不存在该单词题意");
    }

    public static void main(String[] args) throws IOException {
        DictServer dictServer = new DictServer(2023);
        dictServer.start();
    }
}

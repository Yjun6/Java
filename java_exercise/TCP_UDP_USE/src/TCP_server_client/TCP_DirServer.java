package TCP_server_client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:Yu
 * Date:2023-08-18
 * Time:11:13
 */
public class TCP_DirServer extends Server{

    private Map<String,String> map = null;
    TCP_DirServer(int port) throws IOException {
        super(port);
        map = new HashMap<>();
        map.put("cat","小猫");
        map.put("improvement","改善");
    }

    @Override
    public String process(String request) {
        return map.getOrDefault(request,"无词意");
    }

    public static void main(String[] args) throws IOException {
        TCP_DirServer server = new TCP_DirServer(4399);
        server.start();
    }
}

package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tester {

    public static void test(){
        final Integer[] connections = {0};
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(() -> {

            Map<Integer , Connection> connectionMap = new HashMap<>();
            Socket client ;

            try {
                ServerSocket serverSocket = new ServerSocket(2000 , 0 , Server.ADDRESS);

                while(true){
                    client = serverSocket.accept();
                    connectionMap.put(connections[0], new Connection(client , connections[0]));
                    connections[0]++;
                }

            } catch (Exception e) {
                System.err.println("Exception " + e);
            }
        });

        service.submit(()->{

            Socket socket;
            try {
                while (true) {
                    socket = new Socket(Server.ADDRESS, 2000);
                }
            }catch (Exception e){
                Server.maxconections = connections[0]-1000;
                System.out.println("Connections accepted : " + connections[0] + '\n' + "Max connections set :" + (connections[0]-1000));
            }
        });
    }
}

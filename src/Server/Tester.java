package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tester {
    public static void test(){
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(2000 , 0 , Server.ADDRESS);
                } catch (IOException e) {
                    System.err.println("Error Address");
                }
            }
        });
    }
}

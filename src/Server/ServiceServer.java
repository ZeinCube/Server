package Server;

import Console.ConsoledThread;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceServer extends ConsoledThread {

    ExecutorService executor = Executors.newFixedThreadPool(Server.maxconections);
    ServerSocket serverSocket;
    int connections;
    Map<Integer,Connection> connectionList = new HashMap<>();
    private Connection con;

    public ServiceServer(int port) {
        console.setName("ServiceServer #" + );
        try {
            serverSocket = new ServerSocket(port , 0 , Server.ADDRESS);
            console.log("New ServiceServer started" , "m");
        } catch (IOException e) {
            console.log("Exception in setting serversocket {" + e + '}', "exc");
            interrupt();
        }
        start();
    }

    public void handleConnection(Socket client){
        con = new Connection(client,connections);
        executor.submit(con);
        connectionList.put(connections, con);
        connections++;
    }

    @Override
    public void run() {
        while (!interrupted()){
            try {
                handleConnection(serverSocket.accept());
            } catch (Exception e) {
                console.log("Exception in handling new connection {" + e +'}',"exc");
            }
        }
    }
}

package Server;

import Logic.Intellect;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server extends Thread {

    static InetAddress ADDRESS;
    static ServerSocket serverSocket;
    static Socket clientsocket;
    static ServerConsole console = new ServerConsole();
    static private final String VERSION = "1.0.0";
    static Integer maxconections;
    static private Intellect intellect = new Intellect();
    static Map<Integer , Connection> connectionMap = new HashMap<>();
    static List<ServiceServer> servers = new ArrayList<>();

    public static void initiate(){
        intellect.start();
    }

    @Override
    public void run() {
        try {

            serverSocket = new ServerSocket(2905,0, ADDRESS);
            console.log("Server started on " + ADDRESS + "\nVersion is : " + VERSION, "m");
            initiate();
            while (!interrupted()){

            }

        } catch (IOException e) {
            console.log(""+e, "exc");
            interrupt();
            try {
                serverSocket.close();
                clientsocket.close();
            } catch (IOException ignored) {}
        }
    }
}

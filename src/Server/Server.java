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
    static long connections;


    //initiates variables
    public static void initiate(){
        intellect.start();
        connections = 0;
        Tester.test();
    }
    //using while closing or interrupting server
    public static void STOP() throws IOException {
        serverSocket.close();
        clientsocket.close();
    }

    public static void warmUp(){

    }

    @Override
    public void run() {
        try {

            serverSocket = new ServerSocket(2905,0, ADDRESS);
            console.log("Server started on " + ADDRESS + "\nVersion is : " + VERSION +'\n', "m");
            initiate();

            while (!interrupted()){

            }

        } catch (IOException e) {
            console.log(""+e, "exc");
            try {
                STOP();
            } catch (IOException ignored) {}
            interrupt();
        }
    }
}

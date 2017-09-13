package Server;

import Logic.Intellect;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread {

    static InetAddress ADDRESS;
    static ServerSocket serverSocket;
    static Socket clientsocket;
    static ServerConsole console = new ServerConsole();
    static private final String VERSION = "1.0.0";
    static Integer maxconections;
    static private Intellect intellect = new Intellect();
    public static List<ServiceServer> servers = new ArrayList<>();
    static long connections;
    static int nextPort = 3000;


    //initiates variables
    public static void initiate(){
        intellect.initiate();
        connections = 0;
    }

    //using in case of closing or interrupting server
    public static void STOP() throws IOException {
        serverSocket.close();
        clientsocket.close();
    }

    public static void warmUp(){
        servers.add(new ServiceServer(nextPort));
        nextPort++;
    }

    public static void oneMoreServer(int port, int maxconections){

    }

    public static void handleInputConnection(Socket Input){
        intellect.handle(Input);
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(2905,0, ADDRESS);
            console.log("Server started on " + ADDRESS + "\nVersion is : " + VERSION +'\n', "m");
            initiate();

            while (!interrupted()){
                handleInputConnection(serverSocket.accept());
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

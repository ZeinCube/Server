package Server;

import Console.Console;
import Console.ConsoledThread;

import java.net.Socket;

public class Connection implements Runnable {
    public int number;
    public Socket client;
    public Console console;

    public Connection(Socket client , int number){
        this.client = client;
        this.number = number;
    }

    @Override
    public void run() {
        console.setName("Connection #" + number);
    }
}

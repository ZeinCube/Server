package Server;

import Console.Console;

import java.net.Socket;

public class Connection implements Runnable {

    public int id;
    public Socket client;
    public Console console = new Console();
    public boolean interrupted;

    public Connection(Socket client , int number){
        this.client = client;
        this.id = number;
    }

    public void interrupt(){
        interrupted = true;
    }

    public void CLOSE(){
       interrupt();
    }

    @Override
    public void run() {
        console.setName("Connection #" + id);
        while(!interrupted){

        }
    }
}

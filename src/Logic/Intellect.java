package Logic;

import Console.Consoled;
import Server.Server;
import Server.ServiceServer;
import java.net.Socket;
import java.util.List;

public class Intellect implements Consoled {
    private static String name ;
    private static List<ServiceServer> servers = null ;

    public void initiate() {
        setConsoleName("Intellect");

    }

    public void handle(Socket socket){
        servers = Server.servers ;

    }

    @Override
    public void setConsoleName(String Name) {
        name = Name;
    }
}

package Server;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

import static Server.Server.console;

public class Starter {

    static Server server = new Server();

    static void setAddress() {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for(NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for(InetAddress ipAddress : addrs){
                    if(!ipAddress.isLoopbackAddress() & !ipAddress.isLinkLocalAddress()){
                        Server.ADDRESS = ipAddress;
                        break;
                    }
                }
            }
        }catch (Exception e) {
            console.log(""+e, "exc");
        }
    }

    static  void setAddress(String address) {
        try {
            Server.ADDRESS = InetAddress.getByName(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        setAddress();
        Tester.test();
    }
}

package Console;

public class ConsoledThread extends Thread implements Consoled {

    @Override
    public void setConsoleName(String whois) {
        console.setName(whois);
    }
}

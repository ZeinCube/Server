package Console;

import java.util.ArrayList;
import java.util.List;

public class LogCase {
    private static boolean isShowingLogs = true;
    private static List<Log> logs = new ArrayList<>();

    static void offLogs(){
        isShowingLogs = false;
    }

    static void onLogs(){
        isShowingLogs = true;
    }

    public static void putLog(Log log){
        if(!isShowingLogs) logs.add(log);
        else {
            logs.add(log);
            System.out.print(log.toString());
        }
    }

    public static void showLogs (){
        logs.forEach(System.out::println);
    }
}

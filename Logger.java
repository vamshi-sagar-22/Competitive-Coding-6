import java.util.*;

/*
Logger Rate Limiter
approach: use a map to store messages, if msg exists compare time diff >=10
 */
public class Logger {
    Map<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    //time: O(1)
    //space: O(no. of messagesx avg.length)
    private boolean shouldPrintMessage(int time, String message) {
        if (map.containsKey(message)) {
            int diff = Math.abs(time-map.get(message));
            if (diff>=10) {
                map.put(message, time);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            map.put(message, time);
        }
        return true;
    }


    public static void main(String args[]) {
        Logger logger = new Logger();
        System.out.println("response "+logger.shouldPrintMessage(1, "foo"));
        System.out.println("response "+logger.shouldPrintMessage(2, "bar"));
        System.out.println("response "+logger.shouldPrintMessage(3, "foo"));
        System.out.println("response "+logger.shouldPrintMessage(8, "bar"));
        System.out.println("response "+logger.shouldPrintMessage(10, "foo"));
        System.out.println("response "+logger.shouldPrintMessage(11, "foo"));
    }
}

package common;

import java.util.HashMap;
import java.util.Map;

public class Message {
    public static Map<String, String> messages = new HashMap<>();

    public static void addMessage(String rule, String desc) {
        messages.put(rule, desc);
    }
}

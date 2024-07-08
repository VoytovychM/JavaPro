package algorithms20240625;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
    public static String[] restoreIP(String s) {
        List<String> result = recursIP(s, 4);
        return result.toArray(new String[0]);
    }

    private static List<String> recursIP(String tail, int parts) {
        List<String> result = new ArrayList<>();

        if (parts == 0) {
            if (tail.isEmpty()) {
                result.add("");
            }
            return result;
        }

        if (tail.isEmpty()) {
            return result;
        }

        for (int i = 1; i < 4 && i <= tail.length(); i++) {
            String part = tail.substring(0, i);
            if (isValid(part)) {
                List<String> subResult = recursIP(tail.substring(i), parts - 1);
                for (String s : subResult) {
                    if (s.isEmpty()) {
                        result.add(part);
                    } else {
                        result.add(part + "." + s);
                    }
                }
            }
        }

        return result;
    }

    private static boolean isValid(String ipVal) {
        if (ipVal.length() > 1 && ipVal.startsWith("0")) {
            return false;
        }
        int value;
        try {
            value = Integer.parseInt(ipVal);
        } catch (NumberFormatException e) {
            return false;
        }
        return value >= 0 && value <= 255;
    }

    public static void main(String[] args) {
        String input = "25525511135";
        String[] restoredIPs = restoreIP(input);
        for (String ip : restoredIPs) {
            System.out.println(ip); // Output: ["255.255.11.135", "255.255.111.35"]
        }
    }
}

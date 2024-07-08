package algorithms20240625;
  // Восстановить все возможные IP адреса по строке цифр, если это возможно
  // IP адрес - это строка, содержащая 4 числа 0 <= N <= 255, разделённых точками

import java.util.ArrayList;
import java.util.List;

public class RecoverIps {
public List<String> recoverIPAddress (String string ){
List<String> result = new ArrayList<>();
if(string == null || string.length()<4 || string.length()>12){
    return result;
}
backtrack(result, new ArrayList<>(), string,0);
return result;

}

    private void backtrack(List<String> result, List<String> tempList, String string, int start) {
    if(tempList.size() == 4){
        if(start ==string.length()){
            result.add(String.join (".", tempList));

        }
        return;
    }
        for (int i = 1; i <= 3; i++) {
            if(start + i>string.length()){
                break;
            }
            String segment = string.substring(start, start + i);
            if(isValid(segment)){
                tempList.add (segment);
                backtrack(result, tempList, string, start+i);
                tempList.remove(tempList.size() -1);
            }

        }
    }

    private boolean isValid(String segment) {
    if(segment.length() >1 && segment.startsWith("0")){
        return false;
    }
    int value = Integer.parseInt(segment);
    return value >= 0 && value <=255;
    }

    public static void main(String[] args) {
        RecoverIps recoverIps = new RecoverIps();
        String input = "25525511135";
        List<String> restoredIPs = recoverIps.recoverIPAddress(input);
        System.out.println(restoredIPs);
    }
}

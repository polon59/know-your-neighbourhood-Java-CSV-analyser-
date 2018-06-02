import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Display {

    private int findLongestString(ArrayList<String> list){
        int longest = list.get(0).length();
        int currentElementLength;

        for (String element : list){
            currentElementLength = element.length();
            if (currentElementLength > longest){
                longest = currentElementLength;
            }
        }
        return longest;
    }

    private int calculateLengthDifference(int maxLength, String stringToWrite) {
        int difference = maxLength - stringToWrite.length();
        return difference;
    }

    
    
}
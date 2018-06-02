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

    private StringBuilder createTableRow(int maxLength, String stringToWrite){
        StringBuilder row = new StringBuilder();
        int lengthDifference = calculateLengthDifference(maxLength, stringToWrite);
        row.append("|");
        row.append(stringToWrite);

        for (int i = 0; i < lengthDifference; i ++){
            row.append(" ");
        }


        row.append("|\n");
        return row;
    }

    public void printListInTable(ArrayList<String> list, String header){
        StringBuilder table = new StringBuilder();
        int maxLength = findLongestString(list);
        //System.out.println(maxLength);

        for (String stringToWrite : list){
            table.append(createTableRow(maxLength, stringToWrite)) ;
        }
        System.out.println(table.toString());



    }
    
}
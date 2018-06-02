import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Display {

    private int[] findLongestString(ArrayList<String> list){
        int maxLenColumn1 = 0;
        int maxLenColumn2 = 0;
        int[] columnLengths = new int[2];

        int currentWordLength;
        String[] lineElements;

        for (String element : list){
            lineElements = element.split("---");
            if (lineElements[0].length() > maxLenColumn1){
                maxLenColumn1 = lineElements[0].length();
            }
            if (lineElements[1].length() > maxLenColumn2){
                maxLenColumn2 = lineElements[1].length();
            }
        }
        columnLengths[0] = maxLenColumn1;
        columnLengths[1] = maxLenColumn2;
        return columnLengths;
    }

    private int calculateLengthDifference(int maxLength, String stringToWrite) {
        int difference = maxLength - stringToWrite.length();
        //System.out.println(difference);
        return difference;
    }

    private StringBuilder createTableRow(int maxLength, String stringToWrite){
        StringBuilder row = new StringBuilder();
        int lengthDifference = calculateLengthDifference(maxLength, stringToWrite);
        row.append("|");
        row.append(stringToWrite);
        //System.out.println(stringToWrite.length());

        for (int i = 0; i < lengthDifference; i ++){
            row.append(" ");
        }


        //row.append("|\n");
        return row;
    }

    public void printListInTable(ArrayList<String> list, String header){
        StringBuilder table = new StringBuilder();
        int[] maxLengths = findLongestString(list);
        
        String[] rowElements;
        //System.out.println(maxLength);

        for (String stringToWrite : list){
            rowElements = stringToWrite.split("---");
            table.append(createTableRow(maxLengths[0], rowElements[0])) ;
            table.append(createTableRow(maxLengths[1], rowElements[1]));
            table.append("|\n");
        }
        System.out.println(table.toString());



    }
    
}
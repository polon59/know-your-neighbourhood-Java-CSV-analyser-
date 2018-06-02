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
        String[] lineElements;

        for (String element : list){
            lineElements = element.split("---");
            if (lineElements[0].length() > maxLenColumn1){
                maxLenColumn1 = lineElements[0].length();
            }
            if (lineElements.length > 1){
                if (lineElements[1].length() > maxLenColumn2){
                    maxLenColumn2 = lineElements[1].length();
                }
            }
        }
        columnLengths[0] = maxLenColumn1;
        columnLengths[1] = maxLenColumn2;
        return columnLengths;
    }

    private int calculateLengthDifference(int maxLength, String stringToWrite) {
        int difference = maxLength - stringToWrite.length() ;
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
        return row;
    }

    private String createTableLine(int[] maxLengths){
        StringBuilder line = new StringBuilder();
        int tableLength = maxLengths[0] + maxLengths[1];
        line.append("|");

        for (int i = 0; i < tableLength; i++){
            line.append("_");
        }

        line.append("|\n");
        return line.toString();

    }

    public void printListInTable(ArrayList<String> list, String header){
        list.add(0, header);
        StringBuilder table = new StringBuilder();
        String[] rowElements;
        int[] maxLengths = findLongestString(list);
        String separatingLine = createTableLine(maxLengths);
        
        
        for (String stringToWrite : list){
            rowElements = stringToWrite.split("---");
            table.append(createTableRow(maxLengths[0], rowElements[0]));
            if (rowElements.length > 1){
                table.append(createTableRow(maxLengths[1], rowElements[1]));
            }
            
            

            table.append("|\n");
            table.append(separatingLine);
        }
        System.out.println(table.toString());



    }
    
}
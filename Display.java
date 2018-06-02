import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
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


    private int calculateNumberOfSeparators(int[] maxLengths){
        int numberOfSeparators = 0;

        for (int i = 0; i < maxLengths.length; i++){
            if (maxLengths[i] > 0){
                numberOfSeparators++;
            }
        }
        System.out.println(numberOfSeparators);
        return numberOfSeparators;
    }


    private String createTableLine(int[] maxLengths){
        int numberOfSeparators = calculateNumberOfSeparators(maxLengths);
        int tableLength = maxLengths[0] + maxLengths[1]+1;
        StringBuilder line = new StringBuilder();
        int numberOfSpaces = 2;
        line.append("|");

        for (int i = 0; i < tableLength + numberOfSeparators - numberOfSpaces; i++){
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


    private ArrayList<String> convertMapToList(HashMap<String,Integer> map){
        ArrayList<String> mapConvertedToList = new ArrayList<String>();
        Set<String> setOfKeys = map.keySet();

        for (String key : setOfKeys){
            StringBuilder joinedElement = new StringBuilder();
            joinedElement.append(key);
            joinedElement.append("---");
            joinedElement.append(map.get(key));
            mapConvertedToList.add(joinedElement.toString());
        }
        return mapConvertedToList;
    }


    public void printHashMapInTable(HashMap<String,Integer> hashMap, String header){
        ArrayList<String> listToPrint = convertMapToList(hashMap);
        printListInTable(listToPrint, header);
    }
    
}
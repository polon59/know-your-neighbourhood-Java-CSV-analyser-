import java.util.List;
import java.util.Scanner;
import java.io.File;

public class FileReader {

    public ArrayList<String[]> readLocationsFromFile(){

        List<String[]> fileLines = new ArrayList<String[]>();
        File data = new File("data.csv");

        try{
            Scanner scanner = new Scanner(data);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] locationInfo = line.split("\t");
                fileLines.add(locationInfo);
            }
            scanner.close();
        } 
        catch (Exception e){
            e.printStackTrace();
        }
        return fileLines;
    }

}
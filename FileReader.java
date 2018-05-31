import java.util.Scanner;
import java.io.File;

public class FileReader {

    private LocationCreator locationCreator;

    public FileReader(){
        this.locationCreator = new LocationCreator();
    }

    public void readDataFile(){
        File data = new File("data.csv");
        StringBuilder text = new StringBuilder();

        try{
            Scanner scanner = new Scanner(data);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] locationInfo = line.split("\t");
                locationCreator.evaluateLocationType(locationInfo);
                //System.out.println("dupa");

                // for (String element : lineElements){
                //     System.out.println(element);
                // }
                // System.out.println("==================");
            }
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
import java.util.Scanner;
import java.io.File;

public class FileReader {

    private String fileText;

    public void readDataFile(){
        File data = new File("data.csv");
        StringBuilder text = new StringBuilder();

        try{
            Scanner scanner = new Scanner(data);
            while (scanner.hasNextLine()){
                text.append(scanner.nextLine());
                text.append("\n");    
            }
        } catch (Exception e){
            e.printStackTrace();
            }

        this.fileText = text.toString();    
        System.out.println(this.fileText);
    }
}
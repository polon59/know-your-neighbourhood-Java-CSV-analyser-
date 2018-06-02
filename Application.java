import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private LocationCreator locationCreator;
    private ArrayList<Location> locations;
    private StatisticalAnalysis statisticalAnalysis;
    private Searcher searchManager;
    private Display displayManager;


    public Application(){
        locationCreator = new LocationCreator();
        locations = locationCreator.getLocationsList();
        statisticalAnalysis = new StatisticalAnalysis(locations);
        searchManager = new Searcher(locations);
        displayManager = new Display();
    }


    public void launchApplication(){
        displayManager.displayMenuOptions();
        int currentOption = getOptionValuefromInput();
        
        while(currentOption != 0){
            switch(currentOption){
                case(1):
                    statisticalAnalysis.countLocationsByCategory();
                    break;
                case(2):
                    statisticalAnalysis.findLongestLocationsNames();
                    break;
                case(3):
                    statisticalAnalysis.findBiggestCounty();
                    break;
                case(4):
                    





            }
        }

            
            statisticalAnalysis.getLocationsWithMultipleCategories();
            searchManager.handleAdvancedSearch();

    }

    private int getOptionValuefromInput(){
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt(); input.nextLine();
        input.close();

        return choice;
    }
    
}
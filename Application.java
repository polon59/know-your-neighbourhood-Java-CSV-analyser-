import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class Application {

    private LocationCreator locationCreator;
    private List<Location> locations;
    private StatisticalAnalysis statisticalAnalysis;
    private Searcher searchManager;
    private Display displayManager;
    private Scanner input;


    public Application(){
        locationCreator = new LocationCreator();
        locations = locationCreator.getLocationsList();
        statisticalAnalysis = new StatisticalAnalysis(locations);
        searchManager = new Searcher(locations);
        displayManager = new Display();
        input = new Scanner(System.in);
    }


    public void launchApplication(){
        int currentOption = 10;
        displayManager.clearScreen();
        
        while(currentOption != 0){

            displayManager.displayMenuOptions();
            currentOption = input.nextInt(); input.nextLine();

            

            switch(currentOption){
                case 1:
                    statisticalAnalysis.countLocationsByCategory();
                    break;
                case 2:
                    statisticalAnalysis.findLongestLocationsNames();
                    break;
                case 3:
                    statisticalAnalysis.findBiggestCounty();
                    break;
                case 4:
                    statisticalAnalysis.getLocationsWithMultipleCategories();
                    break;
                case 5:
                    searchManager.handleAdvancedSearch();
                    break;
                case 6:
                    currentOption = 0;
                    break;
            }
            
        }
    }
}
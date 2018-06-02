import java.util.ArrayList;

public class Application {

    private LocationCreator locationCreator;
    private ArrayList<Location> locations;
    private StatisticalAnalysis statisticalAnalysis;
    private Searcher searchManager;


    public Application(){
        locationCreator = new LocationCreator();
        locations = locationCreator.getLocationsList();
        statisticalAnalysis = new StatisticalAnalysis(locations);
        searchManager = new Searcher(locations);
    }


    public void launchApplication(){
        // for (Location location : locations){
        //     System.out.println(location.toString());
        // }
            statisticalAnalysis.countLocationsByCategory();
            System.out.println("=========");
            statisticalAnalysis.findLongestLocationsNames();
            // statisticalAnalysis.findBiggestCountyName();
            statisticalAnalysis.getLocationsWithMultipleCategories();
            searchManager.handleAdvancedSearch();

    }
    
}
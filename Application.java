import java.util.ArrayList;

public class Application {

    private LocationCreator locationCreator;
    private ArrayList<Location> locations;
    private StatisticalAnalysis statisticalAnalysis;


    public Application(){
        locationCreator = new LocationCreator();
        locations = locationCreator.getLocationsList();
        statisticalAnalysis = new StatisticalAnalysis(locations);
    }


    public void launchApplication(){
        // for (Location location : locations){
        //     System.out.println(location.toString());
        // }
            statisticalAnalysis.countLocationsByCategory();
            statisticalAnalysis.findLongestLocationsNames();

    }
    
}
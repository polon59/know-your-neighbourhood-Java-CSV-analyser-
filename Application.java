import java.util.ArrayList;

public class Application {

    private LocationCreator locationCreator;
    private ArrayList<Location> locations;


    public Application(){
        locationCreator = new LocationCreator();
        locations = locationCreator.getLocationsList();
    }


    public void launchApplication(){
        for (Location location : locations){
            System.out.println(location.toString());
        }


    }
    
}
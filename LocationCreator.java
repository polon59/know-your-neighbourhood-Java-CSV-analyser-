import java.util.ArrayList;
import java.util.List;

public class LocationCreator {
    List<Location> locations;
    FileReader fileReader;
    ArrayList<String[]> fileLines;

    public LocationCreator(){
        locations = new ArrayList<Location>();
        fileReader = new FileReader();
        fileLines = fileReader.readLocationsFromFile();
        createLocations();
    }

    public void createLocations(){

        for (String[] locationInfo : fileLines){
            String locationCategory = locationInfo[5];
            String locationName = locationInfo[4];
            String belongingCountryID = locationInfo[1];
            Location newLocation = new Location(locationName, locationCategory, belongingCountryID);
            locations.add(newLocation);
        }
    }

    public ArrayList<Location> getLocationsList(){
        return this.locations;
    }
}
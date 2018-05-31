import java.util.ArrayList;
import java.util.List;

public class LocationCreator {
    List<Location> locations;

    public LocationCreator(){
        locations = new ArrayList<Location>();
    }

    public void createLocation(String[] locationInfo){

        String locationCategory = locationInfo[5];
        String locationName = locationInfo[4];
        String belongingCountryID = locationInfo[1];

        Location newLocation = new Location(locationName, locationCategory, belongingCountryID);
        locations.add(newLocation);

            // if (locationName.equals("województwo")){
            //     System.out.println("województwo");
            // }
            // else if (locationName.equals("powiat")){
            //     System.out.println("powiat");
            // }
            // else if (locationName.equals("gmina miejska")){
            //     System.out.println("gmina miejska");
            // }
            // else if (locationName.equals("gmina wiejska")){
            //     System.out.println("gmina wiejska");
            // }
            // else if (locationName.equals("gmina miejsko-wiejska")){
            //     System.out.println("gmina miejsko-wiejska");
            // }
            // else if (locationName.equals("obszar wiejski")){
            //     System.out.println("obszar wiejski");
            // }       
            // else if (locationName.equals("miasto")){
            //     System.out.println("miasto");
            // }
            // else if (locationName.equals("delegatura")){
            //     System.out.println("delegatura");
            //     }
            // else if (locationName.equals("miasto na prawach powiatu")){
            //     System.out.println("miasto na prawach powiatu");
            // }
    }

    public ArrayList<Location> getLocationsList(){
        return this.locations;
    }
}
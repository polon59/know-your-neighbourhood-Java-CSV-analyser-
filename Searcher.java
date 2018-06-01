import java.util.HashMap;
import java.lang.Integer;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;

public class Searcher {

    private LocationsIterator locationsIterator;
    private ArrayList<Location> locations;


    public Searcher(ArrayList<Location> locations){
        this.locations = locations;
        locationsIterator = new LocationsIterator(locationsList);
    }


    public List<String> findLocationsWithManyCategories(HashMap<String, Integer> categoriesCounter){
        Set<String> locationsNames = categoriesCounter.keySet();
        List<String> locationsWithManyCategories = new ArrayList<String>();
        int numberOfLocationCategories;

        for (String locationName : locationsNames){
            numberOfLocationCategories = categoriesCounter.get(locationName);
            if (numberOfLocationCategories > 1){
                locationsWithManyCategories.add(locationName);
            }
        }
        return locationsWithManyCategories;
    }


    private String[] getSearchPatternFromInput(){
        Scanner input = new Scanner(System.in);
        String[] searchPattern = input.nextLine().split("");
        return searchPattern;
    }

    public void handleAdvancedSearch(){

    }
    
}
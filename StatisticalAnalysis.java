import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StatisticalAnalysis {

    private ArrayList<Location> locations;
    private  HashMap<String, Integer> locationsCounters;
    private LocationsIterator locationsIterator;

    public StatisticalAnalysis(ArrayList<Location> locations){
        this.locations = locations;
        this.locationsCounters = new HashMap<String, Integer>();
        this.locationsIterator = new LocationsIterator(locations);
    }


    public void countLocationsByCategory(){
        String locationCategoryName;
        String[] possibleLocationNames = {"województwo","powiat","gmina miejska","gmina wiejska",
        "gmina miejsko-wiejska","obszar wiejski","miasto","delegatura","miasto na prawach powiatu"};

        while (locationsIterator.hasNext()){
            locationCategoryName = locationsIterator.next().getCategoryName();

            for (String possibleLocation : possibleLocationNames){

                if (locationCategoryName.equals(possibleLocation))
                    incrementLocationCounter(locationCategoryName);
            }

        }
        //view.printhashmap() - here must be something like this
        System.out.println(locationsCounters.toString()); 
    }


    public void findLongestLocationsNames(){
        String shortestOfLongestName, currentName;
        int shortestOfLongestNamesIndex;
        ArrayList<String> longestLocationsNames = setInitialLongestLocationNames();
        
        while (locationsIterator.hasNext()){

            shortestOfLongestNamesIndex = findShortestLocationNameIndex(longestLocationsNames);
            shortestOfLongestName = longestLocationsNames.get(shortestOfLongestNamesIndex);
            currentName = locationsIterator.next().getName();

            if (currentName.length() > shortestOfLongestName.length()){
                longestLocationsNames.set(shortestOfLongestNamesIndex, currentName);
            }
        }

        //view.printLongestLocationNames() here must be something like this
        for (String name : longestLocationsNames){
            System.out.println(name);
        }
    }

    // this method is used to find shortest of three longest location names
    private int findShortestLocationNameIndex(ArrayList<String> longestNames){
        int shortestNameIndex = 0;
        int currentNameLength, shortestNameLength;
        
        for (int currentIndex = 0; currentIndex < longestNames.size(); currentIndex++){
            currentNameLength = longestNames.get(currentIndex).length();
            shortestNameLength = longestNames.get(shortestNameIndex).length();

            if (currentNameLength < shortestNameLength){
                shortestNameIndex = currentIndex;
            }
        }
        return shortestNameIndex;
    }


    private void incrementLocationCounter(String location){
        locationsCounters.put(location, locationsCounters.getOrDefault(location, 0) + 1);
    }


    private ArrayList<String> setInitialLongestLocationNames(){
        ArrayList<String> longestLocationsNames = new ArrayList<String>();
        
        for (int i = 0 ; i < 3; i++){
            longestLocationsNames.add(locationsIterator.next().getName());
        }
        return longestLocationsNames;
    }

}
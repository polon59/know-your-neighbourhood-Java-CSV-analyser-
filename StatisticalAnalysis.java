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
        //for (Location location : locations)

        while (locationsIterator.hasNext()){
            locationCategoryName = locationsIterator.next().getCategoryName();
            //locationCategoryName = location.getCategoryName();

            if (locationCategoryName.equals("województwo")){
                incrementLocationCounter("województwo");            
            }
            else if (locationCategoryName.equals("powiat")){
                incrementLocationCounter("powiat");
            }
            else if (locationCategoryName.equals("gmina miejska")){
                incrementLocationCounter("gmina miejska");
            }
            else if (locationCategoryName.equals("gmina wiejska")){
                incrementLocationCounter("gmina wiejska");
            }
            else if (locationCategoryName.equals("gmina miejsko-wiejska")){
                incrementLocationCounter("gmina miejsko-wiejska");
            }
            else if (locationCategoryName.equals("obszar wiejski")){
                incrementLocationCounter("obszar wiejski");
            }       
            else if (locationCategoryName.equals("miasto")){
                incrementLocationCounter("miasto");
            }
            else if (locationCategoryName.equals("delegatura")){
                incrementLocationCounter("delegatura");
            }
            else if (locationCategoryName.equals("miasto na prawach powiatu")){
                incrementLocationCounter("miasto na prawach powiatu");
                incrementLocationCounter("powiat");
            }  
        }
        //view.printhashmap() - here must be something like this
        System.out.println(locationsCounters.toString()); 
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

        for (String name : longestLocationsNames){
            System.out.println(name);
        }

        
    }
}
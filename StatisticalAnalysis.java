import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class StatisticalAnalysis {

    private ArrayList<Location> locations;
    private HashMap<String, Integer> locationsCounters;
    private HashMap<String, Integer> communityCountyCounter;
    private HashMap<String, Integer> lotationsCategoriesCounter;
    private LocationsIterator locationsIterator;
    private Searcher searchManager;
    private Display displayManager;


    public StatisticalAnalysis(ArrayList<Location> locations){
        this.locations = locations;
        this.locationsCounters = new HashMap<String, Integer>();
        this.communityCountyCounter = new HashMap<String, Integer>();
        this.lotationsCategoriesCounter = new HashMap<String, Integer>();
        this.locationsIterator = new LocationsIterator(locations);
        this.searchManager = new Searcher(locations);
        this.displayManager = new Display();
    }


    public void countLocationsByCategory(){
        String locationCategoryName;

        locationsIterator.resetIteratorIndex();
        while (locationsIterator.hasNext()){
            locationCategoryName = locationsIterator.next().getCategoryName();
      
            locationsCounters.put
            (locationCategoryName, locationsCounters.getOrDefault(locationCategoryName, 0) + 1);
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

        displayManager.printListInTable(longestLocationsNames, "NAMES");
        //view.printLongestLocationNames() print arraylist
        // for (String name : longestLocationsNames){
        //     System.out.println(name);
        //}
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


    private ArrayList<String> setInitialLongestLocationNames(){
        ArrayList<String> longestLocationsNames = new ArrayList<String>();
        
        for (int i = 0 ; i < 3; i++){
            longestLocationsNames.add(locationsIterator.next().getName());
        }
        return longestLocationsNames;
    }


    private void incrementCommunitiesCounter(String countyID){
        communityCountyCounter.put(countyID, locationsCounters.getOrDefault(countyID, 0) + 1);
    }


    private String getBiggestCountyID(){
        Set<String> possibleIDs = communityCountyCounter.keySet();
        Integer biggestCountyIDoccurency = 0;
        String biggestCountyID = "";

        for (String currentId : possibleIDs){
            if (communityCountyCounter.get(currentId) > biggestCountyIDoccurency){
                biggestCountyID = currentId;
            }
        }
        return biggestCountyID;
    }


    private String findCountyNameByID(String givenID){
        Location currentCounty;

        while (locationsIterator.hasNext()){
            currentCounty = locationsIterator.next();

            if (currentCounty.getBelongingCountyID().equals(givenID) 
                && currentCounty.getCategoryName().equals("powiat")){
                    return currentCounty.getName();
                }
        }
        return null;
    }


    public void findBiggestCountyName(){
        String currentCountyID;

        while (locationsIterator.hasNext()){
            currentCountyID = locationsIterator.next().getBelongingCountyID();
            incrementCommunitiesCounter(currentCountyID);
        }

        String biggestCountyID = getBiggestCountyID();
        String biggestCountyName = findCountyNameByID(biggestCountyID);

        System.out.println(biggestCountyName);
        // view.print normal string
    }


    private void countCategoriesForEachLocation(){
        Location currentLocation;
        String currentLocationName;

        while (locationsIterator.hasNext()){
            currentLocation = locationsIterator.next();
            currentLocationName = currentLocation.getName();

            lotationsCategoriesCounter.put
            (currentLocationName, lotationsCategoriesCounter.getOrDefault(currentLocationName, 0) + 1);
        }
    }


    public void getLocationsWithMultipleCategories(){
        countCategoriesForEachLocation();

        List<String> locationsWithMultipleCategories = searchManager.
            findLocationsWithManyCategories(lotationsCategoriesCounter);

        //view.print arraylist
        for (String name : locationsWithMultipleCategories){
            System.out.println(name); 
        }
        
    }

}
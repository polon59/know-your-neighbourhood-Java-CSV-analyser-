import java.util.HashMap;
import java.lang.Integer;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Searcher {

    private final String ANSI_WHITE = "\u001B[37m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_RESET = "\u001B[0m";
    private LocationsIterator locationsIterator;
    private ArrayList<Location> locations;


    public Searcher(ArrayList<Location> locations){
        this.locations = locations;
        locationsIterator = new LocationsIterator(locations);
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
        input.close();
        return searchPattern;
    }


    private String[] adjustNameColor(List<Integer> indexesWithGoodResult, String[] splittedName){
        for (int index : indexesWithGoodResult){
            splittedName[index] = ANSI_GREEN + splittedName[index] + ANSI_RESET;
        }
        return splittedName;
    }


    public void handleAdvancedSearch(){
        String[] pattern = getSearchPatternFromInput();
        ArrayList<String> searchResults = new ArrayList<String>();
        List<Integer> indexesWithGoodResult = new ArrayList<Integer>();
        Location currentLocation;
        int matchingLetters = 0;
        int i = 0;
        int a = 0;

        while (locationsIterator.hasNext()){
            currentLocation = locationsIterator.next();
            String[] splittedName = currentLocation.getName().split("");

            a = 0;
            i = 0;
            matchingLetters = 0;
            indexesWithGoodResult.clear();

            while (i <= pattern.length){

                while (a < splittedName.length){
                    
                    if(splittedName[a].toLowerCase().equals(pattern[i].toLowerCase())){
                        indexesWithGoodResult.add(a);
                        //splittedName[a] = ANSI_GREEN + splittedName[a] + ANSI_RESET;
                        matchingLetters++;
                        i++;
                    }
                    else{
                        i = 0;
                        matchingLetters = 0;
                        indexesWithGoodResult.clear();
                    }
                    a++;
                    if (i == pattern.length ){break;}
                }
                if (matchingLetters == pattern.length){
                    splittedName = adjustNameColor(indexesWithGoodResult, splittedName);
                    searchResults.add(String.join("", splittedName) + "---" + currentLocation.getCategoryName());
                }
                break;
            }
        }

        //view.print ARRaylist
        for (String result : searchResults){
            System.out.println(result);
        }
    }    
}